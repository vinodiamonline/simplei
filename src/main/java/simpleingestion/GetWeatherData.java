package simpleingestion;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import simpleweatherconnector.WeatherReceiver;

public class GetWeatherData {
	
	WeatherReceiver wReceiver;
	
	public GetWeatherData() {
		// TODO Auto-generated constructor stub
		wReceiver =  new WeatherReceiver();
		wReceiver.setWeatherUrl(ingestionconstants.WEATHER_URL);		
	}
	
	public void ingest() {
		try {
			// get data from the weather source
			String weatherdata = wReceiver.GetData();
			// Ingest data to HDFS source
			
			IngestDataToRabbitMQ(weatherdata);
			// Publish an event to rabbbit (messaging server)			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void IngestDataToRabbitMQ(String wdata) {
		RabbitSender rs = new RabbitSender();
		try {
			rs.SendMessageToRabbitMQ(ingestionconstants.RABBIT_HOSTNAME, ingestionconstants.WEATHER_QUEUE_NAME, wdata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
