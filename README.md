# spring-boot-startup
Generic application to demonstrate 5 times slower bootup times for the jar vs Application class

This is a remake of Josh Long's example used in https://www.infoq.com/presentations/spring-boot-cloud-case-study. 

It is a most generic Spring Boot application that contains one resource provided by Spring REST Data.
 
I've pushed it to GitHub in order to show 5 times slower startup when the
application is started via it's jar file.

# Timings

Timings are taken on a 2013 MacBook Pro with 2.6 GHz Intel Core i7
processors and 16 GB memory.

## Jar File Startup Timings 
* Started DemoApplication in 34.236 seconds (JVM running for 35.851)
* Started DemoApplication in 40.405 seconds (JVM running for 42.517)

## DemoApplication Startup Timings
()From IntelliJ)
* Started DemoApplication in 5.283 seconds (JVM running for 5.672) (run mode)
* Started DemoApplication in 6.62 seconds (JVM running for 7.102) (debug mode)