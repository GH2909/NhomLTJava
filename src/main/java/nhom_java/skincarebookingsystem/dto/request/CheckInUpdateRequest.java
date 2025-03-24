package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDateTime;

public class CheckInUpdateRequest {
    private LocalDateTime checkInTime;

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
