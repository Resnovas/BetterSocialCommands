```xml
<repositories>
    <repository>
        <id>local-maven-repo</id>
        <url>file:///${project.parent.basedir}/local-repo</url>
    </repository>
</repositories>
```
The dependency can be specified as for any other repository. This makes your pom repository independent. For instance, once the desired JAR is available in Maven central, you just need to delete it from your local repo and it will be pulled from the default repo.

```xml
<dependency>
    <groupId>org.apache.felix</groupId>
    <artifactId>org.apache.felix.servicebinder</artifactId>
    <version>0.9.0-SNAPSHOT</version>
</dependency>
```
The last but not least thing to do is to add the JAR file to local repository using -DlocalRepositoryPath switch like so:
```cmd
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=${project.basedir}/Dependencies/BetterSocial_v1.2-BETA.jar -DgroupId=com.alonsoaliaga -DartifactId=bettersocial -Dversion=1.2-BETA -Dpackaging=jar -DlocalRepositoryPath=${project.basedir}/Dependencies
```
Once the JAR file is installed, your Maven repo can be committed to a code repository, and the whole set-up is system independent. (Working example in GitHub).

I agree that having JARs committed to source code repo is not a good practice, but in real life, quick and dirty solutions are sometimes better than a full blown Nexus repo to host one JAR that you cannot publish.