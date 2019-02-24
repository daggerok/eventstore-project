# eventstore
Yeah... One more event sourcing and CQRS... Don't ask. It's, as usual, kind of in progress...

Travis CI build status: [![Build Status](https://travis-ci.org/daggerok/eventstore-project.svg?branch=master)](https://travis-ci.org/daggerok/eventstore-project/)

GitHub [daggerok/eventstore-project](https://github.com/daggerok/eventstore-project/) repository

Read docs on [GitHub Pages](https://daggerok.github.io/eventstore-project/)

## run database

```bash
./mvnw -f docker/h2/pom.xml -P copy ; ./mvnw -f docker/all/pom.xml -P up
```

## run eventstore

```bash
bash ./apps/h2-eventstore-app/target/*.jar
bash ./apps/h2-eventstore-app/target/*.jar
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
