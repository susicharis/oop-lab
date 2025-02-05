package Midterm.Exercise_MostlyW4.W5_Practice;

import java.util.Calendar;

public class myDate {
    private int day;
    private int month;
    private int year;

    public myDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean earlierThan(myDate comparePlease) {
        if (this.year < comparePlease.getYear()) {
            return true;
        }

        if (this.year == comparePlease.getYear() && this.month < comparePlease.getMonth()) {
            return true;
        }

        if (this.year == comparePlease.getYear() && this.month == comparePlease.getMonth() && this.day < comparePlease.getDay()) {
            return true;
        } return false;
    }

    @Override
    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

    public static void main(String[] args) {
        myDate firstDate = new myDate(30,8,2004);
        myDate secondDate = new myDate(9,3,2005);

        System.out.println(firstDate.earlierThan(secondDate));


        // Ready made Date Objects
        System.out.println("Ready made Date Objects: \n ");
        int newDay = Calendar.getInstance().get(Calendar.DATE);
        int newMonth = Calendar.getInstance().get(Calendar.MONTH) + 1; // January is 0 so we add 1
        int newYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Today is " + newDay + "." + newMonth + "." + newYear);
    }


}
