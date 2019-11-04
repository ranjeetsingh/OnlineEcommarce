# Start with a base image containing Java runtime
#FROM openjdk:8
#ADD ./target/online_ecommerce_system.jar online_ecommerce_system.jar
# Make port 8086 available to the world outside this container
#EXPOSE 8086
# Run the jar file 
#ENTRYPOINT ["java","-jar","/online_ecommerce_system.jar"]

From openjdk:8
COPY ./target/online_ecommerce_system.jar online_ecommerce_system.jar
CMD ["java","-jar","online_ecommerce_system.jar"]