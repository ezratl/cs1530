package com.example.pottypoll;

public class BathroomStruct {

    public int ID; //autoincrementing int
    public int AUTHOR;   //int
    public String GENDER; //varchar
    public int SHOWER; //int 0 or 1
    public int SINK; //int 0 or 1
    public int PAPERTOWELS; //int 0 or 1
    public int ACTIVE; //int 0 ir 1
    public String LOCATION; //varchar
    public double XCORD; //real
    public double YCORD;   //real
    public String BUILDNAME; //varchar
    public int FLOOR; //int
    public String HOURS; //varchar
    public int RATING; //int
    public int RATERS; //number of ratings already, so we can just add the new one without recalculating
    public int DATE; //int

    public BathroomStruct(int id, int author, String gender, int shower, int sink, int papertowels, int active, String location, double x, double y, String building, int floor, String hours, int rating, int raters, int date)
    {
        this.ID = id;
        this.AUTHOR = author;
        this.GENDER = gender;
        this.SHOWER = shower;
        this.SINK = sink;
        this.PAPERTOWELS = papertowels;
        this.ACTIVE = active;
        this.LOCATION = location;
        this.XCORD = x;
        this.YCORD = y;
        this.BUILDNAME = building;
        this.FLOOR = floor;
        this.HOURS = hours;
        this.RATING = rating;
        this.RATERS = raters;
        this.DATE = date;
    }
}
