package org.example;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Function<Integer, String>function =  number -> number.toString();
        System.out.println(function.apply(4));
    }
}
