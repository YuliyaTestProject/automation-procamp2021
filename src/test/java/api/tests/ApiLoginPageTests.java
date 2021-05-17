package api.tests;

import api.config.ApiEndPoints;
import api.config.ApiTestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiLoginPageTests extends ApiTestConfig {

    @Test
    public void accessLoginPageTest() {
        given()
                .log().all().
                when().get(ApiEndPoints.LOGIN).
                then().
                log().all();
    }

    @Test
    public void loginWithInvalidUserTest() {
        given().body("InvalidUserCredentials.json")
                .log().all().
                when().post(ApiEndPoints.LOGIN).
                then().
                log().all();
    }
}
