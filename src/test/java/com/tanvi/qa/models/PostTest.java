package com.tanvi.qa.models;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTest {

    @Test
    public void shouldCreatePostModel() {

        Post post = new Post();

        post.setId(1);
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setUserId(1);

        Assert.assertEquals(post.getId(), 1);
        Assert.assertEquals(post.getTitle(), "Test Title");
        Assert.assertEquals(post.getBody(), "Test Body");
        Assert.assertEquals(post.getUserId(), 1);
    }
}