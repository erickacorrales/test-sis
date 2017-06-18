SIS TEST WITH SpringBoot

I use the following libraries for theses reason:
 - Lombok, generate Getters and Setters of models.
 - SringDataJpa, It create CRUD operations and It's easy to manage, and can build your extra functionalities depending on your project. 
 - h2database, memory database.
 
Docker:
- cd docker
- docker build -t test-sis:0.0.1 .
- docker run -p 8080:8080 test-sis:0.0.1