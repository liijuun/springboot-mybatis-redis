package com.example.ucms.biz;

import com.example.ucms.biz.rabbitMQProducer.Producer;
import com.example.ucms.biz.receiver.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BizApplication {

	private final static String queueName = "test-queue";
	private final static String exchangeName = "test-topic-exchange";
	private final static String rabbitMQHost = "192.168.99.100";
	private final static int rabbitMQPort = 5672;
	private final static String userName = "guest";
	private final static String passWord = "guest";

//	@Bean
//	Queue queue(){
//		return new Queue(queueName, false);
//	}
//
//	@Bean
//	TopicExchange topicExchange(){
//		return new TopicExchange(exchangeName);
//	}
//
//	@Bean
//	Binding binding(Queue queue, TopicExchange topicExchange){
//		return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
//	}
//
//	@Bean
//	MessageListenerAdapter adapter(Receiver receiver){
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}
//
//	@Bean
//	ConnectionFactory connectionFactory(){
//		CachingConnectionFactory factory = new CachingConnectionFactory();
//		factory.setHost(rabbitMQHost);
//		factory.setPort(rabbitMQPort);
//		factory.setUsername(userName);
//		factory.setPassword(passWord);
//		factory.setVirtualHost("/");
//		factory.setPublisherConfirms(true);
//		return factory;
//	}
//
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter adapter){
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		container.setMessageListener(adapter);
//		return container;
//	}

		public static void main(String[] args) {
		SpringApplication.run(BizApplication.class, args);
	}


}

