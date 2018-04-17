### Java-null-utils

Just an experiment to use with Java somenthing like the `get` method from Javascript's `lodash`

```java
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
```

What if you need to access the country's name from Person object to pass as argument to a method?

You probably will do something like this to prevent NullPointerException
```java
if (person.getCountry() != null && person.getCountry().getName() != null) {
  myMethod(person.getCountry().getName());
}
```

With this checking you can write less code:

```java
if (NullUtils.isNotNull(person, "getCountry.getName")) {
  myMethod(person.getCountry().getName());
}
```

Take a look at test file.