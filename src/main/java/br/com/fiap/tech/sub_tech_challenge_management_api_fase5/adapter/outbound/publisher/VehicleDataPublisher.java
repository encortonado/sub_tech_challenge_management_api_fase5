package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.outbound.publisher;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class VehicleDataPublisher {

    private final RabbitTemplate rabbitTemplate;
    private static VehicleEntity vehicleEntity;

    public VehicleDataPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishVehicleData(VehicleEntity vehicleEntity) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_VEHICLE, RabbitMQConfig.QUEUE_VEHICLE_DATA, vehicleEntity);
    }


}
