package com.airtribe.learntrack.util;

public class InputValidator {
    public static boolean isValidString(String value){
        if (value == null || value.isEmpty()) return false;
        return true;
    }
    public static boolean isValidId(int id){
        if(id<=0)return false;
        return true;
    }
}
