package method_trace_analyser.model.dao;

import java.io.File;

import method_trace_analyser.model.bo.TotalMethodTraceContainer;

public interface TotalMethodTraceContainerDAO {
	public boolean createTraceFile(String traceCommand);
	public boolean convertBinaryTraceFileToLog(File traceTRCFile);
	public TotalMethodTraceContainer getTraceDataFromFile(File traceLogFile);
	public TotalMethodTraceContainer deleteTraceTRCFile(String trcTraceFileName);
	public TotalMethodTraceContainer deleteTraceLogFile(String logtraceFileName);
	public boolean addToDB(TotalMethodTraceContainer traceContainer);
	public TotalMethodTraceContainer getTraceDataFromDB(String traceFileName);
	public TotalMethodTraceContainer deleteTraceFromDB(String traceFileName);
}
