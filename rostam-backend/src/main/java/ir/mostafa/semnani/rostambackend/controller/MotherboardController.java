package ir.mostafa.semnani.rostambackend.controller;

import ir.mostafa.semnani.rostambackend.dto.MotherboardDTO;
import ir.mostafa.semnani.rostambackend.service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motherboard")
public class MotherboardController {

    @Autowired
    private MotherboardService motherboardService;

    @PostMapping("/create")
    ResponseEntity createMotherboard(@RequestBody MotherboardDTO createDTO) {
        motherboardService.create(createDTO);
        return ResponseEntity.ok(createDTO);
    }

    @DeleteMapping("/deleteByid/{id}")
    ResponseEntity deleteMotherboard(@PathVariable Long id) {
        motherboardService.delete(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity updateMotherboard(@RequestBody MotherboardDTO updateDTO, @PathVariable Long id) {
        motherboardService.update(updateDTO, id);
        return ResponseEntity.ok(updateDTO);
    }

    @GetMapping("/findAll")
    List<MotherboardDTO> findAllMotherboard() {
        return motherboardService.findAll();
    }

    @GetMapping("/findByid/{id}")
    ResponseEntity findByid(@PathVariable Long id) {
        MotherboardDTO motherboardDTO = motherboardService.findById(id);
        return ResponseEntity.ok(motherboardDTO);
    }


}
