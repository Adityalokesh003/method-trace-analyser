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
	public void testGetTracePointList_cond1() {
		
		File testFile = null;
		try{
			testFile=new File("src//main//resources//tracefiles//LOG//test8.log");
		     }
		     catch(Exception e) {}
		ArrayList<TracePoint> ActualtracePoints=TotalMethodTraceContainerInstance.getTracePointList(testFile);
		//AssertEquals(ExpectedtracePoints,ActualtracePoints);
		
	
		System.out.println(ActualtracePoints);
	}
	
	}
	
	
	
	


