package com.hkadekar.anu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormatSymbols;
import java.time.LocalDate;

public class PrintCalendar {

    private static Logger LOGGER = LoggerFactory.getLogger(PrintCalendar.class);
    int month = 0;
    int year = 0;

    public PrintCalendar(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonthString(){
        return new DateFormatSymbols().getMonths()[month - 1];
    }

    public int[][] getCal(){
        LOGGER.info(String.format("Month = %d, Year = %d", month, year));
        int[][] cal = new int[6][7];
        LocalDate date = LocalDate.of(year, month, 1);
        int j = date.getDayOfWeek().getValue();
        int i = 0;
        Boolean stop = false;
        while(i < 6 && !stop){
            while(j < 7){
                cal[i][j] = date.getDayOfMonth();
                j += 1;
                date = date.plusDays(1);
                if(date.getMonth().getValue() != month){
                    stop = true;
                    break;
                }
            }
            i += 1;
            j = 0;
        }

        return cal;
    }

    public void displayCalendar(){
        int[][] cal = getCal();
        System.out.println(String.format("%s %d\n", getMonthString(), year));
        System.out.println("Su\tMo\tWe\tTh\tFr\tSa");
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(cal[i][j] != 0){
                    System.out.printf("%2d", cal[i][j]);
                } else {
                    System.out.print("  ");
                }

                System.out.print("\t");
            }
            System.out.println("");
        }

    }
}
