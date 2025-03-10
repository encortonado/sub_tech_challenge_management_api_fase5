package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.handler;

import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.adapter.outbound.publisher.VehicleDataPublisher;
import br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.exceptions.CustomErrorTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private VehicleDataPublisher vehicleDataPublisher;
    public GlobalExceptionHandler(VehicleDataPublisher vehicleDataPublisher) {
        this.vehicleDataPublisher = vehicleDataPublisher;
    }

    @ExceptionHandler(CustomErrorTypeException.class)
    public ResponseEntity<?> handleException(CustomErrorTypeException exception) {

        Map<String, Object> body = new HashMap<>();
        HttpStatus status;

        switch (exception.getMessage()) {
            case "Veiculo nao encontrado.":
                status = HttpStatus.NOT_FOUND;
                break;
            case "Veiculo ja esta holdado":
                status = HttpStatus.MULTI_STATUS;
                vehicleDataPublisher.publishVehicleData(exception.vehicleEntity);
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        body.put("errorType", status.value());
        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, status);

    }


    }
