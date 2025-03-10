package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.outbound.listener;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.outbound.model.PurchaseEventDTO;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.services.VehicleService;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class SaleListener {

    public static final String QUEUE_SALE_STARTED = "sale.started.queue";
    public static final String QUEUE_SALE_COMPLETED = "sale.completed.queue";
    Logger LOGGER = Logger.getLogger(String.valueOf(SaleListener.class));

    private final VehicleService vehicleService;

    public SaleListener(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Bean
    public Queue saleStartedQueue() {
        return new Queue(QUEUE_SALE_STARTED, true);
    }

    @RabbitListener(queues = QUEUE_SALE_STARTED)
    public void handleSaleStartedEvent(PurchaseEventDTO vehicleId) {
        LOGGER.log(
                Level.INFO,
                "Evento de "+ QUEUE_SALE_STARTED + " recebido com a mensagem: " + vehicleId);

        vehicleService.holdVehicle(vehicleId.getVehicleId());
    }

    @RabbitListener(queues = QUEUE_SALE_COMPLETED)
    public void handleSaleFinishedEvent(PurchaseEventDTO vehicleId) {
        LOGGER.log(
                Level.INFO,
                "Evento de "+ QUEUE_SALE_COMPLETED + " recebido com a mensagem: " + vehicleId);

        vehicleService.releaseVehicle(vehicleId.getVehicleId());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
