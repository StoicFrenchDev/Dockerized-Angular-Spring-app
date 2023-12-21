# docker-angular-spring-mysql

## description:

This project use docker-compose to run 3 services: 
- An angular project 
- A spring boot server
- A mysql database

There is a bind mount to hot reload for the server and the frontend
There is also a volume to store the the data saved in the mysql database. 

# To build an run dev compose
docker-compose -f docker-compose-dev.yml up --build

## Note:
The bind mount works for local dev setup only not prod 

# To build and run pro compose
docker-compose -f up --build

# To build a service only:
docker-compose build folder (frontend or backend)
