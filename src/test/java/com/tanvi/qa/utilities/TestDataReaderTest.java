package com.tanvi.qa.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataReaderTest {

    private static final String LOGIN_DATA =
            "testdata/login-data.properties";

    @Test
    public void shouldReadUsername() {

        String username =
                TestDataReader.get(
                        LOGIN_DATA,
                        "username"
                );

        Assert.assertEquals(
                username,
                "standard_user"
        );
    }

    @Test
    public void shouldReadPassword() {

        String password =
                TestDataReader.get(
                        LOGIN_DATA,
                        "password"
                );

        Assert.assertEquals(
                password,
                "secret_sauce"
        );
    }

    @Test
    public void shouldReadCheckoutData() {

        Assert.assertEquals(
                TestDataReader.get(
                        LOGIN_DATA,
                        "firstName"
                ),
                "Tanvi"
        );

        Assert.assertEquals(
                TestDataReader.get(
                        LOGIN_DATA,
                        "lastName"
                ),
                "QA"
        );

        Assert.assertEquals(
                TestDataReader.get(
                        LOGIN_DATA,
                        "postalCode"
                ),
                "110001"
        );
    }
}