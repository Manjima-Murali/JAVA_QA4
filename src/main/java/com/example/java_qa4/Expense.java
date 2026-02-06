package com.example.java_qa4;

public class Expense {
    private int id;
    private String date;
    private String category;
    private double amount;

    public Expense(int id, String date, String category, double amount) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public int getId() { return id; }
    public String getDate() { return date; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
}
