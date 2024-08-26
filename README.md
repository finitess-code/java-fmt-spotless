# Java formatting (Spotless Maven plugin + Google formatter + rudikershaw Git hooks)

This is an example on how to format Java code on a `pre-commit` hook using `spotless-maven-plugin` from
Spotless, `google-java-format` formatter from Google, and `git-build-hook-maven-plugin` from rudikershaw to install
custom Git hooks.

Git hooks should be created manually and then added to Git repo by running `./mvnw install` command.

For more up-to-date information
check [Spotless GitHub official page](https://github.com/diffplug/spotless)
and [rudikershaw Git build hook](https://github.com/rudikershaw/git-build-hook).

## Validate formatting manually

```shell
./mvnw spotless:check
```

## Format code manually

```shell
./mvnw spotless:apply
```

## Formatting outcomes

Before formatting:

```java
package com.finitess.fmtspotless;

import java.util.*;
import java.util.stream.Collectors;
import java.nio.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.UUID;


public
class UnformattedClassA {

    void hello() {
//        this should return hello
        System.
                out
                .println("hello");

        List.of("1", "2", "3").stream().map(Integer::parseInt)

                .filter(number
                        ->
                        number % 2 == 0).map(number
                        ->
                        number.toString()).

                collect(Collectors.toSet());

        //spotless:off
        System.
                out
                .println("unformatted stuff");
        //spotless:on

    }

}

class SomeInnerClassA {

}
```

After formatting:

```java
package com.finitess.fmtspotless;

import java.nio.*;
import java.util.*;
import java.util.stream.Collectors;

public class UnformattedClassA {

    void hello() {
        //        this should return hello
        System.out.println("hello");

        List.of("1", "2", "3").stream()
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .map(number -> number.toString())
                .collect(Collectors.toSet());

        // spotless:off
        System.
                out
                .println("unformatted stuff");
        //spotless:on

    }
}

class SomeInnerClassA {
}

```

### Pros

- A choice between incremental and full formatting
- Elaborate formatting configuration set (also a choice between 3 formatters - Google, Palantir, Eclipse JDT)
- Explicit control over Git hooks
- supports formatter off/on sections

### Cons

- Does not seem to detect/remove wildcard unused imports (both `google-java-format`
  and `cleanthat-javaparser-unnecessaryimport` are not able to do that)
- Git hooks need to be installed and maintained manually