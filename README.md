# IPAFFS Notification Schema

The IPAFFS Notification Schema is a set of libraries that hold the notification schema itself (notification-schema.json file) along with a set of entities and classes used across frontend and backend services.

To integrate this library you should ensure you have access to the defra artifacts store so a valid settings.xml file will be required.

## Secret scanning
Secret scanning is setup using [truffleHog](https://github.com/trufflesecurity/truffleHog).
It is used as a pre-push hook and will scan any local commits being pushed

### Git hook setup

1. Install [truffleHog](https://github.com/trufflesecurity/truffleHog)
   - `brew install trufflesecurity/trufflehog/trufflehog`
2. Set DEFRA_WORKSPACE env var (`export DEFRA_WORKSPACE=/path/to/workspace`)
3. Potentially there's an older version of Trufflehog located at: `/usr/local/bin/trufflehog`. If
   so, remove this
4. Run `mvn install` to configure hooks

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

### Schema Changes
1. Make any changes required to the schema in `notification-schema-core/resources/notification-schema.json`
2. If required, update frontend schema entities in `imports-frontend-entities`
3. If required, update Java schema entities in `notification-schema-java`

### Using the Java schema entities locally
1. Run `mvn install` in the project root `imports-notification-schema` directory - using a different directory will not create all the necessary files
2. Copy the version number from `imports-notification-schema/pom.xml`, including the `-SNAPSHOT` value
3. In the microservice you are altering, add the following line to `service/pom.xml` inside the `<properties>` section:
```xml
    <tracesx.notification.schema.version>{version number here}</tracesx.notification.schema.version>
```

This line should be removed before pushing your changes - see below for how to update the schema version after merging.
