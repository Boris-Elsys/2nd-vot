package com.example.bikeshopapi.service;

import com.example.bikeshopapi.entity.Mechanic;
import com.example.bikeshopapi.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryUpdateTask {

    private final MechanicRepository mechanicRepository;

    @Autowired
    public SalaryUpdateTask(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }
    @Scheduled(cron = "0 0 0 1 */3 *") // Runs at midnight on the 1st day of every 3rd month
    public void updateMechanicSalaries() {
        // Retrieve the list of mechanics from the database
        List<Mechanic> mechanics = mechanicRepository.findAll();

        // Update the salary for each mechanic
        for (Mechanic mechanic : mechanics) {
            Long currentSalary = mechanic.getSalary();
            // increase by 5%
            Long updatedSalary = currentSalary * 105 / 100;
            mechanic.setSalary(updatedSalary);
            mechanicRepository.save(mechanic);
        }
    }
}
