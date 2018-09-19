package method_trace_analyser.controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class MenuBarController {
	
	@FXML
	private Button file_openFolder;
	
	public void fileOpenFolderAction(ActionEvent actionEvent) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Trace Folder");
		File selectedDirectory = directoryChooser.showDialog(null);
		  
	}
	 
	

}
