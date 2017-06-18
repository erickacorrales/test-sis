FROM openjdk:8-jdk
ARG JARFILE
RUN useradd -ms /bin/bash ericka
USER ericka
WORKDIR /home/ericka
ADD $JARFILE /home/ericka/application.jar
ENTRYPOINT ["java","-jar", "application.jar"]
