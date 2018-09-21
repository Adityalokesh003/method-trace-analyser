package method_trace_analyser.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{
	@FXML
	private MenuItem open_folder;
	@FXML
	private TreeView<String> traceExplorer;
	@FXML
	private AnchorPane barchartAnchor;
	@FXML
	private TableView tableView;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			traceExplorer.setRoot(LeftTreeViewController.initTreeView());
			//this barchart is not going to be initialized here
			BarChart<String, Number> graphicalBarChart = TabPaneController.getBarChart("fgb");
			barchartAnchor.getChildren().add(graphicalBarChart);
			graphicalBarChart.prefWidthProperty().bind(barchartAnchor.widthProperty());
			graphicalBarChart.prefHeightProperty().bind(barchartAnchor.heightProperty());
			tableView = TabPaneController.getTableView("fd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handleMenuOpenFolder(ActionEvent actionEvent) {
		MenuBarController.fileOpenFolderAction();
	}
	
	public void handleMenuExit(ActionEvent actionEvent) {
		MenuBarController.fileExitAction();
	}
	public void handleUploadTraceFiles(ActionEvent actionEvent) {
		File traceTRCfile = RightVBoxController.getTRCFromFileChooser();
	}
	
}
