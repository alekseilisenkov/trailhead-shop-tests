package com.alexlis.helpers;

import com.alexlis.tests.TestBase;
import com.github.javafaker.Faker;

public class TestData {

    private static Faker faker = new Faker();

    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password();

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}