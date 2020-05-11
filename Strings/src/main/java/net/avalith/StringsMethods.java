package net.avalith;

import java.util.HashMap;
import java.util.Map;

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
        if(aux.equalsIgnoreCase(string))
            return true;
        else
            return false;
    }
    private Integer value(Character r)
    {
        return romanValues.get(r);
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
}
