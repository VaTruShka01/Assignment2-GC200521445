package com.example.assignment2gc200521445.Models;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("employer_name")
    private String employerName;
    @SerializedName("employer_logo")
    private String employerLogo;
    @SerializedName("job_apply_link")
    private String applyLink;
    @SerializedName("job_title")
    private String jobTitle;
    @SerializedName("job_description")
    private String jobDescription;
    @SerializedName("job_country")
    private String jobCountry;
    @SerializedName("job_state")
    private String jobState;
    @SerializedName("job_city")
    private String jobCity;
    @SerializedName("job_publisher")
    private String jobPublisher;
    @SerializedName("job_id")
    private String jobId;

    public String getJobId() {
        return jobId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerLogo() {
        return employerLogo;
    }

    public String getApplyLink() {
        return applyLink;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public String getJobState() {
        return jobState;
    }

    public String getJobCity() {
        return jobCity;
    }

    public String getJobPublisher() {
        return jobPublisher;
    }

    public String toString() { return String.format("%s - %s, %s", jobTitle, employerName, jobCity); }
}
