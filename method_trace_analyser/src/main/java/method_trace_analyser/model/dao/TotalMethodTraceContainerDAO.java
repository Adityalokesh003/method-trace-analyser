package method_trace_analyser.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;

import method_trace_analyser.model.bo.TotalMethodTraceContainer;
import method_trace_analyser.model.bo.TracePoint;

public interface TotalMethodTraceContainerDAO {
	//file handling part
	public boolean createTraceFile(String traceCommand);
	public boolean convertBinaryTraceFileToLog(File traceTRCFile);
	public ArrayList<TracePoint> getTracePointList(File traceLOGFile);
	public TotalMethodTraceContainer getTraceDataFromFile(ArrayList<TracePoint> tracePointList,String fileName);
	public TotalMethodTraceContainer deleteTraceTRCFile(String trcTraceFileName);
	public TotalMethodTraceContainer deleteTraceLogFile(String logtraceFileName);
	//db part
	public boolean addToDB(TotalMethodTraceContainer traceContainer);
	public TotalMethodTraceContainer getTraceDataFromDB(String traceFileName);
	public boolean updateTraceData(TotalMethodTraceContainer traceContainer);
	public TotalMethodTraceContainer deleteTraceFromDB(String traceFileName);
	public TreeMap<String, Integer> generateMethodInvocationCountTable(TotalMethodTraceContainer totalMethodTraceContainer);
	  
}
