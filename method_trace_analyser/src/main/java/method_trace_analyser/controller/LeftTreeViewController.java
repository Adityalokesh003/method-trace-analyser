package method_trace_analyser.controller;

import javafx.scene.control.TreeItem;
import method_trace_analyser.util.TraceUtil;

public class LeftTreeViewController {

	public static TreeItem<String> initTreeView() {
		TreeItem<String> root = new TreeItem<>("comparedFiles");
		TreeItem<String> tracefile = null;
		String fileNames[] = TraceUtil.getLogFiles();
		for (String filename : fileNames) {
			tracefile = new TreeItem<>(filename);
			root.getChildren().add(tracefile);
		}
		return root;
	}
}
