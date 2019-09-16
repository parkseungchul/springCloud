package com.psc.cloud.svcgate.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.psc.cloud.svcgate.config.ServiceConfig;
import com.psc.cloud.svcgate.utils.FilterUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrackingFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    public static final String AUTH_TOKEN     = "Authorization";

    @Autowired
    FilterUtils filterUtils;

    @Autowired
    ServiceConfig serviceConfig;

    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    private boolean isCorrelationIdPresent(){
        if (filterUtils.getCorrelationId() !=null){
            return true;
        }

        return false;
    }

    public final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }

    private String getProtectId(){

        String result="";
        if (filterUtils.getAuthToken()!=null){

            String authToken = filterUtils.getAuthToken().replace("Bearer ","");
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(serviceConfig.getJwtSigningKey().getBytes("UTF-8"))
                        .parseClaimsJws(authToken).getBody();
                result = (String) claims.get("protectId");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    private String generateCorrelationId(){
        return java.util.UUID.randomUUID().toString();
    }

    public Object run() {

        if (isCorrelationIdPresent()) {
            log.debug("===> tmx-correlation-id found in tracking filter: {}. jwt custom filed protectId  {} ", filterUtils.getCorrelationId(), getProtectId());
        }
        else{
            filterUtils.setCorrelationId(generateCorrelationId());
            log.debug("===> tmx-correlation-id generated in tracking filter: {}. jwt custom filed protectId  {}", filterUtils.getCorrelationId(), getProtectId());
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        log.debug("===> Processing incoming request for {}.",  ctx.getRequest().getRequestURI());
        return null;
    }
}
