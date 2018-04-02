package util;

public class Timer {
	private long start = 0;
	private long end = 0;
	
	private boolean isStarted=false;
	private boolean isStopped=false;
	
	public Timer() {
		start = System.currentTimeMillis();
		isStarted = true;
	}
	
	public void stop() {
		if(isStarted) {
			end = System.currentTimeMillis();
			isStopped = true;
		}
	}
	
	public String getTime() {
		if(isStopped) {
			long time = end-start;
			long millis = time%1000;
			long seconds =(time%(60*60*1000) - millis)/(1000);
			long minus = (time%(24*60*60*1000) - time%(60*1000))/(60*1000);
			long days = time/(24*3600*1000);
			long hours = (time-days*(24*60*60*1000))/(60*60*1000);
			return String.format("%d天%d时%d分%d.%03d秒", days, hours, minus, seconds, millis);
		}else if(isStarted) {
			return "时钟没有停止，请调用stop()";
		}
		return "计时器没有初始化";
	}
	
}
