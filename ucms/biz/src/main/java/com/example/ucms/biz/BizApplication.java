package com.example.ucms.biz;

import com.example.ucms.biz.receiver.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BizApplication {


	final static String queueNanme = "test-queue";
	final static String exchangeName = "test-topic-exchange";
	final static String rabbitMQHost = "192.168.99.100";
	final static int rabbidMQPort = 5672;
	final static String userName = "admin";
	final static String passWord = "admin";

	@Bean
	Queue queue(){
		return new Queue(queueNanme, false);
	}

	@Bean
	TopicExchange topicExchange(){
		return new TopicExchange(exchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange topicExchange){
		return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
	}

	@Bean
	MessageListenerAdapter adapter(Receiver receiver){
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	ConnectionFactory connectionFactory(){
		CachingConnectionFactory factory = new CachingConnectionFactory();
		factory.setHost(rabbitMQHost);
		factory.setPort(rabbidMQPort);
		factory.setUsername(userName);
		factory.setPassword(passWord);
		factory.setVirtualHost("/");
		factory.setPublisherConfirms(true);
		return factory;
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter adapter){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueNanme);
		container.setMessageListener(adapter);
		return container;
	}

		public static void main(String[] args) {
		SpringApplication.run(BizApplication.class, args);
	}

}

