package ru.geekbrains.Homework3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpoonacularAPIGetTest extends AbstractTest {

    @Test
    void getSearchCuisineTest(){

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "japanese")
                .log().uri()
                .when()
                .get(getSearchUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log().status();
    }

    @Test
    void getSearchDietTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "vegan")
                .log()
                .uri()
                .when()
                .get(getSearchUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log()
                .status();
    }

    @Test
    void getSearchEquipmentTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("equipment", "bowl")
                .log()
                .uri()
                .when()
                .get(getSearchUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log()
                .status();
    }

    @Test
    void getSearchIngredientsTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "rice")
                .log()
                .uri()
                .when()
                .get(getSearchUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log()
                .status();
    }

    @Test
    void getSearchTypeTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "salad")
                .log()
                .uri()
                .when()
                .get(getSearchUrl())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("totalResults", notNullValue())
                .body("results[0]", hasKey("id"))
                .body("results[0]", hasKey("title"))
                .log()
                .status();
    }


//    @Test
//    void verifyUrlTest(){
//            given()
//                .log()
//                .uri()
//                    .expect()
//                    .body("totalresults", is(30))
//                .when()
//                .get(getSearchUrl() + "?cuisine=japanese{apiKey}", getApiKey())
//                .prettyPeek()
//                .then()
//                .statusCode(200)
//                .contentType("application/json")
//                .log()
//                .status();
//
//    }
}
