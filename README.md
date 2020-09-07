
This project is to highlight the basic concept (not actual framework) in API automation testing.
After understanding of this concept, you will be having a freehand to construct a appropriate framework as per your requirements.

### INSTALLATION
##### To clone project:
* git clone https://gitlab.com/revolutionit-technical-community/nsw-training/core-training/backend-api/restassured-basicconcepts.git
* cd restassured-basicconcepts (Navigate to project folder)
* mvn clean compile

##### Run Tests:
To compile and run the tests from the command line enter the command:
* mvn clean test

##### Results (TESTNG Reports):
* Html Reports at the end of execution will be available in "./surefire-reprts/index.html" of "target" folder.

##### Expected Failure:
Below two failure are expected as it require individual client keys as mentioned in respective README section of each concepts.
* [ERROR]   CookieBasedAuth.createJsessionId:34  Connect Connection refused: connect
* [ERROR]   OAuth1_Concept.postTweet:28  JsonPath Failed to parse the JSON document

##### Enhancement Required:
Below are the minimum "Enhancement Required" as per your knowledge of JAVA.
1. Building a framework using above homework application.
2. Embedding Parameterization concept (Reading data from config files, excel or json file etc)
3. Add awesome reports
4. Refer: https://www.toolsqa.com/rest-assured-tutorial/


### BASIC API METHODS: 
* Refer Package - baseRestAPIcallingConcept
* Here the idea is to get familiar while working with basic Method GET, POST, PUT, DELETE
* Test methods are available @ https://reqres.in 

### AUTHENTICATION
##### Refer Package: apiAuthConcept:
* https://www.toolsqa.com/rest-assured/authentication-and-authorization-in-rest-webservices/

##### Preemptive Basic Authentication:
* Refer apiAuthConcept.BasicAuthConcept
* This is the main auth where we explicitly sending auth credentials in the first call itself.

##### Challenged Basic Authentication:
* Share the credentials only when asked (Challenged)
  
  
# AUTHORIZATION
##### OAuth 1.0:
* Refer apiAuthConcept.OAuth1_Concept **OF** Package: apiAuthConcept

	Example: 
		* Login to an app using Gmail or FB credentials
		* Posting a tweet using API:
        	-	Create an Twitter Developer account (developer.twitter.com/en/apps)
        	-	And note the API KEY, API SECRET, CONSUMER KEY, CONSUMER SECRET
			
##### OAuth 2.0:
* Refer apiAuthConcept.OAuth2_Concept **OF** Package: apiAuthConcept
 
###### Pre-Requisite:
*	Need to register http://coop.apps.symfonycasts.com
* 	Create an sample application
 	
	Authorized to some endpoint to test positive test and unauthorized to some to test negative tests.
	Available end points are:
		# barn-unlock
		# toiletseat-down
		# chickens-feed (used in script as authorized)
		# eggs-count
		# eggs-collect (used in script as unauthorized)
		# profile

##### Cookie Based Authentication:
* This is HTTP cookies to authenticate client request and maintain session info.
* Thus server will send set of info as HEADER response for a valid request.

###### Pre-requisite:
* Install JIRA Core Docker
* Create a admin and local user (local to docker instance)
* Create a JIRA project (Key note of project "KEY")

###### To install "Docker JIRA core" 
		* https://hub.docker.com/r/cptactionhank/atlassian-jira/ (which will only create the task)
		* Command: docker run --detach --publish 8086:8080 cptactionhank/atlassian-jira:latest
		* Run "docker-machine ip default" , this will return the local docker host for docker 
		* Then simply navigate your preferred browser to http://[dockerhost]:8080 ( for windows, localhost may not work so use 192.168.99.100)
		* Finish the configuration.
		* Refer for More details: 
		-	https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
		-	https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/

# HOMEWORK (EXTRA CURRICULUM)
Below is a Test Application for some homework.
 
##### Pre-requisite: 
    node 10 or above (best to install nvm 12.10.0)
    npm install -g json-server
    json-server --watch db.json
                        
##### Testing basic API call:
    GET http://localhost:3000/comments/
    GET http://localhost:3000/profile/
    POST http://localhost:3000/posts/
    PUT http://localhost:3000/posts/{id of postToDelete}
    DEL http://localhost:3000/posts/{id of postToDelete}



