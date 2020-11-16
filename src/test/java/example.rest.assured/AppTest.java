/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package example.rest.assured;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void test_ResponseStatusCode200() {
        given().
            baseUri("https://jsonplaceholder.typicode.com").
        when().
            get("/todos/1").
        then()
            .statusCode(is(equalTo(200)));
    }

    @Test
    public void test_CreateResource() {
        JSONObject request = new JSONObject();
        request.put("title", "title-at-12");
        request.put("body", "body-at-12");
        request.put("userId", 192);

        given().
        baseUri("https://jsonplaceholder.typicode.com").
        body(request.toJSONString()).
        when().
           post("/posts").
        then().
           statusCode(is(equalTo(201)));
    }
}
