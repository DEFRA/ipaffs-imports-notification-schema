#!/bin/sh
mvn clean test -f imports-frontend-entities/pom-sonar.xml --settings ./settings/maven.xml
mvn clean test verify -f pom.xml --settings ./settings/maven.xml
sed -i.bak 's/path="test/path="${pwd}/imports-frontend-entities\/test/g' imports-frontend-entities/coverage/unit.xml
cat imports-frontend-entities/coverage/unit.xml