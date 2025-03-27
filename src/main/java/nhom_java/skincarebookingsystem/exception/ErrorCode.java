package nhom_java.skincarebookingsystem.exception;

public enum ErrorCode {
    USER_EXISTED(1002,"User existed"),
    UNCATEG0RIZED_EXCEPTION(9999,"Uncategorized error"),
    INVALID_KEY(1001,"Invalid message key"),
    USER_NOT_EXISTED(1005,"User not existed"),

    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
