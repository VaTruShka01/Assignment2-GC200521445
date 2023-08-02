module com.example.assignment2gc200521445 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.assignment2gc200521445 to com.google.gson, javafx.fxml;
    exports com.example.assignment2gc200521445;
    exports com.example.assignment2gc200521445.Controllers;
    opens com.example.assignment2gc200521445.Controllers to com.google.gson, javafx.fxml;
    exports com.example.assignment2gc200521445.Utilities;
    opens com.example.assignment2gc200521445.Utilities to com.google.gson, javafx.fxml;
    exports com.example.assignment2gc200521445.Models;
    opens com.example.assignment2gc200521445.Models to com.google.gson, javafx.fxml;

}