package kafka;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


/**
 * Hello world!
 *
 */
public class App 
{
	String message;
	Random random=new Random();
    public static void main( String[] args )
    {
        new App().start();
    }

	private void start() {
		Properties properties=new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.CLIENT_ID_CONFIG,"stream-producer-1");

		KafkaProducer<String, String> kafkaProducer=new KafkaProducer<String, String>(properties);
		List<Character> characters=new ArrayList();
		for(char i='a';i<'z';i++)
		{
			characters.add(i);
		}
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(()->
		{
			message="";
			message+=" "+characters.get(random.nextInt(characters.size()));
			try {
				kafkaProducer.send(new ProducerRecord<String, String>("bddcTopic",null, message),(met,ex)->{
					System.out.println("Message : "+message+", Topic : "+met.topic()+", partition :"+met.partition());
				});
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}, 1000, 1000, TimeUnit.MILLISECONDS);
	}
}
