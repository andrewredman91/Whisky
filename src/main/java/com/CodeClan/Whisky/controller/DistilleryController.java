package com.CodeClan.Whisky.controller;

import com.CodeClan.Whisky.models.Distillery;
import com.CodeClan.Whisky.models.Whisky;
import com.CodeClan.Whisky.repository.DistilleryRepository;
import com.CodeClan.Whisky.repository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/region")
    public ResponseEntity<List<Distillery>> getDistilleriesByRegion(
            @RequestParam(name="named") String region)
    {
        return new ResponseEntity<>(distilleryRepository.findByRegion(region),HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whiskies/age/12")
    public ResponseEntity<List<Distillery>> getDistilleriesByWhiskiesOf12Years()

    {
        return new ResponseEntity<>(distilleryRepository.findByWhiskies_Age(12),HttpStatus.OK);
    }

}
