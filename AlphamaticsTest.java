package com.example.lasgna;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlphamaticsTest {
    ArrayList<String> strings=new ArrayList<>();
     public AlphamaticsTest(){
        strings.add("send");
        strings.add("more");
        strings.add("money");
    }
    @Test
    void checkIfResultMSDOne() {
        assertTrue(Alphamatics.checkIfResultMSDOne(strings));
    }

    @Test
    void numberOfDistinctCharsInMatics() {


        Alphamatics.initialize(strings);
        assertEquals(8,Alphamatics.findNumberOfDistinctCharsInMatics(strings));


    }



    @Test
    void doesResultStringHaveCorrectLength() {
         assertTrue(Alphamatics.doesResultStringHaveCorrectLength(strings));

    }

    @Test
    void addDistinctCharsToMap() {
         assertEquals(8,Alphamatics.addDistinctCharsToMap(strings));

    }
}