package method_trace_analyser.model.bo;

import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class TotalMethodTraceContainer {
	private String fileName;
	private List<IndividualMethodTraceContainer> methodTraceList;
	private int noOfTracePoints;
	private List<TracePoint> incompleteMethodList;
	
	public TotalMethodTraceContainer() {
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<IndividualMethodTraceContainer> getMethodTraceList() {
		return methodTraceList;
	}
	public void setMethodTraceList(List<IndividualMethodTraceContainer> methodTraceList) {
		this.methodTraceList = methodTraceList;
	}
	public int getNoOfTracePoints() {
		return noOfTracePoints;
	}
	public void setNoOfTracePoints(int noOfTracePoints) {
		this.noOfTracePoints = noOfTracePoints;
	}
	
	public List<TracePoint> getIncompleteMethodList() {
		return incompleteMethodList;
	}
	public void setIncompleteMethodList(List<TracePoint> incompleteMethodList) {
		this.incompleteMethodList = incompleteMethodList;
	}
	@Override
	public String toString() {
		return "TotalMethodTraceContainer [fileName=" + fileName + ", methodTraceList=" + methodTraceList
				+ ", noOfTracePoints=" + noOfTracePoints + ", incompleteMethodList=" + incompleteMethodList + "]";
	}
	 
	

}
