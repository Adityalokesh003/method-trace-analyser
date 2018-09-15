package method_trace_analyser.model.bo;

public class TracePoint {
	private String timeStamp;
	private String threadId;
	private String type;
	private String methodName;
	public TracePoint() {
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	@Override
	public String toString() {
		return "TracePoint [timeStamp=" + timeStamp + ", threadId=" + threadId + ", type=" + type + ", methodName="
				+ methodName + "]";
	}
	

}
