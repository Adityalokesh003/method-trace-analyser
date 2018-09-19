package method_trace_analyser.controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class MenuBarController {
	
	public static void fileOpenFolderAction() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Trace Folder");
		File selectedDirectory = directoryChooser.showDialog(null);
		if (selectedDirectory.exists()) {
			System.out.println("yey");
		}
	}
	 
	

}
