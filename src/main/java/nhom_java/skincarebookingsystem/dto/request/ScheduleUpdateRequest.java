package nhom_java.skincarebookingsystem.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleUpdateRequest {
    private LocalDate workDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
