package simpleingestion;

public class ingestionconstants {
	public static final String WEATHER_URL="http://api.openweathermap.org/data/2.5/weather?q=Noida,in&appid=d65196a1f5545b774786d4a1455b9ae8";
	//public static final String HDFS_PATH="hdfs://vinkumar-osx1:port/user/hdfs/";
	
	// Rabbit MQ configurations
	public static final String WEATHER_QUEUE_NAME = "weather_main";
	public static final String RABBIT_HOSTNAME = "simplerabbit.corp.adobe.com";
	
}
