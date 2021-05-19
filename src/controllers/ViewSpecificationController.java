package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewSpecificationController {
    @FXML
    private Button Back;
    @FXML
    private Text Processor;
    @FXML
    private Text OS;
    @FXML
    private Text Architecture;
    @FXML
    private Text LogicalCores;

    public void initialize()
    {
        String CPU = System.getenv("PROCESSOR_IDENTIFIER");
        Processor.setText(CPU);

        String OperatingSystem = System.getProperty("os.name");
        OS.setText(OperatingSystem);

        String architecture = System.getenv("PROCESSOR_ARCHITECTURE");
        Architecture.setText(architecture);

        int logicalCores = Runtime.getRuntime().availableProcessors();
        LogicalCores.setText(String.valueOf(logicalCores));
    }

    @FXML
    public void handleBackButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Launcher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }


}
