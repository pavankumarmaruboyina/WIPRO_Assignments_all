package com.example.doctor_service.service;

import com.example.doctor_service.model.DoctorSlot;
import com.example.doctor_service.repository.DoctorSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorSlotService {

    @Autowired
    private DoctorSlotRepository doctorSlotRepository;

    public DoctorSlot createSlot(DoctorSlot slot) {
        slot.setBooked(false); // By default new slots are available
        return doctorSlotRepository.save(slot);
    }

    public List<DoctorSlot> getAllSlots() {
        return doctorSlotRepository.findAll();
    }

    public Optional<DoctorSlot> getSlotById(String id) {
        return doctorSlotRepository.findById(id);
    }

    public List<DoctorSlot> getSlotsByDoctorId(String doctorId) {
        return doctorSlotRepository.findByDoctorId(doctorId);
    }

    @Transactional
    public boolean lockSlot(String slotId) {
        DoctorSlot slot = doctorSlotRepository.findById(slotId)
            .orElseThrow(() -> new RuntimeException("Slot not found"));
        if (slot.isBooked()) {
            return false; // Already booked
        }
        slot.setBooked(true);
        doctorSlotRepository.save(slot);
        return true;
    }

    public void unlockSlot(String slotId) {
        doctorSlotRepository.findById(slotId).ifPresent(slot -> {
            slot.setBooked(false);
            doctorSlotRepository.save(slot);
        });
    }

    public void deleteSlot(String id) {
        doctorSlotRepository.deleteById(id);
    }
}
