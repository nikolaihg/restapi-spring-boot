package com.nikolaihg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v2/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public ResponseEntity<List<SoftwareEngineer>> getSoftwareEngineers() {
        List<SoftwareEngineer> engineers = softwareEngineerService.getAllSoftwareEngineers();
        return ResponseEntity.ok(engineers);
    }

    @GetMapping("{id}")
    public ResponseEntity<SoftwareEngineer> getSoftwareEngineersById(@PathVariable Integer id) {
        SoftwareEngineer engineer = softwareEngineerService.getAllSoftwareEngineerById(id);
        return ResponseEntity.ok(engineer);
    }

    @PostMapping
    public ResponseEntity<Void> addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        SoftwareEngineer createdEngineer = softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
        URI location = URI.create(String.format("/api/v2/software-engineers/%d", createdEngineer.getId()));
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineerByID(id, softwareEngineer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerByID(id);
        return ResponseEntity.noContent().build();
    }
}
