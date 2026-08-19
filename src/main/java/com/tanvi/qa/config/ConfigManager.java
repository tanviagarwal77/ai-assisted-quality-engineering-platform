package com.tanvi.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public final class ConfigManager {
    private static final Set<String> SUPPORTED_ENVIRONMENTS =
        Set.of("qa", "staging", "prod");

    private static final String CONFIG_FILE = "config/config.properties";

    private static final Properties FRAMEWORK_PROPERTIES = new Properties();
    private static final Properties ENVIRONMENT_PROPERTIES = new Properties();

    static {
        loadFrameworkProperties();
       //loadEnvironmentProperties();
    }

    private ConfigManager() {
        // Prevent instantiation.
    }

    private static void loadFrameworkProperties() {
        try (InputStream inputStream =
                     ConfigManager.class.getClassLoader()
                             .getResourceAsStream(CONFIG_FILE)) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "Framework configuration file not found: " + CONFIG_FILE
                );
            }

            FRAMEWORK_PROPERTIES.load(inputStream);

        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Unable to load framework configuration: " + CONFIG_FILE,
                    exception
            );
        }
    }

private static Properties loadEnvironmentProperties() {

    String environment = getSelectedEnvironment();

    if (!SUPPORTED_ENVIRONMENTS.contains(environment)) {
        throw new IllegalArgumentException(
                "Unsupported environment: "
                        + environment
                        + ". Supported environments: "
                        + SUPPORTED_ENVIRONMENTS
        );
    }

    String environmentFile =
            "environments/" + environment + ".properties";

    Properties environmentProperties = new Properties();

    try (InputStream inputStream =
                 ConfigManager.class.getClassLoader()
                         .getResourceAsStream(environmentFile)) {

        if (inputStream == null) {
            throw new IllegalStateException(
                    "Environment configuration file not found: "
                            + environmentFile
            );
        }

        environmentProperties.load(inputStream);

    } catch (IOException exception) {
        throw new IllegalStateException(
                "Unable to load environment configuration: "
                        + environmentFile,
                exception
        );
    }

    return environmentProperties;
}
    private static String getSelectedEnvironment() {

    String environment = System.getProperty(
            "environment",
            FRAMEWORK_PROPERTIES.getProperty("environment")
    );

    if (environment == null || environment.isBlank()) {
        throw new IllegalStateException(
                "Environment is not configured."
        );
    }

    return environment.trim().toLowerCase();
}

   public static String get(String key) {

    Properties environmentProperties =
            loadEnvironmentProperties();

    String value = environmentProperties.getProperty(key);

    if (value == null || value.isBlank()) {
        value = FRAMEWORK_PROPERTIES.getProperty(key);
    }

    if (value == null || value.isBlank()) {
        throw new IllegalArgumentException(
                "Configuration property is missing or empty: " + key
        );
    }

    return value.trim();
}

   public static String getEnvironment() {
    return getSelectedEnvironment();
}

    public static String getEnvironmentName() {
        return get("environment.name");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    public static String getApiBaseUrl() {
        return get("api.base.url");
    }

    public static boolean isHeadless() {

    String headless = System.getProperty(
            "headless",
            FRAMEWORK_PROPERTIES.getProperty("headless", "false")
    );

    return Boolean.parseBoolean(headless.trim());
}

    public static int getImplicitWait() {
        return Integer.parseInt(get("implicit.wait"));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(get("explicit.wait"));
    }

    public static int getPageLoadTimeout() {
        return Integer.parseInt(get("page.load.timeout"));
    }

    public static boolean isParallelExecutionEnabled() {
        return Boolean.parseBoolean(get("parallel.execution"));
    }

    public static int getThreadCount() {
        return Integer.parseInt(get("thread.count"));
    }

    public static int getRetryCount() {
        return Integer.parseInt(get("retry.count"));
    }

    public static long getScriptTimeout() {

    return Long.parseLong(get("script.timeout")
    );
}
    
}