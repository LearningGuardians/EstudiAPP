package edu.escuelaing.IETI.LearningGuardians.exceptions;

import javax.ws.rs.InternalServerErrorException;

import org.springframework.http.HttpStatus;

import edu.escuelaing.IETI.LearningGuardians.dtos.ServerErrorResponseDto;
import edu.escuelaing.IETI.LearningGuardians.entities.enumerations.ErrorCodeEnum;

public class InvalidCredentialsException extends InternalServerErrorException {
    public InvalidCredentialsException() {
        super();
        //new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}