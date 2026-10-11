package com.tanvi.qa.services;

import io.restassured.response.Response;
import com.tanvi.qa.models.Post;
import com.tanvi.qa.api.ApiSpecifications;

import static io.restassured.RestAssured.given;

public class PostService {

    

    public PostService() {
        
    }

    public Response getPost(int postId) {

        return given()
              
                .spec(ApiSpecifications.requestSpecification())
                .when()
                .get("/posts/" + postId);
    }
  

public Response deletePost(int postId) {

    return given()
            .spec(ApiSpecifications.requestSpecification())
            .when()
            .delete("/posts/" + postId);
}
public Post getPostAsModel(int postId) {

    return getPost(postId)
            .then()
            .spec(
                    ApiSpecifications
                            .successResponseSpecification()
            )
            .statusCode(200)
            .extract()
            .as(Post.class);
}
public Response createPost(Post post) {

    return given()
            .spec(ApiSpecifications.requestSpecification())
            .contentType("application/json")
            .body(post)
            .when()
            .post("/posts");
}
public Response updatePost(int postId, Post post) {

    return given()
            .spec(ApiSpecifications.requestSpecification())
            .contentType("application/json")
            .body(post)
            .when()
            .put("/posts/" + postId);
}
public Response getPostsByUserId(int userId) {

    return given()
            .spec(ApiSpecifications.requestSpecification())
            .queryParam("userId", userId)
            .when()
            .get("/posts");
}
public Response getPostWithRequestId(
        int postId,
        String requestId) {

    return given()
            .spec(ApiSpecifications.requestSpecification())
            .header("X-Request-ID", requestId)
            .when()
            .get("/posts/" + postId);
}
public Post getValidatedPostAsModel(int postId) {

    return getPost(postId)
            .then()
            .statusCode(200)
            .assertThat()
            .body(
                    io.restassured.module.jsv.JsonSchemaValidator
                            .matchesJsonSchemaInClasspath(
                                    "schemas/post-schema.json"
                            )
            )
            .extract()
            .as(Post.class);
}
}