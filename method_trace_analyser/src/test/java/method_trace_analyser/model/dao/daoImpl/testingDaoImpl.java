package method_trace_analyser.model.dao.daoImpl;
import java.io.File;
import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import method_trace_analyser.model.bo.TracePoint;
import method_trace_analyser.model.dao.TotalMethodTraceContainerDAO;
import method_trace_analyser.model.dao.daofactory.TotalMethodTraceContainerDaoFactory;

class testingDaoImpl {
	TotalMethodTraceContainerDaoImpl TotalMethodTraceContainerInstance=new TotalMethodTraceContainerDaoImpl();
	
	
	@Test
	public void testGetTracePointList_tracePoints() {
	
		TracePoint expectedTracePoint1=new TracePoint();
		TracePoint expectedTracePoint2=new TracePoint();
		TracePoint expectedTracePoint3=new TracePoint();
		TracePoint expectedTracePoint4=new TracePoint();
		
		expectedTracePoint1.setTimeStamp("16:54:55.570210750");
		expectedTracePoint1.setThreadId("0x2926700");
		expectedTracePoint1.setTraceEntry("Dice.<init>()V bytecode");
		expectedTracePoint1.setType("Entry");
		
		expectedTracePoint2.setTimeStamp("16:54:55.570217150");
		expectedTracePoint2.setThreadId("0x2926700");
		expectedTracePoint2.setTraceEntry("[1] Dice.<init> (Dice.java:5)");
		expectedTracePoint2.setType("Event");
		
		expectedTracePoint3.setTimeStamp("16:54:55.570219283");
		expectedTracePoint3.setThreadId("0x2926700");
		expectedTracePoint3.setTraceEntry("[2] SnakeGame.main (SnakeGame.java:29)");
		expectedTracePoint3.setType("Event");
		
		expectedTracePoint4.setTimeStamp("16:54:55.570223122");
		expectedTracePoint4.setThreadId("0x2926700");
		expectedTracePoint4.setTraceEntry("Dice.<init>()V bytecode");
		expectedTracePoint4.setType("Exit");
		
		ArrayList<TracePoint> ExpectedtracePointsList=new ArrayList<TracePoint>();
		ExpectedtracePointsList.add(expectedTracePoint1);
		ExpectedtracePointsList.add(expectedTracePoint2);
		ExpectedtracePointsList.add(expectedTracePoint3);
		ExpectedtracePointsList.add(expectedTracePoint4);
		
		File testFile = null;
		try{
			testFile=new File("src//main//resources//tracefiles//LOG//testFile1.log");
		     }
		     catch(Exception e) {}
		ArrayList<TracePoint> ActualtracePointsList=TotalMethodTraceContainerInstance.getTracePointList(testFile);
		
	TracePoint[] ExpectedtracePointsArray=ExpectedtracePointsList.toArray(new TracePoint[ExpectedtracePointsList.size()]);
	TracePoint[] ActualtracePointsArray=ActualtracePointsList.toArray(new TracePoint[ActualtracePointsList.size()]);	
		
	assertArrayEquals(ExpectedtracePointsArray,ActualtracePointsArray);
	
	}
	

	@Test
	public void testDeleteTraceTRCFile_whenFileNotExists() {
		assertFalse(TotalMethodTraceContainerInstance.deleteTraceTRCFile("testFile"));
			
	}
	@Test//this deletes the trace files 
	public void testDeleteTraceTRCFile_whenFileExists() {
		File file=new File("src//main//resources//tracefiles//LOG//testFile1.log");
		assertTrue(TotalMethodTraceContainerInstance.deleteTraceTRCFile("src//main//resources//tracefiles//LOG//testDelete.log"));
		
	}
	
	@Test
	public void testDeleteTraceLogFile_whenFileNotExists() {
		assertFalse(TotalMethodTraceContainerInstance.deleteTraceTRCFile("testFile"));
	}
	@Test
	public void testDeleteTraceLogFile_whenFileExists() {
		File file=new File("src//main//resources//tracefiles//LOG//testFile1.log");
		assertTrue(TotalMethodTraceContainerInstance.deleteTraceTRCFile("src//main//resources//tracefiles//LOG//testDelete2.log"));
		
	}
	
	
	
}

		
	
	


