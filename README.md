# IPAFFS Notification Schema

The IPAFFS Notification Schema is a set of libraries that hold the notification schema itself (notification-schema.json file) along with a set of entities and classes used across frontend and backend services.

To integrate this library you should ensure you have access to the defra artifacts store so a valid settings.xml file will be required.

## Secret scanning
Secret scanning is setup using [truffleHog](https://github.com/trufflesecurity/truffleHog).
It is used as a pre-push hook and will scan any local commits being pushed

### Pre-push hook setup
1. Install [truffleHog](https://github.com/trufflesecurity/truffleHog)
    - `brew install go`
    - `git clone https://github.com/trufflesecurity/trufflehog.git`
    - `cd trufflehog; go install`
2. Set DEFRA_WORKSPACE env var (`export DEFRA_WORKSPACE=/path/to/workspace`)
3. Potentially there's an older version of Trufflehog located at: `/usr/local/bin/trufflehog`. If so, remove this
4. Create a symlink: `ln -s ~/go/bin/truffleHog /usr/local/bin/trufflehog`
5. From this project root directory copy the pre-push hook: `cp hooks/pre-push .git/hooks/pre-push`

## Usage
To start using notification schema for backend services, you need to include the following dependencies in your .pom file:

For core notification-schema.json file:
```xml
<dependency>
    <groupId>uk.gov.defra.tracesx</groupId>
    <artifactId>notification-schema-core</artifactId>
    <version>desired version</version>
</dependency> 
```

For java representation and validation classes:
```xml
<dependency>
    <groupId>uk.gov.defra.tracesx</groupId>
    <artifactId>notification-schema-java</artifactId>
    <version>desired version</version>
</dependency> 
```

## Development

#### Editing the IPAFFS schema for frontend microservices

1. Please refer to [frontend entities README](imports-frontend-entities/README.md) for updating frontend entities

#### Testing the IPAFFS schema changes on your local machine for java microservices

1. Make your changes to the schema
2. Run `mvn install` in the `imports-notification-schema` directory - using a different directory will not create all the necessary files
3. Copy the version number from `imports-notification-schema/pom.xml`, including the `-SNAPSHOT` value
4. In the microservice you are altering, add the following line to `service/pom.xml` inside the `<properties>` section:
```xml
    <tracesx.notification.schema.version>{version number here}</tracesx.notification.schema.version>
```

This line should be removed before pushing your changes - see below for how to update the schema version after merging.

#### Publishing the IPAFFS schema for backend microservices

1. Follow the above process for updating the library.
2. Follow the normal review process and merge your changes.
3. Check that java artifacts are deployed correctly to the artifactory - this should happen automatically following a green build
4. Update the spring-boot-parent repository to use the new version of the schema - this means updating the `tracesx.notification.schema.version` property
5. Update `service/pom.xml` in the microservice(s) that need the new version of the schema - this means updating the `version` attribute inside `<parent>`
