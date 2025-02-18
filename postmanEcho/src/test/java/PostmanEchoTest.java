import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostmanEchoTest {

    private final static String BASE_URI = "https://postman-echo.com";
    private final String TEST_STRING = "This is expected to be sent back as part of response body.";

    @BeforeClass
    public void init() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test(description = "GET Request")
    public void getRequest() {
        given()
                .when().get("/get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat().statusCode(200)
                .and().body("args.foo1", is("bar1"))
                .and().body("args.foo2", is("bar2"));
    }

    @Test(description = "POST Raw Text")
    public void postRawText() {
        given()
                .body(TEST_STRING)
                .when().post("/post")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(TEST_STRING));
    }

    @Test(description = "POST Form Data")
    public void postFormData() {
        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                .when().post("/post")
                .then()
                .assertThat().statusCode(200)
                .and().body("form.foo1", is("bar1"))
                .and().body("form.foo2", is("bar2"));
    }

    @Test(description = "PUT Request")
    public void putRequest() {
        given()
                .body(TEST_STRING)
                .when().put("/put")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(TEST_STRING));
    }

    @Test(description = "PATCH Request")
    public void patchRequest() {
        given()
                .body(TEST_STRING)
                .when().patch("/patch")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(TEST_STRING));
    }

    @Test(description = "DELETE Request")
    public void deleteRequest() {
        given()
                .body(TEST_STRING)
                .when().delete("/delete")
                .then()
                .assertThat().statusCode(200)
                .and().body("data", is(TEST_STRING));
    }
}
