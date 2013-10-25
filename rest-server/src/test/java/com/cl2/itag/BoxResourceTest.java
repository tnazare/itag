package com.cl2.itag;


import com.cl2.itag.model.Box;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void should_create_a_box_with_valid_data() {
        Box boxet = new Box();
        boxet.setId(12);
        List<String> contentList = new ArrayList<String>();
        contentList.add("plates");
        contentList.add("mugs");
        contentList.add("tasses");
        boxet.setContent(contentList);
        boxet.setCreationDate(new Date());

        ObjectMapper serializer = new ObjectMapper();
        String boxet_serialized = null;
        try {
            boxet_serialized = serializer.writerWithType(Box.class).writeValueAsString(boxet);
        } catch (IOException e) {
            System.err.println("erreur lors de la serialization");
        }

        System.out.println("http://localhost:8080/myapp/box/create/" + boxet_serialized);
        given().log().all()
                .expect().statusCode(Response.Status.CREATED.getStatusCode()).body(containsString(String.valueOf(boxet.getId())))
                .put("http://localhost:8080/myapp/box/create/" + boxet_serialized);


    }

    @Test
    public void should_not_create_a_box_with_invalid_data() {
        Box boxet = new Box();
        boxet.setId(12);
        boxet.setContent(new ArrayList<String>(Arrays.asList("tasses", "mugs", "plates")));
        boxet.setCreationDate(new Date());

        ObjectMapper serializer = new ObjectMapper();
        String boxet_serialized = null;
        try {
            boxet_serialized = serializer.writerWithType(Box.class).writeValueAsString(boxet);
        } catch (IOException e) {
            System.err.println("erreur lors de la serialization");
        }

        boxet_serialized = boxet_serialized.substring(1,4);
        System.out.println("http://localhost:8080/myapp/box/create/" + boxet_serialized);

        expect().statusCode(Response.Status.NO_CONTENT.getStatusCode())
                .given()
                .put("http://localhost:8080/myapp/box/create/" + boxet_serialized);
    }
}
