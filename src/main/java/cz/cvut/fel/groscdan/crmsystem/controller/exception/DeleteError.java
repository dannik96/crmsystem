package cz.cvut.fel.groscdan.crmsystem.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT, reason="Entity does not exist.")  // 304
public class DeleteError extends Exception{
}
