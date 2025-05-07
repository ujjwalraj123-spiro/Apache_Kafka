package org.example.consumer;

import org.example.dto.BatteryMessage;
import org.example.dto.BmsEntity;
import org.example.repository.KafkaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BatteryConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(BatteryConsumerService.class);

    @Autowired
    private KafkaRepo kafkaRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${alert.api.url}")
    private String alertApiUrl;

    @KafkaListener(topics = {"Benin", "Togo", "Kenya", "Rwanda", "Uganda", "Nigeria"}, groupId = "soc-monitor-group")
    public void consume(BatteryMessage message) {
        logger.info("🔵 Consumed BatteryMessage: {}", message);

        String batteryNumber = message.getBatteryNumber();
        BmsEntity battery = kafkaRepo.findByBmsId(batteryNumber);

        if (battery != null) {
            logger.debug("Battery [{}] found with SOC: {}", batteryNumber, battery.getSoc());

            if (battery.getSoc() < 10) {
                logger.warn("⚡ Alert! SOC low for battery: {} Battery-SOC: {}", batteryNumber, battery.getSoc());
                sendCriticalSocAlert(Collections.singletonList(batteryNumber));
            } else {
                logger.info("Battery SOC is above threshold: {} SOC: {}", batteryNumber, battery.getSoc());
            }
        } else {
            logger.warn("Battery not found in DB for battery number: {}", batteryNumber);
        }
    }

    private void sendCriticalSocAlert(List<String> criticalBatteries) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("userIds", "1212121211211");
        requestBody.put("type", "MOBILE_NOTIFICATION");
        requestBody.put("subject", "Critical SOC Alert");
        requestBody.put("body", "These batteries need your attention");

        Map<String, Object> data = new HashMap<>();
        data.put("alertDate", OffsetDateTime.now().toString());
        data.put("criticalSOCBatteries", String.join(",", criticalBatteries));
        data.put("noDataBatteries", "");
        data.put("offlineBatteries", "");

        requestBody.put("data", data);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(alertApiUrl, request, String.class);
            logger.info("✅ Alert successfully sent for battery IDs {}. Response: {} - {}", criticalBatteries, response.getStatusCode(), response.getBody());
        } catch (Exception e) {
            logger.error("❌ Failed to send alert for batteries {}: {}", criticalBatteries, e.getMessage(), e);
        }
    }
}
