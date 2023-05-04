package com.example.lasgna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.common.collect;

public class Alphamatics {
    static ArrayList<String> listOfAlphamatics;
    static char charArray[]=new char[26];
    static Map<Character, Integer> charMap= new Map<>();
    static int countOfDistinctChars=0;

    public static Boolean doesResultStringHaveCorrectLength(ArrayList<String> strings){
        int addendMaxLength=findMaxLengthOfAddends(strings);
        int lastIndex=strings.size()-1;
        int resultStringLength=strings.get(lastIndex).length();

        if (resultStringLength> addendMaxLength +1 || resultStringLength < addendMaxLength)
            return Boolean.FALSE;
        else return  Boolean.TRUE;
    }
    public static  Boolean checkIfResultMSDOne(ArrayList<String> strings)   {
        int addendsMaxLength=findMaxLengthOfAddends(strings);
        int lastIndex=strings.size()-1;
        if(addendsMaxLength == strings.get(lastIndex).length()-1)
            return Boolean.TRUE;
        else return Boolean.FALSE;

    }

    private static int findMaxLengthOfAddends(ArrayList<String> strings) {
        int maxlength=0;
        int numOfMatics=strings.size();
        int i=0;
        //skip the result string by using upper bound : numOfMatrics-1
        while(i<numOfMatics-1)
            if (strings.get(i).length()>maxlength)
                maxlength=strings.get(i++).length();
            else i++;
        return maxlength;


    }

    public static  void initialize(ArrayList<String> alphamaticList ){
        if(findNumberOfDistinctCharsInMatics(alphamaticList)<11) {
            listOfAlphamatics = new ArrayList<>();
            listOfAlphamatics = alphamaticList;
        }else throw new RuntimeException("Please use maximum 10 distinct characters");
    }

    public static int findNumberOfDistinctCharsInMatics(ArrayList<String> alphamaticList) {

        int index=0;
        for (String string:alphamaticList
             ) {
            int length=string.length();
            int i=0;
            while ( i<length){
                if(isAbsent(string.charAt(i),charArray)) {
                    charArray[index++] = string.charAt(i++);
                    countOfDistinctChars++;
                }else i++;
            }
        }
        return countOfDistinctChars;
    }

    private static boolean isAbsent(char charAt, char[] charArray) {
        for (int i = 0; i < countOfDistinctChars; i++) {
            if (charAt==charArray[i])
                return Boolean.FALSE;

        }
        return Boolean.TRUE;
    }

    static int addDistinctCharsToMap(ArrayList<String> strings){
        int numOfDistinctChars=findNumberOfDistinctCharsInMatics(strings);
         if (numOfDistinctChars>10)
             throw new RuntimeException("Please do not use more than 10 distinct chars in the strings");
        for (int i = 0; i < numOfDistinctChars; i++)
            charMap.put(charArray[i],-1);

        if (checkIfResultMSDOne(strings)){
            int numOfStrings=strings.size();
            String result= strings.get(numOfStrings-1);
            charMap.put(result.charAt(0),1);
        }

        return numOfDistinctChars;
        }
}
