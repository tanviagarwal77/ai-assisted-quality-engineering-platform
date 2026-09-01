package com.tanvi.qa.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonFileReaderTest {

    private static final String CREATE_POST =
            "src/test/resources/payloads/create-post.json";

    @Test
    public void shouldReadJsonPayload() {

        String json =
                JsonFileReader.read(CREATE_POST);

        Assert.assertNotNull(
                json,
                "JSON payload should not be null"
        );

        Assert.assertTrue(
                json.contains("AI Assisted QE Test"),
                "JSON payload should contain expected title"
        );
    }
}