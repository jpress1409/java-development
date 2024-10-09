package com.pluralsight;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Date date = new Date();

        //10/09/2024
        DateTimeFormatter pattern3 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate3 = today.format(pattern3);

        //09-Oct-2024
        DateTimeFormatter patter4 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate4 = today.format(patter4);

        //October 9, 2024
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        String formattedDate1 = today.format(pattern);

        // Wednesday, October 9, 2024
        DateTimeFormatter pattern2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String formattedDate2 = today.format(pattern2);


        //Time
        SimpleDateFormat formatTime = new SimpleDateFormat("h:mm aa");
        String time = formatTime.format(date);


        System.out.println(formattedDate3);
        System.out.println(formattedDate1);
        System.out.println(formattedDate2);
        System.out.println(time + " on " + formattedDate4);


    }
}
