FROM amazoncorretto:17
MAINTAINER heinz
COPY target/pruebasjpa-0.0.1-SNAPSHOT.jar pruebasjpa-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/pruebasjpa-0.0.1-SNAPSHOT.jar"]