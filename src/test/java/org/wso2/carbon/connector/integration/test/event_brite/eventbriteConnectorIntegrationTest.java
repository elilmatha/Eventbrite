package org.wso2.carbon.connector.integration.test.event_brite;

import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;

import org.apache.axis2.context.ConfigurationContext;
import org.json.JSONObject;
import org.testng.Assert;
import org.json.JSONArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.automation.api.clients.proxy.admin.ProxyServiceAdminClient;
import org.wso2.carbon.automation.api.clients.utils.AuthenticateStub;
import org.wso2.carbon.automation.utils.axis2client.ConfigurationContextProvider;
import org.wso2.carbon.connector.integration.test.common.ConnectorIntegrationUtil;
import org.wso2.carbon.esb.ESBIntegrationTest;
import org.wso2.carbon.mediation.library.stub.MediationLibraryAdminServiceStub;
import org.wso2.carbon.mediation.library.stub.upload.MediationLibraryUploaderStub;

//import org.wso2.carbon.connector.integration.test.common.RestResponse;

public class eventbriteConnectorIntegrationTest extends ESBIntegrationTest {


    private static final String CONNECTOR_NAME = "event_brite";

    private MediationLibraryUploaderStub mediationLibUploadStub = null;

    private MediationLibraryAdminServiceStub adminServiceStub = null;

    private ProxyServiceAdminClient proxyAdmin;

    private String repoLocation = null;

    private String event_briteConnectorFileName = CONNECTOR_NAME + ".zip";

    private Properties event_briteConnectorProperties = null;

    private String pathToProxiesDirectory = null;

    private String pathToRequestsDirectory = null;


    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        super.init();

        ConfigurationContextProvider configurationContextProvider = ConfigurationContextProvider.getInstance();
        ConfigurationContext cc = configurationContextProvider.getConfigurationContext();
        mediationLibUploadStub = new MediationLibraryUploaderStub(cc, esbServer.getBackEndUrl() + "MediationLibraryUploader");
        AuthenticateStub.authenticateStub("admin", "admin", mediationLibUploadStub);
        adminServiceStub = new MediationLibraryAdminServiceStub(cc, esbServer.getBackEndUrl() + "MediationLibraryAdminService");

        AuthenticateStub.authenticateStub("admin", "admin", adminServiceStub);

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            repoLocation = System.getProperty("connector_repo").replace("/", "\\");
        } else {
            repoLocation = System.getProperty("connector_repo").replace("/", "/");
        }
        proxyAdmin = new ProxyServiceAdminClient(esbServer.getBackEndUrl(), esbServer.getSessionCookie());

        ConnectorIntegrationUtil.uploadConnector(repoLocation, mediationLibUploadStub, event_briteConnectorFileName);
        log.info("Sleeping for " + 30000 / 1000 + " seconds while waiting for synapse import");
        Thread.sleep(30000);

        adminServiceStub.updateStatus("{org.wso2.carbon.connector}" + CONNECTOR_NAME, CONNECTOR_NAME,
                "org.wso2.carbon.connector", "enabled");

        event_briteConnectorProperties = ConnectorIntegrationUtil.getConnectorConfigProperties(CONNECTOR_NAME);

        pathToProxiesDirectory = repoLocation + event_briteConnectorProperties.getProperty("proxyDirectoryRelativePath");
        pathToRequestsDirectory = repoLocation + event_briteConnectorProperties.getProperty("requestDirectoryRelativePath");

    }

    @Override
    protected void cleanup() {
        axis2Client.destroy();
    }



    //-------------------------------------------------------User Category----------------------------------------------------------------------------------------------------------------------------------
    /**
     * Positive test case for getUserDetails method with mandatory parameters.
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getuserdetails} integration test with mandatory parameters.")
    public void testgetUserDetailsWithMandatoryParameters() throws Exception {
    
        String jsonRequestFilePath = pathToRequestsDirectory + "getuserdetails_mandatory.txt";
        String methodName = "getuserdetails";
        
        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));
        
        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));

        
        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}

	*/



    /**
     * Negative test case for  getUserDetails method .
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getuserdetails} integration test with negative.")
    public void testgetUserDetailsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getuserdetails_negative.txt";
        String methodName = "getuserdetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 404);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    */

    /**
     * Positive test case for getUserOrder method with mandatory parameters.
     */

    /*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOrder} integration test with mandatory parameters.")
    public void testgetUserOrderWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOrder_mandatory.txt";
        String methodName = "getUserOrder";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }*/




    /**
     * Negative test case for  getUserOrder method .
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOrder} integration test with negative.")
    public void testgetUserOrderWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOrder_negative.txt";
        String methodName = "getUserOrder";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 400);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }

    */

    /**
     * Positive test case for getUserOwnedEvents method with optinal parameters.
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEvents} integration test with optinal parameters.")
    public void testgetUserOwnedEventsWithOptinalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEvents_optinal.txt";
        String methodName = "getUserOwnedEvents";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            System.out.println("22222222222"+responseHeader);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
*/


    /**
     * Negative test case for  getUserOwnedEvents method .
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEvents} integration test with negative.")
    public void testgetUserOwnedEventsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEvents_negative.txt";
        String methodName = "getUserOwnedEvents";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 400);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


    */


    /**
     * Positive test case for getUserOwnedEventsOrders method with optinal parameters.
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEventsOrders} integration test with optinal parameters.")
    public void testgetUserOwnedEventsOrdersWithOptinalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEventsOrders_optinal.txt";
        String methodName = "getUserOwnedEventsOrders";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            System.out.println("222222222223333333333"+responseHeader);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }




    }

*/



    /**
     * Negative test case for  getUserOwnedEventsOrders method .
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEventsOrders} integration test with negative.")
    public void testgetUserOwnedEventsOrdersWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEventsOrders_negative.txt";
        String methodName = "getUserOwnedEventsOrders";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 400);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


*/





/**
 * Positive test case for getUserOwnedEventAttendees method with optinal parameters.
 */
/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEventAttendees} integration test with optinal parameters.")
    public void testgetUserOwnedEventAttendeesWithOptinalParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEventAttendees_optinal.txt";
        String methodName = "getUserOwnedEventAttendees";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }




    }
*/



    /**
     * Negative test case for  getUserOwnedEventAttendees method .
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOwnedEventAttendees} integration test with negative.")
    public void testgetUserOwnedEventAttendeesWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOwnedEventAttendees_negative.txt";
        String methodName = "getUserOwnedEventAttendees";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 400);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }




*/


    /**
     * Positive test case for getUserVenues method with mandatory parameters.
     */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserVenues} integration test with mandatory parameters.")
    public void testgetUserVenuesWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserVenues_mandatory.txt";
        String methodName = "getUserVenues";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}

*/

    /**
     * Negative test case for  getUserVenues method .
     */



   /* @Test(groups = { "wso2.esb" }, description = "event_brite{getUserVenues} integration test with negative.")
    public void testgetUserVenuesWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserVenues_negative.txt";
        String methodName = "getUserVenues";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 404);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
*/






    /**
     * Positive test case for getUserOrganizers method with mandatory parameters.
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOrganizers} integration test with mandatory parameters.")
    public void testgetUserOrganizersWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOrganizers_mandatory.txt";
        String methodName = "getUserOrganizers";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);

        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}


*/
    /**
     * Negative test case for  getUserOrganizers method .
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getUserOrganizers} integration test with negative.")
    public void testgetUserOrganizersWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getUserOrganizers_negative.txt";
        String methodName = "getUserOrganizers";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 404);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }


*/


    //-------------------------------------------------------Order Category----------------------------------------------------------------------------------------------------------------------------------




    /**
     * Positive test case for getOrderDetails  method with mandatory parameters.
     */



    /*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getOrderDetails} integration test with mandatory parameters.")

    public void testgetOrderDetailsWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getOrderDetails_mandatory.txt";
        String methodName = "getOrderDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);

        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("orderId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}
*/


    /**
     * Negative test case for  getOrderDetails method .
     */



   /* @Test(groups = { "wso2.esb" }, description = "event_brite{getOrderDetails} integration test with negative.")
    public void testgetOrderDetailsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getOrderDetails_negative.txt";
        String methodName = "getOrderDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("orderId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 500);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }
*/





    //-------------------------------------------------------ContactList Category----------------------------------------------------------------------------------------------------------------------------------

/**
 * Positive test case for getContactLists method with mandatory parameters.
 */

/*

    @Test(groups = { "wso2.esb" }, description = "event_brite{getContactLists} integration test with mandatory parameters.")
    public void testgetContactListsWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getContactLists_mandatory.txt";
        String methodName = "getContactLists";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}

*/


/**
 * Negative test case for getContactLists  method .
 */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getContactLists} integration test with negative.")
    public void testgetContactListsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getContactLists_negative.txt";
        String methodName = "getContactLists";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
             Assert.assertTrue(responseHeader == 404);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }



*/



    /**
     * Positive test case for getContactListDetails method with mandatory parameters.
     */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getContactListDetails} integration test with mandatory parameters.")
    public void testgetContactListDetailsWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getContactListDetails_mandatory.txt";
        String methodName = "getContactListDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"),event_briteConnectorProperties.getProperty("contactlistId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}

*/


/**
 * Negative test case for getContactListDetails  method .
 */


/*
    @Test(groups = { "wso2.esb" }, description = "event_brite{getContactListDetails} integration test with negative.")
    public void testgetContactListDetailsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getContactListDetails_negative.txt";
        String methodName = "getContactListDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"),event_briteConnectorProperties.getProperty("contactlistId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 403);


        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }



*/




    /**
     * Positive test case for getSpecificContactListDetails method with mandatory parameters.
     */



    @Test(groups = { "wso2.esb" }, description = "event_brite{getSpecificContactListDetails} integration test with mandatory parameters.")
    public void testgetContactListDetailsWithMandatoryParameters() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getSpecificContactListDetails_mandatory.txt";
        String methodName = "getSpecificContactListDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"),event_briteConnectorProperties.getProperty("contactlistId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 200);

        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
	}




/**
 * Negative test case for getSpecificContactListDetails  method .
 */



    @Test(groups = { "wso2.esb" }, description = "event_brite{getSpecificContactListDetails} integration test with negative.")
    public void testgetSpecificContactListDetailsWithNegativeCase() throws Exception {

        String jsonRequestFilePath = pathToRequestsDirectory + "getSpecificContactListDetails_negative.txt";
        String methodName = "getSpecificContactListDetails";

        final String jsonString = ConnectorIntegrationUtil.getFileContent(jsonRequestFilePath);
        final String proxyFilePath = "file:///" + pathToProxiesDirectory+  methodName + ".xml";
        String modifiedJsonString = String.format(jsonString, event_briteConnectorProperties.getProperty("accessToken"),event_briteConnectorProperties.getProperty("userId"),event_briteConnectorProperties.getProperty("contactlistId"));

        proxyAdmin.addProxyService(new DataHandler(new URL(proxyFilePath)));


        try {
            int responseHeader = ConnectorIntegrationUtil.sendRequestToRetriveHeaders(getProxyServiceURL(methodName), modifiedJsonString);
            Assert.assertTrue(responseHeader == 403);


        } finally {
            proxyAdmin.deleteProxy(methodName);
        }
    }











}
