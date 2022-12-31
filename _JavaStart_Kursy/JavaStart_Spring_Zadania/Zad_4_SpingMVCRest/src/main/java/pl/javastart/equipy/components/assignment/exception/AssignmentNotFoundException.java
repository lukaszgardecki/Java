package pl.javastart.equipy.components.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Nie istnieje przypisanie o takim iD"
)
public class AssignmentNotFoundException extends RuntimeException{
}
