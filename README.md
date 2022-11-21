# Java Utils

My personal Java utilities and helper library. Also acts as a test on how to use GitHub Packages.

## How to use the library

To use the library you have to add the maven repo and the dependency as shown in the examples below.
It requires authentification even though the library is public I think. 
For more information please see the documentations of GitHub Packges. The [Maven documentation](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages) or the [Gradle documentation](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry).

### Maven

```maven

<dependency>
  <groupId>de.kaikarren.utils</groupId>
  <artifactId>java-utils</artifactId>
  <version>0.1.1</version>
</dependency>

```

### Gradle (Groovy DSL)
```groovy

repositories {
    mavenCentral()

    maven {
        url = uri("https://maven.pkg.github.com/kai-karren/java-utils")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }

}

dependencies {
    implementation 'de.kaikarren.utils:java-utils:0.1.1'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.9.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.9.0'
}

```
