package method_trace_analyser.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;

public class MainController implements Initializable{
	@FXML
	private MenuItem open_folder;
	@FXML
	private TreeView<String> traceExplorer;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		traceExplorer.setRoot(LeftTreeViewController.initTreeView());
	}
	
	public void handleMenuOpenFolder(ActionEvent actionEvent) {
		MenuBarController.fileOpenFolderAction();
	}
	
	public void handleMenuExit(ActionEvent actionEvent) {
		MenuBarController.fileExitAction();
	}
}
