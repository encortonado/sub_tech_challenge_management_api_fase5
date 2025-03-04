package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.services;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.entrypoint.persistance.VehicleRepository;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.ports.IVehicleService;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.exceptions.CustomErrorTypeException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public List<VehicleEntity> listVehicles() {
        return vehicleRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public VehicleEntity registerVehicle(VehicleEntity vehicleEntityDTO) {
        return vehicleRepository.save(vehicleEntityDTO);
    }

    @Override
    public VehicleEntity updateVehicleRegister(VehicleEntity vehicleEntity) {

        findById(vehicleEntity.getId());
        return vehicleRepository.save(vehicleEntity);
    }

    @Override
    public VehicleEntity findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new CustomErrorTypeException("Veiculo nao encontrado"));
    }


}
