module com.temr1.lesson2_3_maven.lesson2_14_hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.temr1.lesson2_3_maven.lesson2_14_hw to javafx.fxml;
    exports com.temr1.lesson2_3_maven.lesson2_14_hw;
}