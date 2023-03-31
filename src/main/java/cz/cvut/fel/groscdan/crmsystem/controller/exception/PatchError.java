package cz.cvut.fel.groscdan.crmsystem.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_MODIFIED, reason="Some error occured.")  // 304
public class PatchError extends RuntimeException {

}
