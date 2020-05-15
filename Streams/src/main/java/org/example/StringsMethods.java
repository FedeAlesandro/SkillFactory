package org.example;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsMethods {

    public StringsMethods(){

    }
    public List<String> removeEvenLength(List<String> strings){
        return strings.stream()
                .filter(string -> string.length() % 2 != 0)
                .collect(Collectors.toList());
    }
    public String countDifferentCharacters(String string){
        
        return "Digits: " + string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches("[0-9]"))
                .count()
                + ", letters: " + string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches("[A-Za-zÀ-ÖØ-öø-ÿ]"))
                .count()
                + ", spaces: " + string.chars()
                .mapToObj(chr -> String.valueOf((char) chr))
                .filter(chr -> chr.matches(("[' ']")))
                .count();
    }
    // I'm not considering the ñ because instead of receiving a 164, I'm receiving another ASCII code, also when I print 'ñ' in a System.out,
    // it doesn't print as it should be and the UTF is right
    public String caesarCipher(String string){
        StringBuilder characters = new StringBuilder("");

        string.chars()
                .forEach(chr ->
                {
                    if(chr == 122) // z then add a
                        characters.append((char)97);
                    if(chr !=122)
                        characters.append((char)(chr+1));
                });

        return characters.toString();
    }
    public String reorderWords(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        string = (stringBuilder.reverse()).toString();

        return Stream.of(string.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining());
    }

}
