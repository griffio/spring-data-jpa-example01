## spring-data-jpa-example01

### Spring 4, Spring Data JPA and QueryDsl

Using spring.dependency-management and spring data release train version

~~~groovy
plugins {
  id "java"
  id "io.spring.dependency-management" version "0.5.2.RELEASE"
  id "com.ewerk.gradle.plugins.querydsl" version "1.0.5"
}

repositories {
  jcenter()
}

dependencyManagement {
//For Spring Framework a plain version is used. For Spring Data we refer to a particular revision of a release train.
  imports {
    mavenBom "org.springframework:spring-framework-bom:$springVersion"
    mavenBom "org.springframework.data:spring-data-releasetrain:$springdataVersion"
  }
}
~~~

Using Java Config for Spring

[com.ewerk.gradle.plugins.querydsl](https://github.com/ewerk/gradle-plugins/tree/master/plugins/querydsl-plugin) is used to generated Querydsl models.

### Gradle

~~~
./gradlew compileJava
~~~

~~~
./gradlew test
~~~

When there are several large frameworks in use, to manage transitive dependencies, it is easier to use group overrides to specify the exact version with a fail on conflict mode, to be notified of any corrections, rather than adding 'force' or 'excludes' at the dependency level.


