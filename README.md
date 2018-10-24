# sso-tutorial
sso-tutorial  
访问资源时，filter 过滤，没有token.跳转到登录页
登录成功，jwt 写入cookie
  
## Getting Started
cd sso-resource   
mvn spring-boot:run -Dserver.port=9090  
mvn spring-boot:run -Dserver.port=9091  
  
cd sso-auth   
mvn spring-boot:run 
