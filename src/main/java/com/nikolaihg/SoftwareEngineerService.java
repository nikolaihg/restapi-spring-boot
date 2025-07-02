package com.nikolaihg;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        return softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getAllSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Software engineer with id " + id + " not found"));
    }

    public void updateSoftwareEngineerByID(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer existingEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Software engineer with id " + id + " not found"));

        existingEngineer.setName(updatedEngineer.getName());
        existingEngineer.setTechStack(updatedEngineer.getTechStack());
        softwareEngineerRepository.save(existingEngineer);
    }

    public void deleteSoftwareEngineerByID(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Software engineer with id " + id + " does not exist");
        }
        softwareEngineerRepository.deleteById(id);
    }
}
