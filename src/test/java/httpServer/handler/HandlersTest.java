package httpServer.handler;

import launcher.Launcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static httpServer.handler.HttpUrlConnector.RequestMethod.GET;
import static httpServer.handler.HttpUrlConnector.RequestMethod.POST;
import static httpServer.handler.HttpUrlConnector.doHttpRequest;
import static junit.framework.Assert.assertEquals;

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
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=222&level=12&score=66667777", POST)
        );
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=12&score=5661", POST)
        );
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=10&score=6000", POST)
        );
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=142&level=5&score=7888", POST)
        );
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=150&level=5&score=7500", POST)
        );
        assertEquals("",
                doHttpRequest(SERVICE_HOST_URL + "/postscore?user=150&level=10&score=6555", POST)
        );

    }

    @Test(dependsOnMethods = "testAddUserIdLevelScoreHandler")
    public void testGetLevelScoresByUserIdHandler() throws Exception {

        assertEquals(
                "5=7888;10=6000;12=5661",
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
                "222=66667777;142=5661",
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

