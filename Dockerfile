FROM openjdk:8
EXPOSE 8080
ADD target/cicdSeleniumFramework.jar cicdseleniumframework.jar 
ENTRYPOINT ["java","-jar", "cicdseleniumframework.jar"]