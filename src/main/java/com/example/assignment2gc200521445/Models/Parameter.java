package com.example.assignment2gc200521445.Models;

import com.google.gson.annotations.SerializedName;

public class Parameter {
    private String query;
    private int page;

    @SerializedName("num_pages")
    private int numPages;

    public String getQuery() {
        return query;
    }

    public int getPage() {
        return page;
    }

    public int getNumPages() {
        return numPages;
    }
}
