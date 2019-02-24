# JPA UUID [![Build Status](https://travis-ci.org/daggerok/jpa-uuid.svg?branch=master)](https://travis-ci.org/daggerok/jpa-uuid)
Using UUID as JPA entity identifier in different frameworks with on pg, mysql and h2 relational databases

## up and running needed services in docker

```bash
./mvnw -DskipTests
./mvnw -f docker/all/pom.xml -P up
```

## run h2 entity-manager app

```bash
bash ./apps/spring-boot-entity-manager-h2-app/target/*.jar
http :8080/auto message=hello-em-h2
http :8080/auto
```

## run h2 spring-data app

```bash
bash ./apps/spring-boot-spring-data-h2-app/target/*.jar
http :8080/manual message=hello-data-h2
http :8080/manual
```

## run mysql entity-manager app

```bash
bash ./apps/spring-boot-entity-manager-mysql-app/target/*.jar
http :8080/manual message=hello-em-mysql
http :8080/manual
```

## run mysql spring-data app

```bash
bash ./apps/spring-boot-spring-data-mysql-app/target/*.jar
http :8080/auto message=hello-data-mysql
http :8080/auto
```

## run postgres entity-manager app

```bash
bash ./apps/spring-boot-entity-manager-postgres-app/target/*.jar
http :8080/manual message=hello-em-postgres
http :8080/manual
```

## run postgres spring-data app

```bash
bash ./apps/spring-boot-spring-data-postgres-app/target/*.jar
http :8080/auto message=hello-data-postgres
http :8080/auto
```

## cleanup

```bash
killall -9 java
./mvnw -f docker/all/pom.xml -P down
```

## build VuePress documentation

```bash
npm i ; npm run build
```
