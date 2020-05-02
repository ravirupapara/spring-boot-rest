
#### Spring boot rest app developed with learning portal


To Use the app:

* Create a database in mysql with name `learning_portal`
* Set your database username and password in `application.yml` file
* Start your application using `mvn spring-boot:run`
* The sample data will be imported automatically from schema.sql on first time successful startup of application (Note: If you are running same app another time then don't forget to remove the `spring.datasource.initialization-mode` property from `application.yml` file otherwise you will get db insert error.)

To custumize the app:
* You can add, remove or modify any component of country taxes from `application.yml` file
* You can also add new country with taxes

 

Cheers!
