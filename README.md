Product: Integration tests for WSO2 ESB EventBrite connector
Pre-requisites:

- Maven 3.x
- Java 1.6 or above

Tested Platform:

- Microsoft WINDOWS V-7
- WSO2 ESB 4.8.1

STEPS:

1. Make sure the ESB 4.8.1 zip file with latest patches available at "Integration_Test\products\esb\4.8.1\modules\distribution\target\".

2. Copy eventbrite connector zip file (eventbrite.zip) to the location "Integration_Test\products\esb\4.8.1\modules\integration\connectors\repository\"

3. Add following code block, just after the listeners block (Remove or comment all the other test blocks) in following file - "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\testng.xml"

	<test name="eventbrite-Connector-Test" preserve-order="true" verbose="2">
        <packages>
            <package name="org.wso2.carbon.connector.integration.test.eventbrite"/>
        </packages>
    </test>

4. Copy proxy files to following location "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\config\proxies\eventbrite\"

5. Copy request files to following "Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\config\restRequests\eventbrite\"

6. Edit the "eventbrite.properties" at Integration_Test\products\esb\4.8.1\modules\integration\connectors\src\test\resources\artifacts\ESB\connector\config using valid and relevant data. Parameters to be changed are mentioned below.

	- accessToken: Use the sandbox account created below no-7. Get the access token by the following URL :http://developer.eventbrite.com/documents/authentication.
	- Alternatively you can also follow the below mentioned steps to get the access token through apigee console.
		- Navigate to https://apigee.com/console/eventbrite
		- Under “Authentication” select Oauth2
		- Select sign in with eventbrite
		- Provide ur username and password on re-directed page and click allow access
		- It will come back to apigee page and click send (request URL should https://api.eventbrite.com/v1/people/~)
		- You will have access token in respose


7. Following data set can be used for the first testsuite run.

		proxyDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/proxies/eventbrite/
		requestDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/restRequests/eventbrite/
		accessToken=<Generate the access token>
		myPublicUrl=https://www.eventbriteapi.com/v3/events/12792941031/?token=NDYKPVXF2E36W57EB5B2

		publicProfileUrl=https://www.eventbriteapi.com/v3/events/12792941031/?token=NDYKPVXF2E36W57EB5B2
		userId=113395378903

			(followCompanyId: A valid id of a company, which a user needs to follow. This parameter is applicable only for the "followCompanyPage". Please give a new company id for followCompanyId parameter each time you run the integration tests.)
		Account Details:
		username: eventbritetesting@gmail.com
		password: Eventbrite123
8. Navigate to "Integration_Test\products\esb\4.8.1\modules\integration\connectors\” and run the following command.
     $ mvn clean install