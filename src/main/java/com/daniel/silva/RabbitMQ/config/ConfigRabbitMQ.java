package com.daniel.silva.RabbitMQ.config;

import com.daniel.silva.RabbitMQ.exceptions.TratamentoErrorHandler;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMQ {


    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public TratamentoErrorHandler tratamentoErrorHandler() {
        return new TratamentoErrorHandler();
    }



}
