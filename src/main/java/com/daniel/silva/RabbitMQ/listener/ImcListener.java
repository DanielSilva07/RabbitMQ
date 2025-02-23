package com.daniel.silva.RabbitMQ.listener;
import com.daniel.silva.RabbitMQ.constante.Mensagem;
import com.daniel.silva.RabbitMQ.domain.Cliente;
import com.daniel.silva.RabbitMQ.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ImcListener {

    private final NotificationService notificationService;

    public ImcListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.imc}")
    public void listenToImcQueue(Cliente cliente) {
        String mensagem = String.format(Mensagem.IMC,cliente.getNome(),
                cliente.getImc());
        notificationService.sendNotification(mensagem);

    }
}
