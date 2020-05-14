package org.example.exercise4;

import java.io.IOException;

public interface IStringFunction<String, R> {
    R apply(String t) throws Exception;
}
