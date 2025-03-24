package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDateTime;

public class CheckOutUpdateRequest {
    private LocalDateTime checkOutTime;

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
