module me.julie.simon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens me.julie.simon to javafx.fxml;
    exports me.julie.simon;
}