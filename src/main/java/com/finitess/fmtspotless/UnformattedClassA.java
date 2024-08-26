package com.finitess.fmtspotless;

import java.util.*;
import java.util.stream.Collectors;
import java.nio.*;
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

        List.of("1", "2",     "3").stream().map( Integer::parseInt    )

                .filter(number
                        ->
                        number % 2 == 0).map( number
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

class SomeInnerClassA


{

}