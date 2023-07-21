module com.example.ticketmania {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ticketmania to javafx.fxml;
    exports com.example.ticketmania;
}