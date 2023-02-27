package ru.geekbrains.Homework3;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularApiMealPlanTest extends AbstractTest {

    @Test
    void mealPlanTest() {
        String id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", "ce9ee9517c044a95983df81c6a10902c8983774b")
                .body("{\n"
                        + " \"date\": 1677569351,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .log().uri()
                .when()
                .post("https://api.spoonacular.com/mealplanner/tatiana1/items")
                .then()
                .statusCode(200)
                .log().status()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "5ded3b38886d391babc5b0a2451ad509768cfb11")
                .queryParam("apiKey", getApiKey())
                .log()
                .uri()
                .delete("https://api.spoonacular.com/mealplanner/antil_anton_73/items/" + id)
                .then()
                .statusCode(200)
                .log()
                .status();
    }
}
