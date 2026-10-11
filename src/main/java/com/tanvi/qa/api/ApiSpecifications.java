package com.tanvi.qa.api;

import com.tanvi.qa.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class ApiSpecifications {

    private ApiSpecifications() {
        // Utility class
    }

   public static RequestSpecification requestSpecification() {

    return new RequestSpecBuilder()
            .setBaseUri(
                    ConfigManager.getTestApiBaseUrl()
            )
            .setContentType("application/json")
            .setAccept("application/json")
            .build();
}
    public static ResponseSpecification successResponseSpecification() {

        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();
    }
}