package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TestLabSeq {

    @Test
    public void testEndpoint() {
        testLabSeq(0, BigInteger.valueOf(0));
        testLabSeq(1, BigInteger.valueOf(1));
        testLabSeq(2, BigInteger.valueOf(0));
        testLabSeq(3, BigInteger.valueOf(1));
        testLabSeq(4, BigInteger.valueOf(1));
        testLabSeq(10, BigInteger.valueOf(3));
        testLabSeq(20, BigInteger.valueOf(21));
        testLabSeq(100, BigInteger.valueOf(182376579));



    }

    private void testLabSeq(int number, BigInteger labseq) {
        given()
                .when().get("/labseq/" + number)
                .then()
                .statusCode(200)
                .body(is(String.valueOf(labseq)));
    }

}