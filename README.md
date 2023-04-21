# student-directory
Hi,

This Repo has an end point which fetches data from another API i.e. student-directory-service which is a private Repo as of now.
To fetch data, this repo is using "webclient" reactive call. Further I will be adding "feign client" call and "REST Template" call to do so.

Apart from this, the project has jenkins pipeline stages, to do gradle build, test, check code coverage using sonarqube and sonar quality gate as well.
Once the condition of quality gate is satisfied, the artifact of the projects get deployed to Nexus. Also the docker config file is present, which basically pushes the image to docker hub.

The controller has also swagger configuration, which basically gives idea about the details of the project.

Thank You.
