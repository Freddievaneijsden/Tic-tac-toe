module com.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tictactoe to javafx.fxml;
    opens com.example.tictactoe.model to javafx.fxml;
    exports com.example.tictactoe;
    exports com.example.tictactoe.controller;
    opens com.example.tictactoe.controller to javafx.fxml;
}