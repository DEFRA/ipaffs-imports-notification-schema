# IPAFFS Frontend Entities Schema

### Editing the IPAFFS schema for frontend microservices.

1. Open the file notification-schema.json under notification-schema-core/resources.
2. Edit notification-schema.json to make the changes needed for your task.
3. Bump up the @ipaffs/imports-frontend-entities version in the package.json and package-lock.json
in imports-frontend-entities to match with the snapshot version of the parent(without the snapshot wording), 
for example: 1.0.7 to 1.0.8
4. Add/Update respective entities under imports-frontend-entities module and the representation objects under notification-schema-java.
5. Commit your changes.

### Publishing the IPAFFS schema for frontend microservices.

Note: This is a manual step until we have pipeline changes in place for npm publishing

1. Open a terminal window.
2. Run 'npm login --registry https://artifactory.azure.defra.cloud/artifactory/api/npm/npm-snapshots-local/ --scope @ipaffs'
3. When prompted for login use your artifactory username, password and defra email address.
4. If the login was successful you will see a text 'Logged in as xxxxx.yyyyy to scope @ipaffs on https://artifactory.azure.defra.cloud/artifactory/api/npm/npm-snapshots-local/'
5. cd into imports-notification-schema/imports-frontend-entities
6. Run 'npm publish --registry https://artifactory.azure.defra.cloud/artifactory/api/npm/npm-snapshots-local/ --verbose'
7. If the publish is successful you should see a status log like the below
```
   npm notice === Tarball Details === 
   npm notice name:          @ipaffs/imports-frontend-entities       
   npm notice version:       1.0.1                                   
   npm notice package size:  18.3 kB                                 
   npm notice unpacked size: 102.7 kB                                
   npm notice shasum:        40505c289b588e7c8758f9790c6ede3170434c08
   npm notice integrity:     sha512-EnCCzK6KT2Cy9[...]DLfhLuL8O2A4w==
   npm notice total files:   52                                      
   npm notice 
   npm http fetch PUT 201 https://artifactory.azure.defra.cloud/artifactory/api/npm/npm-snapshots-local/@ipaffs%2fimports-frontend-entities 6980ms
   npm info lifecycle @ipaffs/imports-frontend-entities@1.0.1~publish: @ipaffs/imports-frontend-entities@1.0.1
   npm info lifecycle @ipaffs/imports-frontend-entities@1.0.1~postpublish: @ipaffs/imports-frontend-entities@1.0.1
   + @ipaffs/imports-frontend-entities@1.0.1
   npm verb exit [ 0, true ]
   npm timing npm Completed in 7420ms
   npm info ok
```   
 Now you can use the published artifact as a scoped dependency in all your frontend microservices.
 
##### Note : You must be logged into DEFRA vpn in order to access @ipaffs scoped dependencies. 
##### But if you have a cached version of the scoped dependency in your node_modules you won't have any problems in referring them in your micro service.
