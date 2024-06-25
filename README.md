# StilGalleriet Backend

Project StilGalleriet is a project done as part of education. This is the backend of the StilGalleriet project.
StilGalleriet is a simulation of an online marketplace. The theme behind it is to have a place where you can trade old or unwanted clothing.

You can view StilGalleriet Frontend [here](https://github.com/Ilhamfeysel/StilGalleriet).

## Technologies and frameworks
**Apache Maven**

**Spring Framework - Spring Boot 2.3.2**

**Spring Dependencies:**
- Spring Web(RESTful API)
- Spring Boot DevTools
- Validation
- Spring Data MongoDB
- Spring Security(Authentication and Authorization)

### Programming language:
- Java 17

### Tools used
- IntelliJ IDEA
- Postman
- Git and GitHub

## Features
- User accounts
- Advertisements
- Orders
- Reviews
- Favorites

## Installation
1. Clone this repository and open it in an IDE with support for Java(IntellJ IDEA, Visual Studio Code etc.).
2. Create a "resources" folder with "application.properties" file inside the main folder. 
3. Create your MongoDB database with a collection named "roles". Insert the following documents to "roles" collection:
  ![RoleConfigSample](https://github.com/gholamimohsen/StilGalleriet/assets/144737796/9a46503c-6f56-49bd-8f16-1df8b2af1f8c)
4. Add database and JWT token information to application.properties file. Copy the code snippet to application.properties and fill/modify the fields as needed.

```java
spring.data.mongodb.uri=mongodb+srv://
spring.data.mongodb.database= YourDatabaseName
spring.data.mongodb.auto-index-creation=true

stilgalleriet.app.jwtSecret = YourEncryptionKeyMustBeQuiteLongForBetterSecurity
stilgalleriet.app.jwtExpirationMs = 86400000
stilgalleriet.app.jwtCookieName = YourCookieName
```

## API Reference
Postman documentation:
https://documenter.getpostman.com/view/32298023/2sA35Ba47h

## How to use
Refer to the Postman documentation above for APIs.

In order to start using you this application you need to register users and login with a user account.
Once you have logged in you can start to use the various APIs for Advertisement, Orders etc.

Can also be used with [StilGalleriet Frontend](https://github.com/Ilhamfeysel/StilGalleriet).

## What can be implemented
- Proper DTO for all APIs
- More exception handling
- Refactor

## Project members
- [gholamimohsen](https://github.com/gholamimohsen) - Repository owner
- [Shumisen](https://github.com/Shumisen)
- [Ilhamfeysel](https://github.com/Ilhamfeysel)
- [Fazilet1820](https://github.com/Fazilet1820)
- [DanyD4](https://github.com/DanyD4)
- [steFue](https://github.com/steFue)

##
ReadMe written by [Shumisen](https://github.com/Shumisen)
