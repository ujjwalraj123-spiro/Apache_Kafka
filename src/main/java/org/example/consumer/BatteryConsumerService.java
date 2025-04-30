package org.example.consumer;

import org.example.dto.BatteryMessage;
import org.example.dto.BmsEntity;
import org.example.repository.KafkaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class BatteryConsumerService {

    @Autowired
    private KafkaRepo kafkaRepo;

    @KafkaListener(topics = {"Benin", "Togo", "Kenya", "Rwanda", "Uganda", "Nigeria"}, groupId = "soc-monitor-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(BatteryMessage message) {
        System.out.println("🔵 Consumed BatteryMessage: " + message);

        String batteryNumber = message.getBatteryNumber();

        BmsEntity battery = kafkaRepo.findByBmsId(batteryNumber);
        if (battery != null && battery.getSoc() < 10) {
            System.out.println("⚡ Alert! SOC low for battery: " + batteryNumber + " Battery-SOC: " + battery.getSoc());
        } else if (battery == null) {
            System.out.println("⚠️ Battery not found: " + batteryNumber);
        }
    }
}
