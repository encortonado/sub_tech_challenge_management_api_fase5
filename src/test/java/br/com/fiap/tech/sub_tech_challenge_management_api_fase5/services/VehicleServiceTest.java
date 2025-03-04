package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.services;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.entrypoint.persistance.VehicleRepository;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.services.VehicleService;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.exceptions.CustomErrorTypeException;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    private VehicleService vehicleService;

    AutoCloseable mock;


    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        vehicleService = new VehicleService(vehicleRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }

    @Nested
    class VehiclesServiceTest {

        @Test
        void listVehicles() {

            List<VehicleEntity> vehicles = new ArrayList<>();
            vehicles.add(TestUtils.buildVehicleEntity());
            vehicles.add(TestUtils.buildVehicleEntity());
            vehicles.add(TestUtils.anotherBuildVehicleEntity());

            when(vehicleRepository.findAllByOrderByPriceAsc()).thenReturn(vehicles);

            List<VehicleEntity> result = vehicleService.listVehicles();

            Assertions.assertThat(result)
                    .hasSize(3)
                    .containsExactly(vehicles.get(0), vehicles.get(1), vehicles.get(2));

            Assertions.assertThat(result.stream())
                    .asList()
                    .allSatisfy(msg -> {
                        Assertions.assertThat(msg).isNotNull().isInstanceOf(VehicleEntity.class);
                    });


        }

        @Test
        void registerVehicle() {

            VehicleEntity vehicleEntity = TestUtils.buildVehicleEntityWithoutId();

            when(vehicleRepository.save(any(VehicleEntity.class)))
                    .thenAnswer(invocation -> {
                        VehicleEntity entity = invocation.getArgument(0);
                        entity.setId(1L);
                        return entity;
                    });

            var registeredVehicle = vehicleService.registerVehicle(vehicleEntity);

            Assertions.assertThat(registeredVehicle).isInstanceOf(VehicleEntity.class).isNotNull();
            Assertions.assertThat(registeredVehicle.getId()).isNotNull();

            verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));

        }

        @Test
        void updateVehicleRegister() {

            VehicleEntity vehicleEntity = TestUtils.buildVehicleEntityWithoutId();
            vehicleEntity.setId(1L);
            var id = vehicleEntity.getId();

            VehicleEntity updatedVehicle = TestUtils.buildVehicleEntityWithoutId();
            updatedVehicle.setId(id);
            updatedVehicle.setBrand("pegasus");

            when(vehicleRepository.findById(id))
                    .thenReturn(Optional.of(vehicleEntity));

            when(vehicleRepository.save(any(VehicleEntity.class)))
                    .thenAnswer(invocation -> {
                        VehicleEntity entity = invocation.getArgument(0);
                        entity.setId(1L);
                        return entity;
                    });

            var vehicleUpdated = vehicleService.updateVehicleRegister(updatedVehicle);

            Assertions.assertThat(vehicleUpdated)
                    .isInstanceOf(VehicleEntity.class)
                    .isNotEqualTo(vehicleEntity)
                    .hasFieldOrPropertyWithValue("brand", "pegasus");

            verify(vehicleRepository, times(1)).findById(id);
            verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));

        }



    }

    @Test
    void shouldThrowExceptionWhenVehicleNotFound() {

        Long nonExistentId = 999L;
        when(vehicleRepository.findById(nonExistentId)).thenReturn(Optional.empty());


        assertThatThrownBy(() -> vehicleService.findById(nonExistentId))
                .isInstanceOf(CustomErrorTypeException.class)
                .hasMessage("Veiculo nao encontrado");


        verify(vehicleRepository).findById(nonExistentId);
    }


}