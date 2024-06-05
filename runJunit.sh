#!/bin/sh
mvn clean -ntp test -f imports-frontend-entities/pom-sonar.xml --settings ./settings/maven.xml
mvn clean -ntp test verify -f pom.xml --settings ./settings/maven.xml
workspaceLocation=$(pwd | sed -e 's:/:\\/:g')
sed -i.bak "s/path=\"test/path=\"imports-frontend-entities\/test/g" imports-frontend-entities/coverage/unit.xml
sed -i.bak "s/${workspaceLocation}\/imports-frontend-entities\/src/src/g" imports-frontend-entities/coverage/lcov.info
