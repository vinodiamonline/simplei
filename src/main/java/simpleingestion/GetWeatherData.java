package simpleingestion;

import java.io.IOException;

import simpleweatherconnector.WeatherReceiver;

public class GetWeatherData {
	
	WeatherReceiver wReceiver;
	
	public GetWeatherData() {
		// TODO Auto-generated constructor stub
		wReceiver =  new WeatherReceiver();
	}
	
	public void ingest() {
		try {
			// get data from the weather source
			//wReceiver.GetData();
			
			System.out.println(wReceiver.GetData());
			// Ingest data to HDFS source
			
			// Publish an event to rabbbit (messaging server)
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 
}
