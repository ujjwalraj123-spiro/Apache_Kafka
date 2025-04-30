package org.example.producer;

import org.example.dto.BatteryMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class BatteryProducerService {

    @Autowired
    private KafkaTemplate<String, BatteryMessage> kafkaTemplate;

    private final String[] countryCodes = {"BJ", "TG", "KE", "RW", "UG", "NG"};
    private final Random random = new Random();

    public void sendMessage(BatteryMessage message) {
        String topic = getTopicName(message.getCountryCode());
        kafkaTemplate.send(topic, message);
        System.out.println("Sent to topic [" + topic + "]: " + message);
    }

    private String getTopicName(String countryCode) {
        return switch (countryCode.toUpperCase()) {
            case "BJ" -> "Benin";
            case "TG" -> "Togo";
            case "KE" -> "Kenya";
            case "RW" -> "Rwanda";
            case "UG" -> "Uganda";
            case "NG" -> "Nigeria";
            default -> throw new IllegalArgumentException("Unsupported Country Code: " + countryCode);
        };
    }
    private final String[] batteryIds = {
            "7227AB1LBPK2446",
            "7227AB1LBPJ1205",
            "7227AB564634734",
            "7227AB1LBNF5742",
            "7227AB1LBPA4795",
            "7227AB1LBPA5447",
            "A7246AX1A1RF004790",
            "A225UA0000065",
            "7227AB1LBPK0432",
            "7227AB1LBPK0434",
            "7227AB1LBPK04343",
            "7227AB1LBPR43434",
            "7227AB1LBER34344",
            "7227AB1L36656566",
            "7227AB1L6565H434",
            "7227AB1L45454445",
            "7227AB1LBPG1655",
            "7227AB1LBPA4307",
            "7227AB1LBPK2351",
            "7227AB1LBNL3842",
            "A7246AX1A1RB001517",
            "U7245AU1G1SB001934",
            "7227AB1LBPI2651",
            "7227AB1LBPG8511",
            "7227AB1LBPG5627",
            "7227AB1LBPG1936",
            "A7246AX1A1RB001723",
            "7227AB1LBNF2501"
    };

    @Scheduled(fixedRate = 5000)
    public void sendRandomMessage() {
        int countryIndex = random.nextInt(countryCodes.length);
        String countryCode = countryCodes[countryIndex];

        int batteryIndex = random.nextInt(batteryIds.length);
        String batteryNumber = batteryIds[batteryIndex];

        BatteryMessage message = new BatteryMessage();
        message.setBatteryNumber(batteryNumber);
        message.setStationName("Station-" + random.nextInt(50));
        message.setCountryCode(countryCode);
        message.setStationCode("ST-" + random.nextInt(100));
        message.setSwapAgentDeviceTokens(generateRandomDeviceTokens());
        message.setEpochTime(String.valueOf(Instant.now().toEpochMilli()));

        sendMessage(message);
    }

    private List<String> generateRandomDeviceTokens() {
        return Arrays.asList(
                "Device-" + random.nextInt(10000),
                "Device-" + random.nextInt(10000)
        );
    }
}