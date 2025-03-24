package nhom_java.skincarebookingsystem.controllers;

import nhom_java.skincarebookingsystem.dto.request.CancellationCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CancellationUpdateRequest;
import nhom_java.skincarebookingsystem.models.Cancellation;
import nhom_java.skincarebookingsystem.services.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancellations")
public class CancellationController {
    @Autowired
    private CancellationService cancellationService;

    @PostMapping
    public Cancellation createCancellation(@RequestBody CancellationCreationRequest request) {
        return cancellationService.createCancellation(request);
    }

    @GetMapping
    public List<Cancellation> getCancellations() {
        return cancellationService.getCancellations();
    }

    @GetMapping("/{cancellationID}")
    public Cancellation getCancellation(@PathVariable Long cancellationID) {
        return cancellationService.getCancellation(cancellationID);
    }

    @PutMapping("/{cancellationID}")
    public Cancellation updateCancellation(@PathVariable Long cancellationID, @RequestBody CancellationUpdateRequest request) {
        return cancellationService.updateCancellation(cancellationID, request);
    }

    @DeleteMapping("/{cancellationID}")
    public String deleteCancellation(@PathVariable Long cancellationID) {
        cancellationService.deleteCancellation(cancellationID);
        return "Cancellation has been deleted";
    }
}
