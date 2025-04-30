package org.example.controller;

import org.example.dto.BatteryMessage;
import org.example.producer.BatteryProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produce")
public class BatteryProducerController {

    @Autowired
    private BatteryProducerService producerService;

    @PostMapping
    public String produce(@RequestBody BatteryMessage message) {
        producerService.sendMessage(message);
        return "Battery message sent!";
    }
}
