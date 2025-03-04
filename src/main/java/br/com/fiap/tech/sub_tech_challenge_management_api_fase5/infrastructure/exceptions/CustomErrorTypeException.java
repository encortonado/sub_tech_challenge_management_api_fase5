package br.com.fiap.tech.sub_tech_challenge_management_api_fase5.infrastructure.exceptions;


public class CustomErrorTypeException extends RuntimeException{

    public CustomErrorTypeException (String msg) {
        super(msg);
    }
}
