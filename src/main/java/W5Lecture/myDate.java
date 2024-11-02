package W5Lecture;

public class myDate {

    int day;
    int month;
    int year;

    public myDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    // Getters
    int getDay() {
        return day;
    }
    int getMonth() {
        return month;
    }
    int getYear() {
        return year;
    }

    // Setters
    void setDay(int day) {
        this.day = day;
    }
    void setMonth(int month) {
        this.month = month;
    }
    void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }




    public boolean earlier(myDate uporedba) {
        if (this.year < uporedba.getYear()) {
            return true;
        }

        if (this.year == uporedba.getYear() && this.month < uporedba.getMonth()) {
            return true;
        }

        if(this.year == uporedba.getYear() && this.month == uporedba.getMonth() && this.day < uporedba.getDay()) {
            return true;

        }
        return false;
    }


    public static void main(String[] args) {
//        myDate prviDate = new myDate(30,8,2004);
//        myDate drugiDate = new myDate(5,2,2004);
//
//        System.out.println(prviDate.earlier(drugiDate));


    }

}
