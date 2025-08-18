package com.example.doctor_service.controller;

import com.example.doctor_service.model.DoctorSlot;
import com.example.doctor_service.service.DoctorSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors/slots")
public class DoctorSlotController {

    @Autowired
    private DoctorSlotService slotService;

    @PostMapping
    public ResponseEntity<DoctorSlot> createSlot(@RequestBody DoctorSlot slot) {
        return ResponseEntity.ok(slotService.createSlot(slot));
    }

    @GetMapping
    public ResponseEntity<List<DoctorSlot>> getAllSlots() {
        return ResponseEntity.ok(slotService.getAllSlots());
    }

    @GetMapping("/{slotId}")
    public ResponseEntity<DoctorSlot> getSlotById(@PathVariable String slotId) {
        return slotService.getSlotById(slotId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<DoctorSlot>> getSlotsByDoctorId(@PathVariable String doctorId) {
        return ResponseEntity.ok(slotService.getSlotsByDoctorId(doctorId));
    }

    @PostMapping("/{slotId}/lock")
    public ResponseEntity<?> lockSlot(@PathVariable String slotId) {
        boolean locked = slotService.lockSlot(slotId);
        if (locked) {
            return ResponseEntity.ok().body("Slot locked/booked successfully.");
        } else {
            return ResponseEntity.status(409).body("Slot already booked.");
        }
    }

    @PostMapping("/{slotId}/unlock")
    public ResponseEntity<?> unlockSlot(@PathVariable String slotId) {
        slotService.unlockSlot(slotId);
        return ResponseEntity.ok().body("Slot unlocked (set to available).");
    }

    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> deleteSlot(@PathVariable String slotId) {
        slotService.deleteSlot(slotId);
        return ResponseEntity.noContent().build();
    }
}
