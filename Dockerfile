FROM openjdk:8
EXPOSE 8080
ADD target/cicdSeleniumFramework.jar cicdSeleniumFramework.jar 
ENTRYPOINT ["java","-jar", "cicdSeleniumFramework.jar"]