package com.daniel.silva.RabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMQ {

    private ConnectionFactory connectionFactory;

    @Bean
    public Queue criarFilaAgendamento() {
        return QueueBuilder.durable("agendamento-feito.ms-agendamento").build();
    }

    @Bean
    public RabbitAdmin CriarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent>inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange criarExchangeAgendamento() {
        return ExchangeBuilder.fanoutExchange("agendamento-exchange").build();
    }

    @Bean
    public Binding criarBindingAgendamento() {
        return BindingBuilder.bind(criarFilaAgendamento()).to(criarExchangeAgendamento());
    }



}
