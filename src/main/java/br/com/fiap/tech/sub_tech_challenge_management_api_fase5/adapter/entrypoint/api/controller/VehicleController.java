package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.entrypoint.api.controller;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/vehicle")
public class VehicleController {


    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> findAll() {
        return ResponseEntity.ok().body(vehicleService.listVehicles());
    }


    @PostMapping
    public ResponseEntity<VehicleEntity> save(@RequestBody VehicleEntity vehicleEntity) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicleService.registerVehicle(vehicleEntity));
    }

    @PutMapping
    public ResponseEntity<VehicleEntity> update(@RequestBody VehicleEntity vehicleEntity) {
        return ResponseEntity.ok().body(vehicleService.updateVehicleRegister(vehicleEntity));
    }


}
