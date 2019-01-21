# Introduction
Welcome to City Itinerary Application which main goal is to calculate shortest way to travel from one city to another , independent of the departure time. The application allows also to expose the data related with a city defined with : city, destiny city, departure time, duration, stored in a data base.

Application components are:
1.  A Spring Cloud Config server that is deployed as Docker container (GitHub-based repository https://github.com/mokhlisse/config-repository/).
2.  A Eureka server running as a Spring-Cloud based service.  This service will allow multiple service instances to register with it.
3.  A city service that will expose the data related with a route (connection between 2 cities).
4.  A itinerary service that will calculate the sortest way (in time and in connections) to travel from one city to another, independent of the departure time.
5.  A Mysql SQL database used to store the data for city service.

# Software needed
1.  Java version 1.8.
2.	Apache Maven version 3.5.4 and above.
3.	Docker (http://docker.com). I built the code using Docker V18.09.0 and above.
4.	Git Client (http://git-scm.com). I used version 2.7.4 of the git client.
5.  Spring framework

# Building the Docker Images 
To build the code as a docker image, open a command-line window change to the directory where you have downloaded source code.

Run the following maven command.  This command will execute the [Spotify docker plugin](https://github.com/spotify/docker-maven-plugin) defined in the pom.xml file.  

   **mvn clean package docker:build**

 If everything builds successfully you should see a message indicating that the build was successful.

# Running the services

Now use docker-compose to start the built image. To start the docker image, issue the following docker-compose command:

   **docker-compose -f docker/common/docker-compose.yml up**

If everything starts correctly you should see a bunch of Spring Boot information fly by on standard out.  At this point all of the services will be running.

# Testing the services

Eureka server:
- http://localhost:8761/

config server:
- http://localhost:8888/cityservice/default

city service:
- http://localhost:8080/v1/city/all
- http://localhost:8080/v1/city/adjacents/casablanca

itinerary service:
- http://localhost:8085/v1/itinerary/sortest?from=TETOUAN&to=agadir&criteria=connections
- http://localhost:8085/v1/itinerary/sortest?from=tetouan&to=dakhla