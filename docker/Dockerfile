FROM openjdk:8-jdk
RUN useradd -ms /bin/bash ericka
USER ericka
WORKDIR /home/ericka
ADD test-0.0.1-SNAPSHOT.jar /home/ericka
ENTRYPOINT ["java","-jar", "test-0.0.1-SNAPSHOT.jar"]
