#!/bin/sh
export JAVA_HOME=$JAVA_HOME_11
mvn clean test -f imports-frontend-entities/pom-sonar.xml --settings notification-schema-core/vs-maven.xml -Dmaven.repo.local=${WORKSPACE}/.m2
mvn clean test verify -f pom.xml --settings notification-schema-core/vs-maven.xml -Dmaven.repo.local=${WORKSPACE}/.m2
sed -i.bak 's/path="test/path="imports-frontend-entities\/test/g' imports-frontend-entities/coverage/unit.xml
