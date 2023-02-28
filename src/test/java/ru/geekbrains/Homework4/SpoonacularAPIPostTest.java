package ru.geekbrains.Homework4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson4.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpoonacularAPIPostTest extends AbstractTest {
    private static RequestSpecification requestPostSpecification;

    @BeforeAll
    static void beforePostTest() {
        requestPostSpecification = new RequestSpecBuilder()
                .addQueryParam("language", "en")
                .setContentType("application/x-www-form-urlencoded")
                .build();
        RestAssured.requestSpecification = requestPostSpecification;
    }

    public static RequestSpecification getRequestPostSpecification() {
        return requestPostSpecification;
    }

    @Test
    void postClassifyCuisineItalianTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Fresh rolls")
                .formParam("ingredientList", "rice mango avocado")
                .when()
                .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is ("Italian"));
    }

    @Test
    void postClassifyCuisineBritishTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Fish and Chips")
                .formParam("ingredientList", "cod batter potato")
                .when()
                .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is ("British"));
    }

    @Test
    void postClassifyCuisineMexicanTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Quesadilla")
                .formParam("ingredientList", "Tortillas Chicken breast Corn Cheese Tomato sauce")
                .when()
                .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is ("Mexican"));
    }

    @Test
    void postClassifyCuisineAmericanTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Caesar salad")
                .formParam("ingredientList", "Chicken breast Letucce Parmesan Tomato cherry Caesar sauce Crackers")
                .when()
                .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is ("American"));
    }

    @Test
    void postClassifyCuisineItalianDessertTest() {
        given()
                .spec(getRequestSpecification())
                .spec(getRequestPostSpecification())
                .formParam("title", "Strawberry shake")
                .formParam("ingredientList", "Strawberries Milk Sugar")
                .when()
                .post(getBaseUrl() + Endpoints.postClassifyCuisine)
                .then()
                .spec(getResponseSpecification())
                .body("cuisine", is ("Italian"));
    }
}
