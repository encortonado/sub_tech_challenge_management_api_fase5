package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.ports;

public interface IVehicleService extends
    IRegisterVehicleUseCase,
    IUpdateVehicleRegisterUseCase,
    IListVehiclesUseCase,
    IFindVehicleById {
}
