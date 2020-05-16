package org.example;

public enum CharType {
    Digits, Letters, Spaces, Another;

    public static CharType getType (Character chr){
        if(Character.isDigit(chr))
            return Digits;

        if (Character.isLetter(chr))
            return Letters;

        if(Character.isSpaceChar(chr))
            return Spaces;

        return Another;
    }
}
