module com.example.travelsimply {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.travelsimply to javafx.fxml;
    exports com.example.travelsimply;
    exports com.example.travelsimply.user;
    opens com.example.travelsimply.user to javafx.fxml;
    exports com.example.travelsimply.place;
    opens com.example.travelsimply.place to javafx.fxml;
    exports com.example.travelsimply.trip;
    opens com.example.travelsimply.trip to javafx.fxml;
    exports com.example.travelsimply.invitation;
    opens com.example.travelsimply.invitation to javafx.fxml;
}