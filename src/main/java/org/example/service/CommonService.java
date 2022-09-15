package org.example.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommonService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static final String BASE_URI = "https://petstore.swagger.io/v2/";

    private final RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = RestAssured.given().auth().basic("test", "abc123");
        setCommonParams();
    }

    private void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        log.info("Sending Get request to the URL " + uri);
        Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(BASE_URI + uri);
        log.info("Response status code is " + response.statusCode());
        log.info("Response body is " + response.asPrettyString());
        return response;
    }

    protected Response postRequest(String uri, Object body) {
        return requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(BASE_URI + uri);
    }

    protected void deleteRequest(String uri) {
        requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().delete(BASE_URI + uri);
    }
}
