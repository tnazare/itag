package com.cl2.itag;


import com.cl2.itag.model.Box;
import com.jayway.restassured.config.ConnectionConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import flexjson.JSONSerializer;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class BoxResourceTest {


    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("box").request().get(String.class);
        assertEquals("test", responseMsg);
    }

    @Test
    public void testPut() {
        Box boxet = new Box();
        boxet.setId(12);
        boxet.setContent(new ArrayList<String>(Arrays.asList("tasses", "mugs", "plates")));
        boxet.setCreationDate(new Date());

        JSONSerializer serializer = new JSONSerializer();
        String boxet_serialized = serializer.serialize(boxet);
        expect().statusCode(Response.Status.CREATED.getStatusCode())
            .given()
            .put("http://localhost:8080/myapp/box/" + boxet_serialized);
    }
}
