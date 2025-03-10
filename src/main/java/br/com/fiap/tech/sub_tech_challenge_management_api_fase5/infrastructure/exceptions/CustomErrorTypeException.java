package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.exceptions;


import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;

public class CustomErrorTypeException extends RuntimeException{

    public VehicleEntity vehicleEntity;

    public CustomErrorTypeException (String msg) {
        super(msg);
    }
    public CustomErrorTypeException (String msg, VehicleEntity vehicleEntity) {

        super(msg);
        this.vehicleEntity = vehicleEntity;
    }

}
