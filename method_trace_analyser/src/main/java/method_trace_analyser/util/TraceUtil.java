package method_trace_analyser.util;

import java.io.File;

public class TraceUtil {
	public static String[] getLogFiles() {
		String[] fileNames = null;
		try {
			File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\tracefiles\\LOG");
			fileNames = file.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileNames;
	}
}
