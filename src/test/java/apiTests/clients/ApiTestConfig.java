package apiTests.clients;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;

import static apiTests.clients.ApiEndPoints.*;

public class ApiTestConfig {
    private static final String CONTENT_TYPE="application/json";
    private static final String ACCEPT="application/json";

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
                expectStatusCode(HttpStatus.SC_OK).
                build();

        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;

    }
}
