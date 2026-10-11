package com.tanvi.qa.integration;

public class ApiUiTestData {

    private final int userId;
    private final String title;

    public ApiUiTestData(int userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }
}