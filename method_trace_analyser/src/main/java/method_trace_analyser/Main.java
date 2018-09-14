package method_trace_analyser;

import com.kodedu.terminalfx.TerminalBuilder;
import com.kodedu.terminalfx.TerminalTab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/method_trace_analyser/view/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			//e.getMessage();
			 
		}
		
		/*TerminalBuilder terminalBuilder = new TerminalBuilder();
		TerminalTab terminal = terminalBuilder.newTerminal();

		TabPane tabPane = new TabPane();
		tabPane.getTabs().add(terminal);
		Scene scene = new Scene(tabPane,400,400);
		//scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();*/
	}

	public static void main(String[] args) {
		launch(args);
	}
}
