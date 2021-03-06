package com.example.service.user.utils;

import com.example.service.user.domain.FullName;
import com.example.service.user.domain.Phone;
import com.example.service.user.domain.UserId;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class DataFaker {

    private static final Faker FAKER = new Faker();

    private static final FakeValuesService FAKE_VALUES_SERVICE = new FakeValuesService(Locale.CANADA, new RandomService());

    public static UserId fakeUserId() {
        return UserId.of(fakeUserIdAsInt());
    }

    public static int fakeUserIdAsInt() {
        return FAKER.number().numberBetween(1, 10000);
    }

    public static FullName fakeFullName() {
        return FullName.of(FAKER.name().firstName(), FAKER.name().nameWithMiddle(), FAKER.name().lastName());
    }

    public static Phone fakePhone() {
        return Phone.of(fakePhoneNumberAsString());
    }

    private static String fakePhoneNumberAsString() {
        return FAKE_VALUES_SERVICE.regexify("\\(\\+[1-9]\\d{1,2}\\) [0-9]{1,3}[0-9\\-]{6,9}[0-9]{1}");
    }

}
