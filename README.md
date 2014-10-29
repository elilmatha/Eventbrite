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

	- login https://www.eventbrite.com/login/ - you may use the dummy Account details below
	- request access token
	
7. Following data set can be used for the first testsuite run.

	proxyDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/proxies/event_brite/

	proxyDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/proxies/event_brite/

	requestDirectoryRelativePath=/../src/test/resources/artifacts/ESB/config/restRequests/event_brite/
	apiUrl=https://www.eventbriteapi.com
	accessToken=HSX6X635TURH32K5CLMV
	userId=125733859887
	contactlistId=772075
	EventID=13958503259
	attendeesId=460785255
	teamId=950713
	orderId=364498473


		Account Details:
		username: eventbritetesting@gmail.com
		password: Eventbrite123
8. Navigate to "Integration_Test\products\esb\4.8.1\modules\integration\connectors\” and run the following command.
     $ mvn clean install.