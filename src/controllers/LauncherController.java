package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logging.FileLogger;
import testbench.TestBench;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LauncherController {
    @FXML
    private Button Start;
    @FXML
    private Button Specifications;
    @FXML
    private Text cpuscore;




    @FXML
    public void handleStartButton()
    {
        long score=new TestBench().run();
        cpuscore.setText(Long.toString(score));

        String getTime = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        String CPU = System.getenv("PROCESSOR_IDENTIFIER");

        String OperatingSystem = System.getProperty("os.name");

        String architecture = System.getenv("PROCESSOR_ARCHITECTURE");

        int logicalCores = Runtime.getRuntime().availableProcessors();
        String str=score + "\t" + CPU + "\t" + OperatingSystem + "\t" + architecture  + "\t" + logicalCores + "\t" + getTime + "\n";
        try {
            Files.write(Paths.get("Results.txt"), str.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        }catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @FXML
    public void handleSpecificationsButton()
    {
        Stage stage;
        Parent root;
        try{

            stage = (Stage) Specifications.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Specifications.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
