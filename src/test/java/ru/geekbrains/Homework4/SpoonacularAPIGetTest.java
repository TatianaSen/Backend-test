package ru.geekbrains.Homework4;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson4.service.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class SpoonacularAPIGetTest extends AbstractTest {

    private static ResponseSpecification responseGetSpecification;

    @BeforeAll
    static void beforeGetTest() {
        responseGetSpecification = new ResponseSpecBuilder()
                .expectBody("totalResults", notNullValue())
                .expectBody("results[0]", hasKey("id"))
                .expectBody("results[0]", hasKey("title"))
                .build();
        RestAssured.responseSpecification = responseGetSpecification;
    }

    public static ResponseSpecification getResponseGetSpecification() {
        return responseGetSpecification;
    }
    @Test

    void getSearchCuisineTest(){

        given()
                .spec(getRequestSpecification())
                .queryParam("cuisine", "japanese")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchDietTest(){
        given()
                .spec(getRequestSpecification())
                .queryParam("diet", "vegan")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());;
    }

    @Test
    void getSearchEquipmentTest(){
        given()
                .spec(getRequestSpecification())
                .queryParam("equipment", "bowl")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchIngredientsTest(){
        given()
                .spec(getRequestSpecification())
                .queryParam("includeIngredients", "rice")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
    }

    @Test
    void getSearchTypeTest(){
        given()
                .spec(getRequestSpecification())
                .queryParam("type", "salad")
                .when()
                .get(getBaseUrl() + Endpoints.getSearchRecipes)
                .then()
                .spec(getResponseSpecification())
                .spec(getResponseGetSpecification());
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
