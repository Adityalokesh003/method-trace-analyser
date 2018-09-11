package method_trace_analyser.model.dao.daoImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import method_trace_analyser.model.bo.TotalMethodTraceContainer;
import method_trace_analyser.model.dao.TotalMethodTraceContainerDAO;

public class TotalMethodTraceContainerDaoImpl implements TotalMethodTraceContainerDAO {
	
	@Override
	public boolean createTraceFile(String traceCommand) {
		List<String> command=new ArrayList<String>();
		command.add("CMD");
		command.add("/C");
		command.add("java "+traceCommand);
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.directory(new File("path/to/jar_or_class_files"));
		try {
			processBuilder.start();
			//check whether the .trc file created or not
			//if yes return true
			//else false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//close file
		}
		return false;
	}
	
	@Override
	public boolean convertBinaryTraceFileToLog(File traceTRCFile) {
		List<String> command=new ArrayList<String>();
		command.add("CMD");
		command.add("/C");
		command.add("java com.ibm.jvm.format.TraceFormat "+traceTRCFile.getName()+".trc "+traceTRCFile.getName()+".log");
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.directory(new File("path/to/trace file"));
		try {
			processBuilder.start();
			//check whether the .log file created or not
			//if yes return true
			//else false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//close file
		}
		return false;
	}

	@Override
	public TotalMethodTraceContainer getTraceDataFromFile(File traceLogFile) {
		// get the trace information from trace files
		//help: read from the log file line by line
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
		// use sqlite
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
