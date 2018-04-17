package com.segware.nullutils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NullUtilsTest {

    class Country {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

    class Person {
        private String name;
        private Country country;

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public Country getCountry() {
            return country;
        }

        public void setCountry(final Country country) {
            this.country = country;
        }
    }

    @Test
    public void checkNulNameFromPersonObject() {
        final Person person = new Person();
        final boolean checkNotNull = NullUtils.isNotNull(person, "getName");

        assertFalse(checkNotNull);
    }

    @Test
    public void checkNameFromPersonObject() {
        final Person person = new Person();
        person.setName("Reips");
        final boolean checkNotNull = NullUtils.isNotNull(person, "getName");

        assertTrue(checkNotNull);
    }

    @Test
    public void checkCountryNameFromPersonObject() {
        final Person person = new Person();
        final Country country = new Country();
        country.setName("Brasil");
        person.setCountry(country);

        final boolean checkNotNull = NullUtils.isNotNull(person, "getCountry.getName");

        assertTrue(checkNotNull);
    }

    @Test
    public void checkNullCountryNameFromPersonObject() {
        final Person person = new Person();
        final boolean checkNotNull = NullUtils.isNotNull(person, "getCountry.getName");

        assertFalse(checkNotNull);
    }
}
