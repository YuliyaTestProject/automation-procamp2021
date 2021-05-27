package api.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static api.config.ApiEndPoints.BASE_URI;

public class ApiTestConfig {
    private static final String CONTENT_TYPE="application/x-www-form-urlencoded";
    private static final String ACCEPT="application/json";
    private static final int STATUS_CODE_SUCCESS=200;

    public static RequestSpecification request;
    public static ResponseSpecification response;

    @BeforeClass
    public static void setup(){

        request = new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setBasePath("/").
                addHeader("Content-Type",CONTENT_TYPE).
                addHeader("Accept",ACCEPT).
                build();

        response = new ResponseSpecBuilder().
                expectStatusCode(STATUS_CODE_SUCCESS).
                build();

        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;

    }
}
