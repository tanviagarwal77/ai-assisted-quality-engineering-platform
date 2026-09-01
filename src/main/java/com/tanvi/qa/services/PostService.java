package com.tanvi.qa.services;

import com.tanvi.qa.config.ConfigManager;
import io.restassured.response.Response;
import com.tanvi.qa.models.Post;

import static io.restassured.RestAssured.given;

public class PostService {

    private final String baseUrl;

    public PostService() {
        this.baseUrl = ConfigManager.getTestApiBaseUrl();
    }

    public Response getPost(int postId) {

        return given()
                .baseUri(baseUrl)
                .when()
                .get("/posts/" + postId);
    }
  

public Response deletePost(int postId) {

    return given()
            .baseUri(baseUrl)
            .when()
            .delete("/posts/" + postId);
}
public Post getPostAsModel(int postId) {

    return getPost(postId)
            .then()
            .statusCode(200)
            .extract()
            .as(Post.class);
}
public Response createPost(Post post) {

    return given()
            .baseUri(baseUrl)
            .contentType("application/json")
            .body(post)
            .when()
            .post("/posts");
}
public Response updatePost(int postId, Post post) {

    return given()
            .baseUri(baseUrl)
            .contentType("application/json")
            .body(post)
            .when()
            .put("/posts/" + postId);
}
}