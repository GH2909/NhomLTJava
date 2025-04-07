package nhom_java.skincarebookingsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1002,"User existed", HttpStatus.BAD_REQUEST),
    UNCATEG0RIZED_EXCEPTION(9999,"Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_KEY(1001,"Invalid message key", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD (1004,"Password must be at least 6 characters", HttpStatus.FORBIDDEN),
    USER_NOT_EXISTED(1005,"User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED (1006,"Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED (1007,"You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB (1008,"Invalid date of birth", HttpStatus.BAD_REQUEST),
    ;
    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;

    private HttpStatusCode statusCode;


}
