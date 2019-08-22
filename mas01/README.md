# server list

- confsvr 
  - config
  - spring config : github, local file 
  
- order
  - application order
    
- work
  - application work     
  
  
# 실수했던 것들과 기억해야 될 것들

- pom.xml 에 dependencyManagement -> spring-cloud-dependencies 추가해줘야 Fetching config from server at : http://localhost:8888 메시지와 함께 컴피그를 바라봄  
- bootstrap.xml > application.yml 이 먼저 적용
- 자료는 http://blog.leekyoungil.com/?p=352 참고

# 해야 할 것들
- 컴피그 서버에 설정이 변경되었을 경우 어떤 전략으로 변경된 컴피그를 어플리케이션 서비스에 전달할 것인지 확인 필요.