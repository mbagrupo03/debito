package com.microservices.grupo3.debito.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TipoContaBadRequestException extends RuntimeException {

    public TipoContaBadRequestException(String msg) {
        super(msg);
    }
}
