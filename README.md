# Customer API

## API First Development
An API-first approach assumes the design and development of an application programming interface (API) comes before the implementation. Your team begins by creating an interface for their application. After the API has been developed, the team will rely on this interface to build the rest of the application.

## Swagger OpenAPI Specification
The *OpenAPI Specification (OAS)* defines a standard, language-agnostic interface to RESTful APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation, or through network traffic inspection. When properly defined, a consumer can understand and interact with the remote service with a minimal amount of implementation logic.

An OpenAPI definition can then be used by documentation generation tools to display the API, code generation tools to generate servers and clients in various programming languages, testing tools, and many other use cases.

**Getting Started:** [Swagger OpenAPI Specification](https://swagger.io/specification/)


## Visual Studio Code Required Plugins
Few of the extensions should be pre-installed when you install Visual Studio Code. If you can't see then install from extension tab.
* [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)
* [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
* [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
* [OpenAPI Preview](https://marketplace.visualstudio.com/items?itemName=zoellner.openapi-preview)
* [Swagger Viwer](https://marketplace.visualstudio.com/items?itemName=Arjun.swagger-viewer)
* [openapi-lint](https://marketplace.visualstudio.com/items?itemName=mermade.openapi-lint)
* [Java Code Generator](https://marketplace.visualstudio.com/items?itemName=sohibe.java-generate-setters-getters)
* [YAML](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-yaml)


## OpenShift CLI Deployment
* Login to OpenShift [OC Login](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812)
* Copy login command (Top right click on ? mark and then select Command Line Tool) and then after click on Copy Login Command.
* Open Command Line or Terminal and paste the login command.
* ***Frequently used OC commands***

   1. `oc version` - Check OC CLI Version
   2. `oc status` - Check the status
   3. `oc projects` - To see available projects
   4. `oc new-project acctrainings-firstName` - Create new project. Replace firstName with your name.
   5. `oc projects` - check again the project whether it's created
   6. `oc new-app fabric8/s2i-java:latest-java11~https://github.com/rahul0309/customer-api.git --name=customer-api` - Create new app under your project.
   7. `oc get services` - To get services
   8. `oc get pods` - To check created pods
   9. `oc get routes` - See available routes for your service.
   10. `oc expose svc/customer-api` - Expose/create route for your application.
   11. `oc get route` - This will give you route to access your deployed application.
   12. `http://copyYourUrl/customer-api/swagger-ui.html` copy your url and add and hit on the browser.
   13. `oc get pods` - Get the pod name
   14. `oc logs pod enterYourPodName` - To check logs
   15. `oc delete all --selector app=customer-api` - Delete deployment.
