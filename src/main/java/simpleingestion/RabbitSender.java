package simpleingestion;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitSender {

  public void SendMessageToRabbitMQ(String hostname, String queuename, String message) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(hostname);
    Connection connection = factory.newConnection();
    
    Channel channel = connection.createChannel();
    channel.basicPublish("", queuename, null, message.getBytes("UTF-8"));
    
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}
