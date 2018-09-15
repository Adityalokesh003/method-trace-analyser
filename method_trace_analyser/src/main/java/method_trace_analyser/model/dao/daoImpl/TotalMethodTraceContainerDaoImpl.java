package method_trace_analyser.model.dao.daoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.util.converter.TimeStringConverter;
import method_trace_analyser.model.bo.IndividualMethodTraceContainer;
import method_trace_analyser.model.bo.TotalMethodTraceContainer;
import method_trace_analyser.model.bo.TracePoint;
import method_trace_analyser.model.dao.TotalMethodTraceContainerDAO;
import method_trace_analyser.util.TimeStampToNanosCoverter;

public class TotalMethodTraceContainerDaoImpl implements TotalMethodTraceContainerDAO {

	@Override
	public boolean createTraceFile(String traceCommand) {
		boolean isCreated = false;
		List<String> command=new ArrayList<String>();
		command.add("CMD");
		command.add("/C");
		command.add("java "+traceCommand);
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.directory(new File("path/to/jar_or_class_files"));
		Process process=null;
		try {
			process = processBuilder.start();
			process.waitFor();
			/*if(tracefileName.exists()){
			 *  isCreated = true;
			}*/
			//else false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(process.isAlive()) {
				process.destroy();
			}
		}
		return isCreated;
	}

	@Override
	public boolean convertBinaryTraceFileToLog(File traceTRCFile) {
		boolean isconverted =  false;
		List<String> command=new ArrayList<String>();
		command.add("CMD");
		command.add("/C");
		command.add("java com.ibm.jvm.format.TraceFormat "+traceTRCFile.getName()+".trc "+traceTRCFile.getName()+".log");
		ProcessBuilder processBuilder=null;
		Process process=null;
		try {
			processBuilder = new ProcessBuilder(command);
			processBuilder.directory(new File("path/to/trace file"));
			process = processBuilder.start();
			process.waitFor();
			/*if(tracelogfileName.exists()){
			 *  isconverted = true;

			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(process.isAlive()) {
				process.destroy();
			}
		}
		return isconverted;
	}

	@Override
	public ArrayList<TracePoint> getTracePointList(File traceLOGFile) {
		ArrayList<TracePoint> tracePoints =null; 
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(traceLOGFile));
			String data;
			while ((data= bufferedReader.readLine())!=null) {
				Pattern pattern = Pattern.compile("(?<timeStamp>\\d{2}:\\d{2}:\\d{2}\\.\\d{9})\\s+\\*?(?<threadId>0x\\d{7})\\s+mt.\\d{1}\\s+(?<traceType>Entry|Exit)\\s+[><](?<methodName>.*?)V.*");
				Matcher matcher = pattern.matcher(data);
				if (matcher.find()) {
					tracePoints = new ArrayList<>();
					TracePoint tracePoint = new TracePoint();
					tracePoint.setTimeStamp(matcher.group("timeStamp"));
					tracePoint.setThreadId(matcher.group("threadId"));
					tracePoint.setType(matcher.group("type"));
					tracePoint.setMethodName(matcher.group("methodName"));
					tracePoints.add(tracePoint);
				}
			}
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return tracePoints;
	}
	@Override
	public TotalMethodTraceContainer getTraceDataFromFile(ArrayList<TracePoint> tracePointList,String fileName) {
		TotalMethodTraceContainer totalMethodTraceContainer = new TotalMethodTraceContainer();
		IndividualMethodTraceContainer individualMethodTraceContainer=null;
		ArrayList<IndividualMethodTraceContainer> methodTraceList = new ArrayList<IndividualMethodTraceContainer>();
		totalMethodTraceContainer.setMethodTraceList(methodTraceList);
		List<TracePoint> incompleteMethodList=null;
		Stack<TracePoint> tracePointStack = new Stack<>();
		for (TracePoint tracePoint : tracePointList) {
			if (tracePoint.getType()=="Entry") {
				tracePointStack.push(tracePoint);
			}
			else if(tracePoint.getType()=="Exit"){
				if (tracePoint.getMethodName().equals(tracePointStack.peek().getMethodName())) {
					individualMethodTraceContainer=new IndividualMethodTraceContainer();
					individualMethodTraceContainer.setEntry_time(TimeStampToNanosCoverter.toNanoSeconds(tracePointStack.pop().getTimeStamp()));
					individualMethodTraceContainer.setExit_time(TimeStampToNanosCoverter.toNanoSeconds(tracePoint.getTimeStamp()));
					individualMethodTraceContainer.setMethodName(tracePoint.getMethodName());
					methodTraceList.add(individualMethodTraceContainer);
				}else {
					totalMethodTraceContainer.setIncompleteMethodList(new ArrayList<TracePoint>(tracePointStack));
					return totalMethodTraceContainer;
				}
			}
		}
		return totalMethodTraceContainer;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceTRCFile(String trcTraceFileName) {
		//TODO Auto-generated method stub
		//sairam
		return null;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceLogFile(String logtraceFileName) {
		//TODO Auto-generated method stub
		//sairam
		return null;
	}

	@Override
	public boolean addToDB(TotalMethodTraceContainer traceContainer) {
		//use sqlite
		//darshini
		return false;
	}

	@Override
	public TotalMethodTraceContainer getTraceDataFromDB(String traceFileName) {
		// TODO Auto-generated method stub
		//darshini
		return null;
	}

	@Override
	public TotalMethodTraceContainer deleteTraceFromDB(String traceFileName) {
		// TODO Auto-generated method stub
		//darshini
		return null;
	}

	@Override
	public TreeMap<String, Integer> generateMethodInvocationCountTable() {
		// TODO Auto-generated method stub
		//sairam
		return null;
	}

	@Override
	public boolean updateTraceData(TotalMethodTraceContainer traceContainer) {
		// TODO Auto-generated method stub
		return false;
		//darshini
	}





}
