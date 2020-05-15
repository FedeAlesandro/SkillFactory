package net.avalith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StringsMethods {

    private Map<Character, Integer> romanValues;

    public StringsMethods(){
        this.romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    public boolean isPalindrome(String string){
        string = string.replaceAll("[^a-zA-Z]", "");
        StringBuilder stringBuilder = new StringBuilder(string);
        String aux = (stringBuilder.reverse()).toString();
        return (aux.equalsIgnoreCase(string));
    }
    private Integer value(Character r)
    {
        return Optional.ofNullable(romanValues.get(r)).orElse(0);
    }
    public Integer romanNumberToInteger(String string){
        string = string.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(string);
        Integer completeValue = 0;
        Integer length = string.length();
        for(int i = 0; i<length; i++){
            Character roman = stringBuilder.charAt(i);
            Character romanNext = 0;

            if(i != length-1)
                romanNext = stringBuilder.charAt(i+1);
            Integer value = value(roman);
            Integer valueNext = value(romanNext);
            if(valueNext != null)
                if(value<valueNext)
                    value = (-value);
            completeValue += value;
        }
        return completeValue;
    }
    public String reorderWords(String string){
        String stringReturned = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        string = (stringBuilder.reverse()).toString();
        String[]strings = string.split(" ");
        for(int i = 0; i<strings.length; i++)
        {
            StringBuilder aux = new StringBuilder(strings[i]);
            if(i != (strings.length - 1))
                stringReturned+=(aux.reverse()).toString() + " ";
            else
                stringReturned+=strings[i]=(aux.reverse()).toString();
        }
        return stringReturned;
    }
    // It says that type Integer and Character must be primitive, is it wrong to use the wrapper?
    public String countDiferentCaracters(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        String aux = "";
        Integer digits = 0;
        Integer letters = 0;
        Integer spaces = 0;
        for(int i = 0; i<stringBuilder.length(); i++){
            Character chr = stringBuilder.charAt(i);
            aux = chr.toString();
            if(aux.matches("[A-Za-zÀ-ÖØ-öø-ÿ]")){
                letters++;
            }
            if(aux.matches("[0-9]")){
                digits++;
            }
            if(aux.matches("[' ']")){
                spaces++;
            }
        }
        return "Digits: "+ digits + ", letters: " + letters + ", spaces: " + spaces;
    }
    public String caesarCipher(String string){
        StringBuilder sb = new StringBuilder(string);
        List<Character>alphabet = new ArrayList<>();
        StringBuilder characters = new StringBuilder("");
        int index = -1;

        for(int i = 0; i < 26; i++){
            alphabet.add((char)(97 + i));
            if(97+i == 110)
                alphabet.add('ñ');
        }
        for (int i = 0; i<sb.length(); i++){
            index = alphabet.indexOf(sb.charAt(i));
            if(index==26)
                characters.append(alphabet.get(0));
            else
                characters.append(alphabet.get(index+1));
        }
        return characters.toString();
    }
    // It says that type Boolean and Character must be primitive, is it wrong to use the wrapper?
    public Boolean verifyString(String string){
        StringBuilder sb = new StringBuilder(string);
        Character chr = sb.charAt(0);
        if(chr.toString().matches("[A-Za-z0-9]")){
            if(string.matches("[A-Za-z0-9_]+")){ //I repeat this because I didnt find how to add the ' _ ' in the next line regex
                if(string.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,30}$")){
                    return true;
                }
            }
        }
        return false;
    }
}
