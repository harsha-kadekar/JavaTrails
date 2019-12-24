package com.hkadekar.anu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PrintCalendarTest {

    @Test
    void verifyCalendarPrint(){
        int[][] expectedValue = new int[6][7];

        int i = 0, j = 5;
        int day = 1;
        boolean stop = false;
        while(i < 6 && !stop) {
            while(j < 7){
                expectedValue[i][j] = day;
                j += 1;
                day += 1;
                if(day == 31){
                    stop = true;
                    break;
                }
            }
            j = 0;
            i += 1;
        }

        PrintCalendar printCalendar = new PrintCalendar( 11, 2019);
        int[][] actualValue = printCalendar.getCal();

        for(i = 0; i < 6; i++){
            assertArrayEquals(expectedValue[i], actualValue[i]);
        }
    }
}
