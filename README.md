# Java formatting (Spotless Maven plugin + Google formatter + rudikershaw Git hooks)

This is an example on how to format Java code on a `pre-commit` hook using `spotless-maven-plugin` from
Spotless, `google-java-format` formatter from Google, and `git-build-hook-maven-plugin` from rudikershaw to install
custom Git hooks.

For more up-to-date information
check [Spotless GitHub official page](https://github.com/diffplug/spotless).

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
package com.finitess.fmtcosium;

import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.UUID;


public
class  UnformattedClassA
{

    void        hello() {
//        this should return hello
        System.
                out
                .println("hello");

    }

}

class SomeInnerClassA


{

}
```

After formatting:

```java
package com.finitess.fmtcosium;

import java.util.*;

public class UnformattedClassA {

    void hello() {
        //        this should return hello
        System.out.println("hello");
    }
}

class SomeInnerClassA {}

```

### Pros

- A choice between incremental and full formatting
- Elaborate formatting configuration set (also a choice between 3 formatters - Google, Palantir, Eclipse JDT)
- Explicit control over Git hooks

### Cons

- Does not seem to detect/remove wildcard unused imports (but should be possible with some additional configuration)
- Git hooks need to be installed and maintained manually