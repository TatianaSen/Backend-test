package ru.geekbrains.Homework4;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson4.service.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SpoonacularAPIMealPlanTest extends AbstractTest {

    File addMeal = new File("src/test/resources/addMeal.json");

    @Test
    void addMealTest() {
        String id = given()
                .spec(getRequestSpecification())
                .queryParam("hash", getHash())
                .body(addMeal)
                .when()
                .post(Endpoints.mealPlan)
                .then()
                .spec(getResponseSpecification())
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .spec(getRequestSpecification())
                .queryParam("hash", getHash())
                .delete(Endpoints.mealPlan + id)
                .then()
                .spec(getResponseSpecification());
    }
}