## Build

Tell maven to build the jar inside ./target

```bash
mvn clean package
```

## Installation

```bash
# mdkdir -p dir/dir2/dir3 if sub-directories are missing
cp ./target/cat.listener-1.0.jar dgl-hybris/environment/env-dgl-YOUR-ID/hybris/config/customize/platform/tomcat/lib

# Copy the included server.xml file
cp ./server.xml dgl-hybris/environment/env-dgl-YOUR-ID/hybris/config/tomcat/conf

# Give it a try
./gradlew clean run whatever
```

## Contributing
Pull requests are welcome.

## Reference
Based on an idea found [here](https://nikitapavlenko.wordpress.com/2017/01/30/receive-notification-in-the-system-tray-on-server-startup-tomcat-hybris/).