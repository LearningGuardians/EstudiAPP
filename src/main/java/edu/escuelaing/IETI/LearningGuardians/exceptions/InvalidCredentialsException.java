package edu.escuelaing.IETI.LearningGuardians.exceptions;


import org.springframework.http.HttpStatus;

import edu.escuelaing.IETI.LearningGuardians.dtos.users.ServerErrorResponseDto;
import edu.escuelaing.IETI.LearningGuardians.entities.enumerations.ErrorCodeEnum;

import javax.ws.rs.InternalServerErrorException;

/**
 * @author Laura Garcia
 */
public class InvalidCredentialsException extends InternalServerErrorException {
    private ServerErrorResponseDto serverErrorResponseDto;

    public InvalidCredentialsException() {
        super();
        serverErrorResponseDto = new ServerErrorResponseDto("User not found",
                ErrorCodeEnum.USER_NOT_FOUND,
                HttpStatus.NOT_FOUND);
    }

    public InvalidCredentialsException(ServerErrorResponseDto serverErrorResponseDto) {
        super();
        this.serverErrorResponseDto = serverErrorResponseDto;
    }
}
