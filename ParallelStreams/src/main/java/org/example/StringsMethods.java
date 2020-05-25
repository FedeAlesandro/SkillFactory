package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsMethods {

    public StringsMethods(){

    }
    public List<String> removeEvenLength(List<String> strings){
        return strings.parallelStream()
                .filter(string -> string.length() % 2 != 0)
                .collect(Collectors.toList());
    }
    public void countDifferentCharacters(String string){
        Map<CharType, Long>characters = string.chars()
                .parallel()
                .mapToObj(chr -> (char)chr)
                .collect(Collectors.groupingBy(CharType::getType, Collectors.counting()));
        characters.remove(CharType.Another);
        System.out.println(characters);
    }

    //No se puede hacer parallel porque acá importa el orden
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
                .parallel()
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining());
    }

}