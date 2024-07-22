package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class LabseqResourceTest {

    @Test
    public void testGetLabseqValue() {
        RestAssured.given()
                .when().get("/labseq/1000")
                .then()
                .statusCode(200)
                .body(equalTo("167160955464809121248529556576412921573832214518206312831697195479802277127983539364995"));
    }

    @Test
    public void testGetLabseqValueNotFound() {
        RestAssured.given()
                .when().get("/labseq/invalid")
                .then()
                .statusCode(400);
    }
}