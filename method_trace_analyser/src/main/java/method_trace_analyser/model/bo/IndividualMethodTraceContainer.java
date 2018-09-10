package method_trace_analyser.model.bo;

public class IndividualMethodTraceContainer {
	private String methodName;
	private long entry_time;
	private long exit_time;
	public IndividualMethodTraceContainer() {
		
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public long getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(long entry_time) {
		this.entry_time = entry_time;
	}
	public long getExit_time() {
		return exit_time;
	}
	public void setExit_time(long exit_time) {
		this.exit_time = exit_time;
	}
	
	public long calculateTimeDuration() {
	 return exit_time-entry_time;
		
	}
	@Override
	public String toString() {
		return "IndividualMethodTraceContainer [methodName=" + methodName + ", entry_time=" + entry_time
				+ ", exit_time=" + exit_time + "]";
	}
	
	 
}
