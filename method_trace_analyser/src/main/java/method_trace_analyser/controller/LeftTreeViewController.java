package method_trace_analyser.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import method_trace_analyser.model.dao.TotalMethodTraceContainerDAO;
import javafx.scene.control.TreeItem;
import method_trace_analyser.model.bo.IndividualMethodTraceContainer;
import method_trace_analyser.model.bo.TotalMethodTraceContainer;
import method_trace_analyser.model.bo.TracePoint;
import method_trace_analyser.model.dao.daoImpl.TotalMethodTraceContainerDaoImpl;
import method_trace_analyser.model.dao.daofactory.TotalMethodTraceContainerDaoFactory;
import method_trace_analyser.util.TraceUtil;

public class LeftTreeViewController {

	public static TreeItem<String> initTreeView() {
		TreeItem<String> root = new TreeItem<>("Trace Explorer");
		root.setExpanded(true);
		TreeItem<String> tracefile = null;
		String fileNames[] = TraceUtil.getLogFiles();
		TotalMethodTraceContainer requiredObj = null;
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\tracefiles\\LOG";
		for (String filename : fileNames) {
			// Filename
			tracefile = new TreeItem<>(filename);
			root.getChildren().add(tracefile);
		}
		// methodNames filePath+filename+".log"
		for (String filename : fileNames) {
			ArrayList<TracePoint> tracePointList = TotalMethodTraceContainerDaoFactory.getTotalMethodTraceContaierDao()
					.getTracePointList(new File(filePath + filename + ".log"));
			try {
				requiredObj = TotalMethodTraceContainerDaoFactory.getTotalMethodTraceContaierDao()
						.getTraceDataFromFile(tracePointList, filename);
			} catch (Exception e) {
			}
			List<IndividualMethodTraceContainer> methodCObj = requiredObj.getMethodTraceList();
			IndividualMethodTraceContainer traceContainer = null;
			for (IndividualMethodTraceContainer mObj : methodCObj) {
				TreeItem<String> methodName = new TreeItem<>( traceContainer.getMethodName());
				tracefile.getChildren().add(methodName);
			}
		}
		
		return root;
	}
}
/*
 * 
 * */
