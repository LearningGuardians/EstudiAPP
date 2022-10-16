package edu.escuelaing.IETI.LearningGuardians.dtos;

import edu.escuelaing.IETI.LearningGuardians.entities.enumerations.ErrorCodeEnum;

public  class  ServerErrorResponseDto {

	String  message;
	ErrorCodeEnum  errorCode;
	int  httpStatus;

	public  ServerErrorResponseDto(String  message, ErrorCodeEnum  errorCode, HttpStatus  httpStatus) {
		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus.value();
	}
	public  String  getMessage() {
		return  message;
	}
	
	public  ErrorCodeEnum  getErrorCode() {
		return  errorCode;
	}

	public  int  getHttpStatus() {
		return  httpStatus;
	}

}