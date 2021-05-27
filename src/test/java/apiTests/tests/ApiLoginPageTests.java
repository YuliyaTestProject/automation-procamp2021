package apiTests.tests;

import apiTests.clients.ApiEndPoints;
import apiTests.clients.ApiTestConfig;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiLoginPageTests extends ApiTestConfig {

    @Test
    public void accessLoginPageTest() {
        given()
                .log().all().
                when().get(ApiEndPoints.LOGIN).
                then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.HTML)
                .header("Server","nginx").
                log().all();
    }


//    @Test
//    @Ignore
//    public void loginWithInvalidUserTest() {
//       String resource =  Resources.getResource("apiData/InvalidUserCredentials").getPath();
//        File file = new File(resource);
//        given().body(file)
//                .log().all().
//                when().post(ApiEndPoints.LOGIN).
//                then().
//                log().all();
//    }
}
