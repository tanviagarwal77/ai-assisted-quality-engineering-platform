package com.tanvi.qa.api;

import com.tanvi.qa.services.PostService;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import com.tanvi.qa.models.Post;

public class PostServiceTest {

    @Test
    public void shouldGetPostById() {

        PostService postService =
                new PostService();

        Response response =
                postService.getPost(1);

        Assert.assertEquals(
                response.statusCode(),
                200,
                "GET /posts/1 should return HTTP 200"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("id"),
                1,
                "Response should contain post ID 1"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("title"),
                "Post title should be present"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("body"),
                "Post body should be present"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("userId"),
                1,
                "Post should belong to user ID 1"
        );
    }
    @Test
public void shouldReturnNotFoundForInvalidPostId() {

    PostService postService =
            new PostService();

    Response response =
            postService.getPost(9999);

    Assert.assertEquals(
            response.statusCode(),
            404,
            "Invalid post ID should return HTTP 404"
    );
}
@Test
public void shouldCreatePost() throws IOException {

    PostService postService =
            new PostService();

   Post post = new Post();

post.setTitle("AI Assisted QE Test");
post.setBody("Created using REST Assured");
post.setUserId(1);

Response response =
        postService.createPost(post);

    Assert.assertEquals(
            response.statusCode(),
            201,
            "POST /posts should return HTTP 201"
    );

    Assert.assertEquals(
            response.jsonPath().getString("title"),
            "AI Assisted QE Test",
            "Created post title should match"
    );

    Assert.assertEquals(
            response.jsonPath().getString("body"),
            "Created using REST Assured",
            "Created post body should match"
    );

    Assert.assertEquals(
            response.jsonPath().getInt("userId"),
            1,
            "Created post userId should match"
    );

    Assert.assertNotNull(
            response.jsonPath().get("id"),
            "Created post should have an ID"
    );
}
@Test
public void shouldUpdatePost() throws IOException {

    PostService postService =
            new PostService();

  Post post = new Post();

post.setId(1);
post.setTitle("Updated AI Assisted QE Test");
post.setBody("Updated using REST Assured");
post.setUserId(1);

Response response =
        postService.updatePost(
                1,
                post
        );

    Assert.assertEquals(
            response.statusCode(),
            200,
            "PUT /posts/1 should return HTTP 200"
    );

    Assert.assertEquals(
            response.jsonPath().getInt("id"),
            1,
            "Updated post ID should match"
    );

    Assert.assertEquals(
            response.jsonPath().getString("title"),
            "Updated AI Assisted QE Test",
            "Updated title should match"
    );

    Assert.assertEquals(
            response.jsonPath().getString("body"),
            "Updated using REST Assured",
            "Updated body should match"
    );
}@Test
public void shouldDeletePost() {

    PostService postService =
            new PostService();

    Response response =
            postService.deletePost(1);

    Assert.assertEquals(
            response.statusCode(),
            200,
            "DELETE /posts/1 should return HTTP 200"
    );
}
@Test
public void shouldDeserializePostResponse() {

    PostService postService =
            new PostService();

    Post post =
            postService.getPostAsModel(1);

    Assert.assertEquals(
            post.getId(),
            1,
            "Post ID should match"
    );

    Assert.assertEquals(
            post.getUserId(),
            1,
            "User ID should match"
    );

    Assert.assertNotNull(
            post.getTitle(),
            "Post title should not be null"
    );

    Assert.assertNotNull(
            post.getBody(),
            "Post body should not be null"
    );
}
@Test
public void shouldCreatePostUsingModel() {

    PostService postService =
            new PostService();

    Post post = new Post();

    post.setTitle("Model Based API Test");
    post.setBody("Created using Post model");
    post.setUserId(1);

    Response response =
            postService.createPost(post);

    Assert.assertEquals(
            response.statusCode(),
            201,
            "POST /posts should return HTTP 201"
    );

    Assert.assertEquals(
            response.jsonPath().getString("title"),
            "Model Based API Test",
            "Created title should match"
    );

    Assert.assertEquals(
            response.jsonPath().getString("body"),
            "Created using Post model",
            "Created body should match"
    );

    Assert.assertEquals(
            response.jsonPath().getInt("userId"),
            1,
            "Created userId should match"
    );

    Assert.assertNotNull(
            response.jsonPath().get("id"),
            "Created post should have an ID"
    );
}
@Test
public void shouldUpdatePostUsingModel() {

    PostService postService =
            new PostService();

    Post post = new Post();

    post.setId(1);
    post.setTitle("Model Based Update");
    post.setBody("Updated using Post model");
    post.setUserId(1);

    Response response =
            postService.updatePost(1, post);

    Assert.assertEquals(
            response.statusCode(),
            200,
            "PUT /posts/1 should return HTTP 200"
    );

    Assert.assertEquals(
            response.jsonPath().getInt("id"),
            1
    );

    Assert.assertEquals(
            response.jsonPath().getString("title"),
            "Model Based Update"
    );

    Assert.assertEquals(
            response.jsonPath().getString("body"),
            "Updated using Post model"
    );

    Assert.assertEquals(
            response.jsonPath().getInt("userId"),
            1
    );
}
}