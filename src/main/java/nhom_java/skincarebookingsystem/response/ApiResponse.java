package nhom_java.skincarebookingsystem.response;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
     int code = 1000; // code=1000 -> run thanh cong
     String message;
     T result;
}
