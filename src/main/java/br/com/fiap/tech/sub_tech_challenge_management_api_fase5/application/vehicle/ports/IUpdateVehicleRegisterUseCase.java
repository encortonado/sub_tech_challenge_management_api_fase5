package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.ports;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;

public interface IUpdateVehicleRegisterUseCase {

    VehicleEntity updateVehicleRegister(VehicleEntity vehicleEntity);

}
