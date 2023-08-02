package com.upgrad.hirewheels.controller;

import com.upgrad.hirewheels.dto.VehicleDTO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hirewheels/v1")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        List<VehicleDTO> vehiclesDTOList = new ArrayList<>();

        for(Vehicle vehicle : vehicleList){
            vehiclesDTOList.add(modelMapper.map(vehicle, VehicleDTO.class));
        }

        return new ResponseEntity(vehiclesDTOList, HttpStatus.OK);
    }
}
