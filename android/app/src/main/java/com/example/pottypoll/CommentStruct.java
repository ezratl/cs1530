package com.example.pottypoll;

public class CommentStruct {
    private static final String COLUMN_ID = "_id";
    public int PARENT;
    public int AUTHOR;
    public int RATING;
    public int DATE;
    public int HELPFUL;
    public int UNHELPFUL;
    public String TEXT;

    public CommentStruct(int parent, int author, int rating, int date, int helpful, int unhelpful, String text)
    {
        this.PARENT = parent;
        this.AUTHOR = author;
        this.RATING = rating;
        this.DATE = date;
        this.HELPFUL = helpful;
        this.UNHELPFUL = unhelpful;
        this.TEXT = text;
    }


}
