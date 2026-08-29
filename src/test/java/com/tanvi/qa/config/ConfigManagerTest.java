package com.tanvi.qa.config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigManagerTest {

    @Test
    public void shouldLoadConfiguredEnvironment() {

        String environment = ConfigManager.getEnvironment();

        Assert.assertNotNull(
                environment,
                "Environment should not be null"
        );

        Assert.assertFalse(
                environment.isBlank(),
                "Environment should not be blank"
        );
    }

    @Test
    public void shouldLoadSupportedEnvironment() {

        String environment = ConfigManager.getEnvironment();

        Assert.assertTrue(
                environment.equals("qa")
                        || environment.equals("staging")
                        || environment.equals("prod"),
                "Environment should be one of qa, staging or prod"
        );
    }

    @Test
    public void shouldLoadBrowserFromConfiguration() {

        Assert.assertEquals(
                ConfigManager.getBrowser(),
                "chrome",
                "Browser should be loaded from framework configuration"
        );
    }

    @Test
    public void shouldLoadEnvironmentSpecificBaseUrl() {

        String environment = ConfigManager.getEnvironment();

        String expectedBaseUrl;

        switch (environment) {

            case "qa":
                expectedBaseUrl = "https://qa.example.com";
                break;

            case "staging":
                expectedBaseUrl = "https://staging.example.com";
                break;

            case "prod":
                expectedBaseUrl = "https://example.com";
                break;

            default:
                throw new IllegalStateException(
                        "Unsupported environment: " + environment
                );
        }

        Assert.assertEquals(
                ConfigManager.getBaseUrl(),
                expectedBaseUrl,
                "Base URL should match the selected environment"
        );
    }

    @Test
    public void shouldLoadTimeoutConfiguration() {

        Assert.assertEquals(
                ConfigManager.getExplicitWait(),
                10,
                "Explicit wait should be loaded from framework configuration"
        );
    }

    @Test
    public void shouldLoadEnvironmentName() {

        Assert.assertEquals(
                ConfigManager.getEnvironmentName(),
                ConfigManager.getEnvironment(),
                "Environment name should match selected environment"
        );
    }

    @Test
    public void shouldLoadApiBaseUrl() {

        String environment = ConfigManager.getEnvironment();

        String expectedApiBaseUrl;

        switch (environment) {

            case "qa":
                expectedApiBaseUrl = "https://qa-api.example.com";
                break;

            case "staging":
                expectedApiBaseUrl = "https://staging-api.example.com";
                break;

            case "prod":
                expectedApiBaseUrl = "https://api.example.com";
                break;

            default:
                throw new IllegalStateException(
                        "Unsupported environment: " + environment
                );
        }

        Assert.assertEquals(
                ConfigManager.getApiBaseUrl(),
                expectedApiBaseUrl,
                "API base URL should match the selected environment"
        );
    }
@Test
public void shouldLoadHeadlessConfiguration() {

    Assert.assertFalse(
            ConfigManager.isHeadless(),
            "Headless should default to false"
    );
}
@Test
public void shouldLoadAutBaseUrlFromConfiguration() {

    Assert.assertEquals(
            ConfigManager.getAutBaseUrl(),
            "https://www.saucedemo.com",
            "AUT base URL should be loaded from configuration"
    );
}
@Test
public void shouldLoadTestApiBaseUrl() {

    Assert.assertEquals(
            ConfigManager.getTestApiBaseUrl(),
            "https://jsonplaceholder.typicode.com",
            "Test API base URL should be loaded from configuration"
    );
}
}