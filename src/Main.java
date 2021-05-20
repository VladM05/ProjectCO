
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testbench.TestBench;

public class Main extends Application {



	@Override
	public void start(Stage primaryStage) throws Exception {

		System.out.println(new TestBench().run());
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Launcher.fxml"));
		primaryStage.setTitle("SSRUM Benchmark");
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}
}
