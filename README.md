# eventstore
Yeah... One more event sourcing and CQRS... Don't ask. It's, as usual, kind of in progress...

Travis CI build status: [![Build Status](https://travis-ci.org/daggerok/eventstore-project.svg?branch=master)](https://travis-ci.org/daggerok/eventstore-project/)

Read docs on [GitHub Pages](https://daggerok.github.io/eventstore-project/)

- Implement MessageProcessor which is processing send method execution
- Each time, when Commander.send() method is executing, MessageProcessor
  should send message via configured messaging implementation
- default messaging implementation is based on single JVM
- Message it's a base interface for interfaces: Event and Command

## similar to axon workflow to be implemented

<!--
- New Command<CommandHandler, Event> sent via Commander
- Command received and validated via CommandHandler.handle(Type) method
- In case if command validation failed, stop signal should be rise
- Otherwise, new Event should be produces
-->

## local development

```bash
./mvnw -f ./docker/h2/pom.xml -P start &
./mvnw -pl :h2-eventstore spring-boot:run
```

## docker

### run database

```bash
./mvnw -f docker/h2/pom.xml -P copy ; ./mvnw -f docker/all/pom.xml -P up
```

### run eventstore

```bash
bash ./apps/h2-eventstore-app/target/*.jar
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
