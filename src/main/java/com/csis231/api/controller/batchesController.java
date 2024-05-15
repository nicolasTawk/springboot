package com.csis231.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.csis231.api.service.batchesService;
import com.csis231.api.model.batches;

import java.util.List;

@RestController
@RequestMapping("/batches")
public class batchesController { // Corrected class name

    @Autowired
    private batchesService batchesService; // Corrected variable name

    @GetMapping
    public List<batches> getAllBatches() {
        return batchesService.getAllBatches(); // Corrected method call
    }

    @GetMapping("/{batchId}")
    public batches getBatchById(@PathVariable int batchId) {
        return batchesService.getBatchById(batchId); // Corrected method call
    }

    @PostMapping
    public batches addBatch(@RequestBody batches batch) {
        return batchesService.addBatch(batch); // Corrected method call
    }

    @PutMapping("/update/{batchId}")
    public batches updateBatch(@PathVariable int batchId, @RequestBody batches updatedBatch) {
        return batchesService.updateBatch(batchId, updatedBatch); // Corrected method call
    }

    @DeleteMapping("/delete/{batchId}")
    public void deleteBatch(@PathVariable int batchId) {
        batchesService.deleteBatch(batchId); // Corrected method call
    }

    @GetMapping("/expiring-batches")
    public List<batches> getExpiringBatches() {
        return batchesService.getBatchesExpiringWithinOneMonth();

    }
    @DeleteMapping("/expired")
    public void removeExpiredProducts() {
        batchesService.removeExpiredProducts(); // Corrected method call
    }
}
