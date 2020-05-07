package net.avalith;

public abstract class StringsMethods {

    public StringsMethods(){
    }

    public static boolean isPalindrome(String string){
        string = string.replaceAll("[^a-zA-Z]", "");
        StringBuilder stringBuilder = new StringBuilder(string);
        String aux = (stringBuilder.reverse()).toString();
        if(aux.equalsIgnoreCase(string))
            return true;
        else
            return false;
    }
    private static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return 0;
    }
    public static Integer romanNumberToInteger(String string){
        string = string.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder(string);
        int completeValue = 0;
        int length = string.length();
        for(int i = 0; i<length; i++){
            char roman = stringBuilder.charAt(i);
            char romanNext = 0;

            if(i != length-1)
                romanNext = stringBuilder.charAt(i+1);
            int value = value(roman);
            int valueNext = value(romanNext);

            if(value<valueNext)
                value = (-value);
            completeValue += value;
        }
        return completeValue;
    }
    public static String reorderWords(String string){
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

}
