package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {


    public static final String EXCHANGE_VEHICLE = "vehicle-exchange";
    public static final String QUEUE_VEHICLE_DATA = "vehicle.data.queue";

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public TopicExchange vehicleExchange() {
        return new TopicExchange(EXCHANGE_VEHICLE);
    }

    @Bean
    public Queue vehicleDataQueue() {
        return new Queue(QUEUE_VEHICLE_DATA);
    }

    @Bean
    public Binding bindVehicleDataQueue(Queue vehicleDataQueue, TopicExchange vehicleExchange) {
        return BindingBuilder.bind(vehicleDataQueue).to(vehicleExchange).with(QUEUE_VEHICLE_DATA);
    }

}
