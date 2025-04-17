package nhom_java.skincarebookingsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1002,"User existed", HttpStatus.BAD_REQUEST),
    UNCATEG0RIZED_EXCEPTION(9999,"Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_KEY(1001,"Invalid message key", HttpStatus.BAD_REQUEST),
    USERNAME_EXISTED(1003,"Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD (1004,"Password must be at least {min} characters", HttpStatus.FORBIDDEN),
    USER_NOT_EXISTED(1005,"User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED (1006,"Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED (1007,"You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB (1008,"you age must be at least {min}", HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(1009,"Role not found", HttpStatus.NOT_FOUND),
    NOT_EXISTED(1010,"Not existed", HttpStatus.NOT_FOUND)
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
