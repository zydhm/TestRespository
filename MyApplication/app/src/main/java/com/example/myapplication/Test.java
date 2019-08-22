package com.example.myapplication;

public class Test {
    public enum FormatType{
        TYPE1,TYPE2,TYPE3,TYPE4;
    }

    public static String parse1(Test.FormatType formatType){
        switch (formatType){
            case TYPE1:
                return "type1";
            case TYPE2:
                return "type2";
            case TYPE3:
                return "type3";
        }
        return "null";
    }
}
