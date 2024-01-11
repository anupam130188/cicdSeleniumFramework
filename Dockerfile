FROM openjdk:8
EXPOSE 8080
ADD target/cicdseleniumframework.jar cicdseleniumframework.jar 
ENTRYPOINT ["java","-jar", "cicdseleniumframework.jar"]