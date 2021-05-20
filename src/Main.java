
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testbench.TestNewtonSquareRoot;
import testbench.TestPopulateArray;

public class Main extends Application {



	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println(new TestNewtonSquareRoot());
		System.out.println(new TestPopulateArray());
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Launcher.fxml"));
		primaryStage.setTitle("SSRUM Benchmark");
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}
}
