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
	private  TreeView <String> treeView;	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//add your tree view items here
		//hint use your TraceUtil class
		//first oka files matram add chey tarvta TraceMethod add cheyyochhu

	}
	
	public void handleMenuBar(ActionEvent actionEvent) {
		MenuBarController.fileOpenFolderAction(actionEvent);
		treeView.setRoot(LeftTreeViewController.initTreeView());
	}
	

}
