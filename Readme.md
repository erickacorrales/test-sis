SIS TEST WITH SpringBoot

I use the following libraries for theses reason:
 - Lombok, generate Getters and Setters of models.
 - SringDataJpa, It create CRUD operations and It's easy to manage, and can build your extra functionalities depending on your project. 
 - h2database, memory database.
 - Security, Implemented Basic Http authentication. The user/password is user/user and is harcoded inside the application.

Compilation:

- mvn clean install

Docker:

The docker folder contains a Dockerfile and a the jar file. Logically in a real environment the jar file should be generated automatically and build the docker
in Jenkins or other similar tool in a CI/CD pipeline. 

The Dockerfile receive an argument JARFILE with the path to the jar file.

Instruction:
- cd docker
- docker build --build-arg JARFILE=test-0.1.0.jar -t test-sis:0.1.0 .
- docker run -p 8080:8080 test-sis:0.1.0

