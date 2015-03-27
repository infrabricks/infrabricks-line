package de.infrabricks.docker.maven.sample.hello;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.with;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Peter Rosbach
 * @since 27.03.15
 */
public class StatusIT {

    @Test
    public void testVersion() {
        String versionExpected = System.getProperty("tomcat.version");
        String helloUrl = System.getProperty("hello.url");

        RestAssured.baseURI = helloUrl;
        RestAssured.defaultParser = Parser.JSON;
        System.out.println("Checking URL: " + helloUrl);

        // Need to do it that way since Jolokia doesnt return application/json as mimetype by default
        JsonPath json = with(get("/status.jsp").asString());
        json.prettyPrint();
        assertEquals(versionExpected, json.get("TomcatVersion"));

        // Alternatively, set the mime type before, then Rest-assured's fluent API can be used
        given()
                .param("mimeType", "application/json")
                .get("/status.jsp")
        .then().assertThat()
                .header("content-type", containsString("application/json"))
                .statusCode(200)
                .body("TomcatVersion", equalTo(versionExpected))
                .body("Timestamp", lessThanOrEqualTo((int) (System.currentTimeMillis() / 1000)))
                .body("Date",notNullValue())
                .body("Hostname",notNullValue());

    }

}
