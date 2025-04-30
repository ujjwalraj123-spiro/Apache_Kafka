package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatteryMessage {
    private String batteryNumber;
    private String stationName;
    private String countryCode;
    private String stationCode;
    private List<String> swapAgentDeviceTokens;
    private String epochTime;
}
