package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.services;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.outbound.publisher.VehicleDataPublisher;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleEventService {

    @Autowired
    private static VehicleDataPublisher vehicleDataPublisher;

    public static void sendVehicleData(VehicleEntity vehicleEntity) {
        vehicleDataPublisher.publishVehicleData(vehicleEntity);
    }


}
