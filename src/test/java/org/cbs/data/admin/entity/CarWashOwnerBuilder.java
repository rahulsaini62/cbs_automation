package org.cbs.data.admin.entity;

import java.util.Locale;

import net.datafaker.Faker;

import static org.cbs.data.DataReader.loadCreateOwnerPageProps;

public class CarWashOwnerBuilder {
    private static final Faker faker = new Faker (Locale.US);

    public static CarWashOwner getCarWashOwner () {

        return CarWashOwner.builder ()
            .firstName (faker.name ()
                .firstName ())
            .lastName (faker.name ()
                .lastName ())
            .email (faker.internet ()
                .emailAddress ())
            .phoneNumber (faker.phoneNumber ()
                .phoneNumber ())
            .build ();
    }
}
