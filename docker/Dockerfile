FROM maven

# copy the project files
COPY ./pom.xml ./pom.xml
COPY ./src ./src
COPY ./ep.sh ./ep.sh

RUN ["chmod", "+x", "ep.sh"]
RUN mvn clean install -Dmaven.test.skip=true

ENTRYPOINT ["bash", "ep.sh"]