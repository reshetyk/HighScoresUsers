package httpServer.handler;

import junit.framework.Assert;
import launcher.Launcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static httpServer.handler.HttpUrlConnector.RequestMethod.GET;
import static httpServer.handler.HttpUrlConnector.RequestMethod.POST;
import static httpServer.handler.HttpUrlConnector.doHttpRequest;

/**
 * @author Alexey
 */
public class HandlersTest {

    private static final Integer SERVICE_HOST_PORT = 8080;
    private static final String SERVICE_HOST_URL = "http://localhost:" + SERVICE_HOST_PORT;

    @BeforeClass
    public void setUp() throws Exception {
        Launcher.main(new String[]{});
    }

    @Test
    public void testAddUserIdLevelScoreHandler() throws Exception {
        String result = doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=12&score=5661", POST);
        Assert.assertTrue(result.isEmpty());
    }

    @Test(dependsOnMethods = "testAddUserIdLevelScoreHandler")
    public void testGetLevelScoresByUserIdHandler() throws Exception {
        String result = doHttpRequest(SERVICE_HOST_URL + "/userscores?userid=142", GET);
        Assert.assertEquals("12=5661", result);
    }

    @Test(dependsOnMethods = "testAddUserIdLevelScoreHandler")
    public void testGetUserIdScoreByLevelHandler() throws Exception {
        String result = doHttpRequest(SERVICE_HOST_URL + "/levelscores?user=142&level=12&score=5661", GET);
        Assert.assertEquals("142=5661", result);
    }
}

