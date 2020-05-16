package org.example;

import java.util.List;
import java.util.Map;
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
    public void countDifferentCharacters(String string){
        Map<CharType, Long>characters = string.chars()
                .mapToObj(chr -> (char)chr)
                .collect(Collectors.groupingBy(CharType::getType, Collectors.counting()));
        characters.remove(CharType.Another);
        System.out.println(characters);
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
