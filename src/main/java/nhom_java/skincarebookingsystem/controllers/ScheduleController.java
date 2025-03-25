package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ScheduleCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ScheduleUpdateRequest;
import nhom_java.skincarebookingsystem.models.WorkSchedule;
import nhom_java.skincarebookingsystem.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sche")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/{email}")
    WorkSchedule createSchedule(@PathVariable String email, @RequestBody ScheduleCreationRequest request) {
        return scheduleService.createSchedule(email, request);
    }

    @PutMapping("/{email}")
    WorkSchedule updateSchedule(@PathVariable String email, @RequestBody ScheduleUpdateRequest request) {
        return scheduleService.updateSchedule(email, request);
    }

    @GetMapping
    List<WorkSchedule> getSchedules(){
        return scheduleService.getSchedules();
    }

    @GetMapping("/{email}")
    WorkSchedule getSchedule(@PathVariable String email){
        return scheduleService.getSchedule(email);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteSchedule(@PathVariable String email){
        scheduleService.deleteSchedule(email);
        return "Work Schedule has been deleted";
    }
}
