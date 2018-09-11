package method_trace_analyser.model.dao.daoImpl;

import java.io.File;

import method_trace_analyser.model.bo.TotalMethodTraceContainer;
import method_trace_analyser.model.dao.TotalMethodTraceContainerDAO;

public class TotalMethodTraceContainerDaoImpl implements TotalMethodTraceContainerDAO {

	@Override
	public void convertBinaryTraceFileToLog(File traceTRCFile) {
		// TODO Auto-generated method stub
		//somthing

	}

	@Override
	public TotalMethodTraceContainer getTraceDataFromFile(File traceLogFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceTRCFile(String trcTraceFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceLogFile(String logtraceFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addToDB(TotalMethodTraceContainer traceContainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TotalMethodTraceContainer getTraceDataFromDB(String traceFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceFromDB(String traceFileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
