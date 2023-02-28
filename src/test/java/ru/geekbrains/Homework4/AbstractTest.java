package ru.geekbrains.Homework4;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;

    private static String searchUrl;

    private static String classifyCuisineUrl;

    private static String hash;

    protected static ResponseSpecification responseSpecification;

    protected static RequestSpecification requestSpecification;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/test/resources/my.properties");
        prop.load(configFile);

        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("base.url");
        searchUrl = prop.getProperty("search.url");
        classifyCuisineUrl = prop.getProperty("classifyCuisine.url");
        hash = prop.getProperty("hash");

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .log(LogDetail.STATUS)
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", getApiKey())
                .log(LogDetail.URI)
                .build();

        RestAssured.responseSpecification = responseSpecification;
        RestAssured.requestSpecification = requestSpecification;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getHash() {
        return hash;
    }

    public static ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
