package com.nikolaihg;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineersById(@PathVariable Integer id) {
        return softwareEngineerService.getAllSoftwareEngineerById(id);
    }

    @PostMapping
    public void AddNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        // should use dto
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    /*
    @PostMapping
    public SoftwareEngineer addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineer.setId(softwareEngineers.size() + 1);
        softwareEngineers.add(softwareEngineer);
        return softwareEngineer;
    }

    @PutMapping("/{id}")
    public SoftwareEngineer updateSoftwareEngineer(
            @PathVariable int id,
            @RequestBody SoftwareEngineer updatedEngineer) {

        Optional<SoftwareEngineer> existingEngineer = softwareEngineers.stream()
                .filter(se -> se.getId() == id)
                .findFirst();

        if (existingEngineer.isPresent()) {
            SoftwareEngineer engineer = existingEngineer.get();
            engineer.setName(updatedEngineer.getName());
            engineer.setTechStack(updatedEngineer.getTechStack());
            return engineer;
        } else {
            throw new RuntimeException("SoftwareEngineer with id " + id + " not found.");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteSoftwareEngineer(@PathVariable int id) {
        boolean removed = softwareEngineers.removeIf(se -> se.getId() == id);
        if (removed) {
            return "Deleted software engineer with id " + id;
        } else {
            return "Software engineer with id " + id + " not found.";
        }
    }
    */
}
