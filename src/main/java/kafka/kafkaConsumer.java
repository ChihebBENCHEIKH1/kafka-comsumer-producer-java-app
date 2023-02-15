package kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;

public class kafkaConsumer {

	public static void main(String[] args) {
		new kafkaConsumer().start();

	}

	private void start() {
		Properties properties=new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		properties.put(ProducerConfig.CLIENT_ID_CONFIG,"stream-consumer-1");
		properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"stream-consumer-1-id");
		properties.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,1000);
		StreamsBuilder builder=new StreamsBuilder();
		KStream<String, String> kStream=builder.stream("bddcTopic",Consumed.with(Serdes.String(), Serdes.String()));
		kStream.filter((k,v)->
			 v.equals("a")|| v.equals("c")
		).foreach((k,v)->{
			System.out.println("Key : "+k+"-- Value : "+v);
		});
		Topology topology=builder.build();
		KafkaStreams kafkaStreams=new KafkaStreams(topology, properties);
		kafkaStreams.start();
		
	}

}
