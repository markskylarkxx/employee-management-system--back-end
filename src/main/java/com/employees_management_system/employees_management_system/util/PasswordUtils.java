package com.employees_management_system.employees_management_system.util;

import java.util.*;

public class PasswordUtils {
    private static final int SIZE = 8;
    private Random random = new Random();
    private static final List<Character> UPPERCASE_CHARS = Arrays.asList('A','B','C','D','E');
    private static final List<Character> LOWERCASE_CHARS = Arrays.asList('a','b','c','d','e');
    private static final List<Character> DIGITS = Arrays.asList('1','2','3','4','5');
    private static final List<Character> SYMBOLS = Arrays.asList('#','$','-');
    private static final List<Character> passwordGenerated = new ArrayList<>();

    public PasswordUtils getUppercaseChars(int count) {
        for(int i = 0; i < count; i++) {
            passwordGenerated.add(UPPERCASE_CHARS.get(random.nextInt(UPPERCASE_CHARS.size())));
        }
        return this;
    }

    public PasswordUtils getLowercaseChars(int count) {
        for(int i = 0; i < count; i++) {
            passwordGenerated.add( LOWERCASE_CHARS.get(random.nextInt(LOWERCASE_CHARS.size())));
        }
        return this;
    }

    public PasswordUtils getSymbols(int count) {
        for(int i = 0; i < count; i++) {
            passwordGenerated.add( SYMBOLS.get(random.nextInt(SYMBOLS.size())));
        }
        return this;
    }

    public PasswordUtils getDigits(int count) {
        for(int i = 0; i < count; i++) {
            passwordGenerated.add( DIGITS.get(random.nextInt(DIGITS.size())));
        }
        return this;
    }

    public String buildPassword() {
       StringBuilder builder = new StringBuilder();
       passwordGenerated.forEach( m ->{
               builder.append(m);
       });
       return builder.toString();
    }

    public PasswordUtils shuffle() {
        Collections.shuffle(passwordGenerated);
        return this;
    }
}
