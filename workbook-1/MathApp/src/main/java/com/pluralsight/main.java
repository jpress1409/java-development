package com.pluralsight;

import java.lang.Math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class main {
    public static void main(String[] args){
        /*Question 1*/
        double bobSalary = 50000;
        double garySalary = 790000;

        System.out.println("The answer is " + Math.max(bobSalary, garySalary));
        /*Question 2*/
        double carPrice = 20000;
        double truckPrice = 70000;

        System.out.println("This answer is " + Math.min(carPrice, truckPrice));

        /*Question 3*/
        double rad = 7.25;
        double pi = Math.PI;

        /*Formula for the area of a circle(A = pi * r^2)*/
        double area = pi * (pow(rad, 2));
        System.out.println("The answer is " + area);

        /*Question 4*/
        double num = 5;

        /*Finding sqrt of num*/
        double ans = sqrt(num);
        System.out.println("The answer is " + ans);
        /*Question 5*/
        /*Variables. Using Pythagorean theorem.
         * (y2-y1)^2 + (x2-x1)^2 = C^2*/
        double x1 = 5;
        double x2 = 85;
        double y1 = 10;
        double y2 = 50;
        /*Making "A" and "B" into single numbers*/
        double ansB = (y2 - y1);
        double ansA = (x2 - x1);
        /*Squaring A and B*/
        double ansA2 = Math.pow(ansA, 2);
        double ansB2 = Math.pow(ansB, 2);
        /*Adding to get C^2*/
        double C2 = ansA2 + ansB2;
        /*Final answer. sqrt(C)*/
        double ansFin = sqrt(C2);

        System.out.println("The answer is " + ansFin);


        /*Question 6*/
        double num1 = -3.8;

        System.out.println("The answer is " + Math.abs(num1));

        /*Question 7*/
        double randNum = Math.random();
        System.out.println("The answer is " + randNum);
    }

}
