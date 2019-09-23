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
public class ResponseFilter extends ZuulFilter{
    private static final int  FILTER_ORDER=1;
    private static final boolean  SHOULD_FILTER=true;

    @Autowired
    FilterUtils filterUtils;

    @Autowired
    ServiceConfig serviceConfig;

    @Override
    public String filterType() {
        return FilterUtils.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
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


    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        log.debug("<=== Adding the correlation id to the outbound headers. {} jwt custom filed protectId  {}", filterUtils.getCorrelationId(), getProtectId());
        ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());

        log.debug("<=== Completing outgoing request for {}. jwt custom filed protectId {}", ctx.getRequest().getRequestURI(), getProtectId());

        return null;
    }
}
