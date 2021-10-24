# LightFeather Backend Engineer API Challenge

This is for the LightFeather Backend Engineer API Challenge. It is a simple API with GET and POST commands

## Description

The project is coded entirely in Java. There are to object classes Manager and Employee. As well as 2 class files GetHandler and PostHandler. Each to fulfill the requiremets of the GET and POST commands respectively. It utilizes HttpURLConnections with a requestMethod of either POST or GET. This implementation does not use the SpringBoot framework.

The First requirement of the challenge was to have an endpoint or command of GET/api/supervisor. However I believe this to be a typo in the handout. In the bullet points the command is supposed to reach GET https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers which is GET/api/managers, so that is what is implemeneted here. 

The Second requirement of the challenge was to have a POST/api/submit command that the user culd send along with user provided fields. These fields were to be firstName, lastName, email, phoneNumber, and supervisor. The firstName, lastName, and supervisor fields are required fields. To submit a request with email or supervisor empty simply type "null" in the correseponding place in the string.

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing program.
* ex. Windows 10

### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program

* How to run the program
* Step-by-step bullets
```
code blocks for commands
```

## Help

Any advise for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributors names and contact info

Zechariah Early
zechearly@gmail.com

## Version History

* 0.1
    * Initial Commit (Setting up Repo and creating README file)
* 0.2
    * Completed the GET command of the project
* 0.3
    * Completed the POST command of the project
