package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.entrypoint.persistance;


import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.entrypoint.persistance.VehicleRepository;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities.VehicleEntity;
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

import static org.mockito.Mockito.*;

class VehicleRepositoryTest {

    @Mock
    private VehicleRepository vehicleRepository;

    AutoCloseable openMocks;

    @BeforeEach()
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception{
        openMocks.close();
    }

    @Nested
    class VehicleRepo {

        @Nested
        class createVehicle {

            @Test
            void createVehicleRegisterTest() {

                VehicleEntity vehicleEntity = TestUtils.buildVehicleEntity();

                when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(vehicleEntity);

                var vehicleRegistered = vehicleRepository.save(vehicleEntity);

                Assertions.assertThat(vehicleRegistered)
                        .isNotNull()
                        .isInstanceOf(VehicleEntity.class)
                        .isEqualTo(vehicleEntity);

                verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));

            }

            @Test
            void updateVehicleRegisterTest() {
                VehicleEntity vehicleEntity = TestUtils.buildVehicleEntity();

                when(vehicleRepository.findById(any(Long.class))).thenReturn(Optional.of(vehicleEntity));

                VehicleEntity updateVehicle = vehicleRepository.findById(vehicleEntity.getId()).get();
                updateVehicle.setBrand("Corolla");

                when(vehicleRepository.save(any(VehicleEntity.class))).thenReturn(updateVehicle);

                var vehicleRegistered = vehicleRepository.save(updateVehicle);

                Assertions.assertThat(vehicleRegistered)
                        .isNotNull()
                        .isInstanceOf(VehicleEntity.class)
                        .isEqualTo(vehicleEntity);

                verify(vehicleRepository, times(1)).save(any(VehicleEntity.class));
            }

        }

        @Nested
        class listAllVehicles {

            @Nested
            class listVehicles {

                @Test
                void listAllVehiclesTest() {
                    VehicleEntity vehicleEntity = TestUtils.buildVehicleEntity();
                    VehicleEntity vehicleEntity2 = TestUtils.anotherBuildVehicleEntity();

                    List<VehicleEntity> vehicleEntityList = new ArrayList<>();
                    vehicleEntityList.add(vehicleEntity);
                    vehicleEntityList.add(vehicleEntity2);

                    when(vehicleRepository.findAllByOrderByPriceAsc()).thenReturn(vehicleEntityList);

                    var vehicleList = vehicleRepository.findAllByOrderByPriceAsc();
                    Assertions.assertThat(vehicleList)
                            .isNotNull()
                            .isInstanceOf(List.class)
                            .isEqualTo(vehicleEntityList);

                    verify(vehicleRepository, times(1)).findAllByOrderByPriceAsc();

                }

            }

        }

    }
}