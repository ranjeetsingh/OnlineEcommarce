# Start with a base image containing Java runtime
From openjdk:8
#copying of files into the container
COPY ./target/online_ecommerce_system.jar online_ecommerce_system.jar
# CMD sets default command and/or parameters, which can be overwritten from command line when docker container runs.
CMD ["java","-jar","online_ecommerce_system.jar"]