# Customer API

## Objective
Add objective for this Event Source based Microservice......

![Use Case](https://github.com/rahul0309/customer-api/blob/main/src/main/resources/event_source.jpeg?raw=true)

## CDC
Change data capture is a software design pattern used to capture changes to data and take corresponding action based on that change. The change to data is usually one of read, update or delete. The corresponding action usually is supposed to occur in another system in response to the change that was made in the source system.


## Swagger OpenAPI Specification
The *OpenAPI Specification (OAS)* defines a standard, language-agnostic interface to RESTful APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation, or through network traffic inspection. When properly defined, a consumer can understand and interact with the remote service with a minimal amount of implementation logic.

An OpenAPI definition can then be used by documentation generation tools to display the API, code generation tools to generate servers and clients in various programming languages, testing tools, and many other use cases.

**Getting Started:** [Swagger OpenAPI Specification](https://swagger.io/specification/)


## Visual Studio Code Required Plugins
Few of the extensions should be pre-installed when you install Visual Studio Code. If you can't see then install from extension tab.
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
* [Java Code Generator](https://marketplace.visualstudio.com/items?itemName=sohibe.java-generate-setters-getters)


## Docker Commands
**Run following commands to install & configure Postgres DB on Docker**
```
docker run -d --name postgres -p 5432:5432 -e POSTGRES_USER=start_data_engineer \ 
-e POSTGRES_PASSWORD=password debezium/postgres:12

docker exec -ti postgres /bin/bash

cat /var/lib/postgresql/data/postgresql.conf
```
**Create the data in postgres. We use pgcli to interact with our postgres instance**
```
pgcli -h localhost -p 5432 -U start_data_engineer  (#Passowrd is password)
CREATE SCHEMA acn;
SET search_path TO acn,public;
CREATE TABLE acn.customer (
    customer_id int,
    customer_name text,
    customer_address text,
    primary key(customer_id)
);
ALTER TABLE acn.customer replica identity FULL;

```
**Install Zookeeper and Kafka on Docker**
```
docker run -d --name zookeeper -p 2181:2181 -p 2888:2888 -p 3888:3888 debezium/zookeeper:1.1

docker run -d --name kafka -p 9092:9092 --link zookeeper:zookeeper debezium/kafka:1.1
```

**Debezium - We use a kafka tool called Connect to run debezium. As the name suggests connect provides a framework to connect input data sources to kafka and connect kafka to output sinks. It runs as a separate service.**
```
docker run -d --name connect -p 8083:8083 --link kafka:kafka \
--link postgres:postgres -e BOOTSTRAP_SERVERS=kafka:9092 \
-e GROUP_ID=sde_group -e CONFIG_STORAGE_TOPIC=sde_storage_topic \
-e OFFSET_STORAGE_TOPIC=sde_offset_topic debezium/connect:1.1

curl -H "Accept:application/json" localhost:8083/connectors/
```

**Register a debezium connect service using a curl command to the connect service on port 8083**
```
curl -i -X POST -H "Accept:application/json" -H "Content-Type:application/json" \

localhost:8083/connectors/ -d '{"name": "sde-connector", "config": {"connector.class": "io.debezium.connector.postgresql.PostgresConnector", "database.hostname": "postgres", "database.port": "5432", "database.user": "start_data_engineer", "database.password": "password", "database.dbname" : "start_data_engineer", "database.server.name": "acnserver1", "table.whitelist": "acn.customer"}}'

```
**Check for presence of connector**
```curl -H "Accept:application/json" localhost:8083/connectors/```

**Consumer**
```
docker run -it --rm --name consumer --link zookeeper:zookeeper \

--link kafka:kafka debezium/kafka:1.1 watch-topic -a acnserver1.acn.customer --max-messages 1 | grep '^{' | jq
```
**Deploy customerAPI to docker & link to postgres database**
```
docker image build -t customer-api .
docker run --name customer-api --link postgres -p 9090:9090 -d customer-api
```
**Launch Swagger URL in your browser (chrome is preferred)**
```
http://localhost:9090/customer-api/swagger-ui.html
```

**GitHub Page**
`https://rahul0309.github.io/customer-api/`
