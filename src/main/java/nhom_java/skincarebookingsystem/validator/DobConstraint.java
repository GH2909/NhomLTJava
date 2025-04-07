package nhom_java.skincarebookingsystem.validator;

import com.nimbusds.jose.Payload;
import jakarta.validation.Constraint;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { DobValidator.class })
public @interface DobConstraint {
    String message() default "Invalid date of birth";

    //Gia tri tuoi toi thieu
    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
