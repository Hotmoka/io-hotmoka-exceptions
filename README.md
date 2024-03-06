[![Java-Build Action Status](https://github.com/Hotmoka/io-hotmoka-exceptions/actions/workflows/java_build.yml/badge.svg)](https://github.com/Hotmoka/io-hotmoka-exceptions/actions)
[![Maven Central](https://img.shields.io/maven-central/v/io.hotmoka.exceptions/io-hotmoka-exceptions.svg?label=Maven%20Central)](https://central.sonatype.com/search?smo=true&q=g:io.hotmoka.exceptions)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

# Checking/unchecking of exceptions for Java's basic functional interfaces

This project provides methods for the checking and unchecking of exceptions in the basic
function interfaces used, for instance, in the Java's stream library. Namely, such
library uses functional interfaces for predicates, filters, suppliers and functions,
that forbid one to throw checked exceptions. Therefore, this makes it difficult to apply that library
with code that throws checked exceptions. This project provides then the ability to unchecked such
exceptions before using the code with the stream library, and then check them back again.

<p align="center"><img width="100" src="pics/CC_license.png" alt="This documentation is licensed under a Creative Commons Attribution 4.0 Internat
ional License"></p><p align="center">This document is licensed under a Creative Commons Attribution 4.0 International License.</p>

<p align="center">Copyright 2023 by Fausto Spoto (fausto.spoto@hotmoka.io)</p>

## Example

Assume that we want to filter the strings in a collection that satisfy a given `test()`:

```java
private boolean test(String s) throws IllegalArgumentException {
  ...
}

set.stream().filter(this::test).forEach(System.out::println);
```

This is working if `test()` does not throw any exception or if it throws unchecked exceptions only,
as in the code shown above. However, it does not compile anymore if `test()` throws a checked exception:

```java
private boolean test(String s) throws MyCheckedException {
  ...
}
```

This is because the `filter()` method requires an implementation of the functional interface
`java.util.function.Predicate`, whose only method is declared to throw no checked exceptions.
This module allows one to uncheck the `MyCheckedException` before passing `test()` to `filter()`, and then
check it back after the stream is closed:

```java
private boolean test(String s) throws MyCheckedException {
  ...
}

CheckRunnable.check(MyCheckedException.class, () ->
  set.stream().filter(UncheckPredicate.uncheck(this::test)).forEach(System.out::println)
);
```