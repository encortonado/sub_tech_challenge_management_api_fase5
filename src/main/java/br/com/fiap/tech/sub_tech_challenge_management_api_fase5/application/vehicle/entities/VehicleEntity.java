package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.application.vehicle.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_VEHICLE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Brand cannot be blank")
    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @NotBlank(message = "Model cannot be blank")
    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @NotBlank(message = "Color cannot be blank")
    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @NotNull(message = "Year cannot be null")
    @Column(name = "year_manufactured")
    private int year;

    @Positive(message = "Price must be positive")
    private double price;

}
