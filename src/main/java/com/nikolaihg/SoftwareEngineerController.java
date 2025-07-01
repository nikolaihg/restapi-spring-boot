package com.nikolaihg;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private List<SoftwareEngineer> softwareEngineers = new ArrayList<>(List.of(
            new SoftwareEngineer(1, "James", "js, node, react, tailwindcss"),
            new SoftwareEngineer(2, "Jamila", "java, spring, spring boot")
    ));

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineers;
    }

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
}
