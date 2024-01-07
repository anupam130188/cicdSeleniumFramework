FROM openjdk:8
EXPOSE 8080
ADD target/cicdSeleniumFramework-0.0.1-SNAPSHOT.jar cicdSeleniumFramework-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar", "cicdSeleniumFramework-0.0.1-SNAPSHOT.jar"]