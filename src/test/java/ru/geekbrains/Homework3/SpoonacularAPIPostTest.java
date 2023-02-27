package ru.geekbrains.Homework3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpoonacularAPIPostTest extends AbstractTest{

    @Test
    void postClassifyCuisineItalianTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Fresh rolls")
                .formParam("ingredientList", "rice mango avocado")
                .log()
                .uri()
                .when()
                .post(getClassifyCuisineUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is ("Italian"))
                .log()
                .status();
    }

    @Test
    void postClassifyCuisineBritishTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Fish and Chips")
                .formParam("ingredientList", "cod batter potato")
                .log()
                .uri()
                .when()
                .post(getClassifyCuisineUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is ("British"))
                .log()
                .status();
    }

    @Test
    void postClassifyCuisineMexicanTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Quesadilla")
                .formParam("ingredientList", "Tortillas Chicken breast Corn Cheese Tomato sauce")
                .log()
                .uri()
                .when()
                .post(getClassifyCuisineUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is ("Mexican"))
                .log()
                .status();
    }

    @Test
    void postClassifyCuisineAmericanTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Caesar salad")
                .formParam("ingredientList", "Chicken breast Letucce Parmesan Tomato cherry Caesar sauce Crackers")
                .log()
                .uri()
                .when()
                .post(getClassifyCuisineUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is ("American"))
                .log()
                .status();
    }

    @Test
    void postClassifyCuisineItalianDessertTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("language", "en")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Strawberry shake")
                .formParam("ingredientList", "Strawberries Milk Sugar")
                .log()
                .uri()
                .when()
                .post(getClassifyCuisineUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("cuisine", is ("Italian"))
                .log()
                .status();
    }
}
