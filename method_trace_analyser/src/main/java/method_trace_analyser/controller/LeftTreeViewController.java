package method_trace_analyser.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import method_trace_analyser.util.TraceUtil;

public class LeftTreeViewController {
	
	public static TreeItem<String> initTreeView() {
		TreeItem<String> root=new TreeItem<>("comparedFiles");
		TreeItem<String> file=null;
		String fileNames[]=TraceUtil.getLogFiles();
		for(String fname:fileNames) {
			file=new TreeItem<>(fname);
			root.getChildren().add(file);
		}
	return	root;
	}
}
