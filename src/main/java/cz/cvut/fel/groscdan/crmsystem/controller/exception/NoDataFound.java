package cz.cvut.fel.groscdan.crmsystem.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Entity does not exist.")  // 304
public class NoDataFound extends RuntimeException {
}
