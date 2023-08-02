package com.example.assignment2gc200521445.Models;
import com.google.gson.annotations.SerializedName;
public class ApiResponse {


    private String status;
    @SerializedName ("request_id")
    private String requestId;

    private Parameter parameters;

    private Data[] data;

    public String getStatus() {
        return status;
    }

    public String getRequestId() {
        return requestId;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public Data[] getData() {
        return data;
    }
}
