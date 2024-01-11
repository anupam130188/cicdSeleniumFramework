FROM openjdk:8
EXPOSE 8080
ADD target/cicdSeleniumFramework-0.0.1-SNAPSHOT.jar cicdseleniumframework.jar 
ENTRYPOINT ["java","-jar", "cicdseleniumframework.jar"]