module edu.ijse.malshanrentshopmanagement.malshanrentshopmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;
    requires lombok;
    requires jasperreports;

    opens lk.ijse.malshanrentshopmanagement.dto.tm to javafx.base;
    opens lk.ijse.malshanrentshopmanagement.controller to javafx.fxml;
    exports lk.ijse.malshanrentshopmanagement;
}