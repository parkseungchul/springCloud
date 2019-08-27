# server list

- confsvr (http://localhost:8888)
  - config server
  - spring config : github, local file
   
- order (http://localhost:8080)
  - order application
  - http://localhost:8080/actuator/refresh 이용하여 환경변수 재로딩
  - order(local): http://localhost:8080/api/svrConf/order
  - order(remote): http://localhost:8080/api/svrConf/work
  - order: http://localhost:8080/api/circuitBreaker/1 success
  - order: http://localhost:8080/api/circuitBreaker/6 fallback
      
- work (http://localhost:8081)
  - application work     
  - http://localhost:8081/actuator/refresh 이용하여 환경변수 재로딩  
  - work(local): http://localhost:8081/api/svrConf/work
  - work(remote): http://localhost:8081/api/svrConf/order  
  - work: http://localhost:8081/api/circuitBreaker/1 success
  - work: http://localhost:8081/api/circuitBreaker/6 circuit breaker  
  
# 실수했던 것들과 기억해야 될 것들
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
  
# case 환경 변수 전파 
1. 스프링 컴피그의 설정이 변경 actuator 확인 (재기동)
2. http://어플리케이션/actuator/refresh 로 변수 재적용
- 재적용되는 변수는 반드시 @RefreshScope, @JsonSerialize(json 변환 관련)
- 사용자 정의 변수만 리플레쉬를 사용할 수 있다. 디비정보는 될까? 되면 안되겠지 사용자 정의 변수를 디비연결 정보에 넣고 변경한다면...? 글쎄다 필요한 기능일까?

# 해야 할 것들
8/22
- 컴피그 서버에 설정이 변경되었을 경우 어떤 전략으로 변경된 컴피그를 어플리케이션 서비스에 전달할 것인지 확인 필요.(8/23 완료)
- 추가된 코드에 대한 테스트 케이스와 자세한 설명을 볼수 있게 만들어야 함

8/23
- 컴피그 서버가 재기동 없이 변수를 어떻게 변경하나요?

# 쓰잘데기 없는 개발 모음 아이디어
- 사용자 정의 변수가 맘대로 변경이 된다면... 해보고 싶은 삽질들이 많다.
- 예를 들어 특정 거래 인터셉터에 차단을 하는 사용자 정의 변수를 넣어두고... 다이나믹하게 거래 제어
- 로그도 다이나믹하게 변경하게 할수도 있고.. 