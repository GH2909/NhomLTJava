package nhom_java.skincarebookingsystem.controllers.customer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CFeedbackController {
    @GetMapping("/customer/submit-feedback")
    public String showFeedbackPage() {
        return "customer/feedback";
    }
}
