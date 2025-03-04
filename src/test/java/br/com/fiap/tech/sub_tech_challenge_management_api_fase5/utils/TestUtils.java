package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.utils;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestUtils {

    public static VehicleEntity buildVehicleEntity() {

        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(1L);
        vehicleEntity.setYear(2023);
        vehicleEntity.setBrand("Ford");
        vehicleEntity.setModel("Ka");
        vehicleEntity.setColor("Red");
        vehicleEntity.setPrice(244400.00);

        return vehicleEntity;
    }

    public static VehicleEntity buildVehicleEntityWithoutId() {

        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setYear(2023);
        vehicleEntity.setBrand("Ford");
        vehicleEntity.setModel("Ka");
        vehicleEntity.setColor("Red");
        vehicleEntity.setPrice(244400.00);

        return vehicleEntity;
    }

    public static VehicleEntity anotherBuildVehicleEntity() {

        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(5L);
        vehicleEntity.setYear(2021);
        vehicleEntity.setBrand("toyota");
        vehicleEntity.setModel("etios");
        vehicleEntity.setColor("gray");
        vehicleEntity.setPrice(232400.00);

        return vehicleEntity;
    }

    public static String asJsonString(final Object obj) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();

        om.registerModule(new JavaTimeModule());

        return om.writeValueAsString(obj);
    }
}
