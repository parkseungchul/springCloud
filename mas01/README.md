# server list

- Auth Server (http://localhost:8887)

  - Auth Info (ID, PW, GRANT)
    - kyj password1 USER
    - psc password2 USER, ADMIN  
    
  - Request (http://localhost:8887/oauth/token)
    - Header
      - Username: eagleeye       (Auth2Config.java)
      - Password: thisissecret   (Auth2Config.java)
    - Parameter
      - grant_type: password  (Auth2Config.java)
      - scope: webclient      (Auth2Config.java)
      - username: kyj         (WebSecurityConfigurer.java)
      - password: password1    (WebSecurityConfigurer.java)
      
  - Response      
    - "access_token": "bf4773ba-bc7d-4c2d-b055-6aad52050883",
    - "token_type": "bearer",
    - "refresh_token": "cc3b8a11-8079-4bee-9aef-3b9ef5693e33",
    - "expires_in": 43199,
    - "scope": "webclient"
    
  - Request (http://localhost:8887/user)
    - Header
      - Authorization => Bearer bf4773ba-bc7d-4c2d-b055-6aad52050883
  - Response 
<pre><code>{ 
   "user":{ 
      "password":null,
      "username":"psc",
      "authorities":[ 
         { 
            "authority":"ROLE_ADMIN"
         },
         { 
            "authority":"ROLE_USER"
         }
      ],
      "accountNonExpired":true,
      "accountNonLocked":true,
      "credentialsNonExpired":true,
      "enabled":true
   },
   "authorities":[ 
      "ROLE_ADMIN",
      "ROLE_USER"
   ]
}</code></pre>  

  
- Config Server (http://localhost:8888)
  - base spring config
  - spring config : github, local file
  
- Discovery Server (http://localhost:8889)
  - base eureka
  - http://localhost:8889
  - http://localhost:8889/eureka/apps

- API Gateway (http://localhost:8880)  
  - base zuul
  - http://localhost:8880/actuator/routes
  - http://localhost:8880/order/api/svrConf/order (gateway -> order)
  - http://localhost:8880/order/api/svrConf/work (gateway -> order -> work)
  - http://localhost:8880/work/api/svrConf/work (gateway -> work)
  - http://localhost:8880/work/api/svrConf/order (gateway -> work -> order)
  - 컴피그 서버 변경 svcgate.yml -> prefix: / => prefix: /loc
    - http://localhost:8880/actuator/refresh (변경 변수 적용)
    - http://localhost:8880/loc/order/api (변경된 경로 호출)
   
- Application Order(http://localhost:8080 / 8090 )
  - order application
  - http://localhost:8080/actuator/refresh  환경변수 재로딩
  - order(local): http://localhost:8080/api/svrConf/order (로컬 변수)
  - order(remote): http://localhost:8080/api/svrConf/work (리모트 변수 @FeignClient)
  - order: http://localhost:8080/api/circuitBreaker/1 success  ( @HystrixCommand )
  - order: http://localhost:8080/api/circuitBreaker/6 fallback ( @HystrixCommand )
      
- Application Work (http://localhost:8081 / 8091 )
  - application work     
  - http://localhost:8081/actuator/refresh  환경변수 재로딩  
  - work(local): http://localhost:8081/api/svrConf/work (로컬변수)
  - work(remote): http://localhost:8081/api/svrConf/order (리모트 변수 @FeignClient)
  - work: http://localhost:8081/api/circuitBreaker/1 success ( @HystrixCommand )
  - work: http://localhost:8081/api/circuitBreaker/6 circuit breaker ( @HystrixCommand )
  
- Application Protect (http://localhost:8082 / 8092 )
  - application protect
  - http://localhost:8082/api (permit all)       
  - http://localhost:8082/actuator (permit all) 
  - http://localhost:8082/api/admin (admin)
  - http://localhost:8082/api/user (user)
  - http://localhost:8082/api/protect2 (permit all, feign call)
  
- Application Protect2 (http://localhost:8083 / 8093 )
  - application protect
  - http://localhost:8083/api (permit all)       
  - http://localhost:8083/actuator (permit all) 
  - http://localhost:8083/api/admin (admin)
  - http://localhost:8083/api/user (user)
  - http://localhost:8083/api/protect2 (permit all)
          

8/22
- pom.xml 에 dependencyManagement -> spring-cloud-dependencies 추가해줘야 Fetching config from server at : http://localhost:8888 메시지와 함께 컴피그를 바라봄  
- bootstrap.xml > application.yml 이 먼저 적용
- http://blog.leekyoungil.com/?p=352 참고

8/23 
- https://coe.gitbook.io/guide/config/springcloudconfig 를 참고하여 서버 재기동 없이 변수 변경
- 대상에 @RefreshScope, @JsonSerialize(as=ServerConfig.class) 정의되어야 실시간 변수 변경을 할수 있음

8/25
- eureka sever set up
  - ui: http://localhost:8889
  - info : http://localhost:8889/eureka/apps

8/26
- eureka feign setup (유레카를 통한 서비스 콜)
  - order(local): http://localhost:8080/api/svrConf/order
  - order(remote): http://localhost:8080/api/svrConf/work
  - work(local): http://localhost:8081/api/svrConf/work
  - work(remote): http://localhost:8081/api/svrConf/order
  
8/27
- Hystrix , fallback
  - order: http://localhost:8080/api/circuitBreaker/1 success
  - order: http://localhost:8080/api/circuitBreaker/6 fallback
  - work: http://localhost:8081/api/circuitBreaker/1 success
  - work: http://localhost:8081/api/circuitBreaker/6 circuit breaker  
  
8/29
- Hystrix thread pool detail configuration
  - http://woowabros.github.io/experience/2017/08/21/hystrix-tunning.html  

8/31
- zuul server 구현
  - zuul sever 도 결국 eureka client 일원임!
  - zuul config -> spring config 에 이관
    - spring config server 설정 변경한 이후에 동적 변경 확인

- 어플리케이션 이중 구성
  - order < docker < loc 
    - order8080.sh 
    - order8090.sh   
  - work < docker < loc
    - work8081.sh
    - work8081.sh   

9/1 
- Service gateway(zuul) filer 추가
  - trackingFiler (request uuid) -> tmx-correlation-id
  - responseFilter (response)
- order, work
  - interceptor 추가하여 들어오는 uuid 확인  
  
9/2
- OAuth2 서버 추가
  - http://localhost:8887/oauth/token 으로 토큰 발급 (현재 아이디 패스워드 하드코딩) 
  
9/8
- protect 서버 추가
  - add zuul 
  - add eureka   
  
9/16 
- protect OAuth2, JWT 추가
- protect2 추가
- protect -> protect2 Feign 으로 호출 
   
  
# case 환경 변수 전파 
1. 스프링 컴피그의 설정이 변경 actuator 확인 (재기동)
2. http://어플리케이션/actuator/refresh 로 변수 재적용
- 재적용되는 변수는 반드시 @RefreshScope, @JsonSerialize(json 변환 관련)
- 사용자 정의 변수만 리플레쉬를 사용할 수 있다. 디비정보는 될까? 되면 안되겠지 사용자 정의 변수를 디비연결 정보에 넣고 변경한다면...? 글쎄다 필요한 기능일까?




reference
 - https://www.baeldung.com/spring-boot-change-port