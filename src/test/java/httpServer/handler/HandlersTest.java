package httpServer.handler;

import junit.framework.Assert;
import launcher.Launcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static httpServer.handler.HttpUrlConnector.RequestMethod.GET;
import static httpServer.handler.HttpUrlConnector.RequestMethod.POST;
import static httpServer.handler.HttpUrlConnector.doHttpRequest;
import static junit.framework.Assert.*;

/**
 * @author Alexey
 */
public class HandlersTest {

    private static final Integer SERVICE_HOST_PORT = 8080;
    private static final String SERVICE_HOST_URL = "http://localhost:" + SERVICE_HOST_PORT;

    @BeforeClass
    public void setUp() throws Exception {
        //start the server
        Launcher.main(new String[]{});
    }

    @Test
    public void testAddUserIdLevelScoreHandler() throws Exception {
        doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=12&score=5661", POST);
        doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=10&score=6000", POST);
        doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=5&score=7888", POST);
        doHttpRequest(SERVICE_HOST_URL + "/postscore?user=150&level=5&score=7500", POST);
        doHttpRequest(SERVICE_HOST_URL + "/postscore?user=150&level=10&score=6555", POST);
        String result = doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=12&score=5661", POST);
        assertTrue(result.isEmpty());
    }

    @Test(dependsOnMethods = "testAddUserIdLevelScoreHandler")
    public void testGetLevelScoresByUserIdHandler() throws Exception {

        assertEquals(
                "12=5661;10=6000;5=7888;5=7500",
                doHttpRequest(SERVICE_HOST_URL + "/userscores?userid=142", GET)
        );

        assertEquals(
                "5=7500;10=6555",
                doHttpRequest(SERVICE_HOST_URL + "/userscores?userid=150", GET)
        );
    }

    @Test(dependsOnMethods = "testAddUserIdLevelScoreHandler")
    public void testGetUserIdScoreByLevelHandler() throws Exception {

        assertEquals(
                "142=5661",
                doHttpRequest(SERVICE_HOST_URL + "/levelscores?level=12", GET)
        );

        assertEquals(
                "142=6000;150=6555",
                doHttpRequest(SERVICE_HOST_URL + "/levelscores?level=10", GET)
        );

        assertEquals(
                "142=7888;150=7500",
                doHttpRequest(SERVICE_HOST_URL + "/levelscores?level=5", GET)
        );
    }
}

