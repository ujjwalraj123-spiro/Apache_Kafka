package org.example.dto;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "bms_country_mapping")
public class BmsEntity {

    @Column(name = "country")
    private String country;

    @Id
    @Column(name = "bms_id")
    private String bmsId;

    @Column(name = "status")
    private String status;

    @Column(name = "last_updated_time")
    private Timestamp lastUpdatedTime;

    @Column(name = "battery_software_version")
    private String batterySoftwareVersion;

    @Column(name = "current")
    private Long current;

    @Column(name = "cycle_count")
    private Long cycleCount;

    @Column(name = "inside_bike")
    private Boolean insideBike;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "soc")
    private Long soc;

    @Column(name = "soh")
    private Long soh;

    @Column(name = "temperature_cell1")
    private Long temperatureCell1;

    @Column(name = "temperature_cell2")
    private Long temperatureCell2;

    @Column(name = "voltage")
    private Long voltage;

    @Column(name = "chem_id")
    private String chemId;

    @Column(name = "full_charge_capacity")
    private Long fullChargeCapacity;

    @Column(name = "manufacture_date")
    private String manufactureDate;

    @Column(name = "manufacture_name")
    private String manufactureName;

    @Column(name = "battery_name")
    private String batteryName;

    @Column(name = "rated_capacity")
    private Long ratedCapacity;

    @Column(name = "rated_voltage")
    private Long ratedVoltage;

    @Column(name = "remaining_capacity")
    private Long remainingCapacity;

    @Column(name = "temperature_cell3")
    private Long temperatureCell3;

    @Column(name = "temperature_charge_mos")
    private Long temperatureChargeMos;

    @Column(name = "temperature_discharge_mos")
    private Long temperatureDischargeMos;

    @Column(name = "temperature_pcb")
    private Long temperaturePcb;

    @Column(name = "temperature_pre_charge")
    private Long temperaturePreCharge;

    @Column(name = "temperature_pre_start")
    private Long temperaturePreStart;

    @Column(name = "bms_bar_code")
    private String bmsBarCode;

    @Column(name = "device_time")
    private Long deviceTime;

    @Column(name = "dtu_version")
    private String dtuVersion;

    @Column(name = "gnss_satellite_used_count")
    private Long gnssSatelliteUsedCount;

    @Column(name = "gprs_apn")
    private String gprsApn;

    @Column(name = "gprs_total_data_used")
    private Long gprsTotalDataUsed;

    @Column(name = "gps_status")
    private Integer gpsStatus;

    @Column(name = "gsm_signal_strength")
    private Long gsmSignalStrength;

    @Column(name = "history_max_cell_voltage")
    private Long historyMaxCellVoltage;

    @Column(name = "history_max_charge_current")
    private Long historyMaxChargeCurrent;

    @Column(name = "history_max_discharge_current")
    private Long historyMaxDischargeCurrent;

    @Column(name = "history_max_temperature")
    private Long historyMaxTemperature;

    @Column(name = "history_min_cell_voltage")
    private Long historyMinCellVoltage;

    @Column(name = "history_min_temperature")
    private Long historyMinTemperature;

    @Column(name = "iccid_no")
    private String iccidNo;

    @Column(name = "imei")
    private Long imei;

    @Column(name = "iot_temperature")
    private Long iotTemperature;

    @Column(name = "location_speed")
    private Long locationSpeed;

    @Column(name = "status_charge_mosfet_status")
    private Long statusChargeMosfetStatus;

    @Column(name = "status_charger_connection_status")
    private Long statusChargerConnectionStatus;

    @Column(name = "status_charger_identify_status")
    private Long statusChargerIdentifyStatus;

    @Column(name = "status_cycle_count")
    private Long statusCycleCount;

    @Column(name = "status_discharge_mosfet_status")
    private Long statusDischargeMosfetStatus;

    @Column(name = "status_highest_cell_temperature")
    private Long statusHighestCellTemperature;

    @Column(name = "status_lowest_cell_temperature")
    private Long statusLowestCellTemperature;

    @Column(name = "status_mosfet_temperature")
    private Long statusMosfetTemperature;

    @Column(name = "status_pack_voltage")
    private Long statusPackVoltage;

    @Column(name = "status_pre_charge_circuit_status")
    private Long statusPreChargeCircuitStatus;

    @Column(name = "status_pre_discharge_circuit_status")
    private Long statusPreDischargeCircuitStatus;

    @Column(name = "status_pre_start_temperature")
    private Long statusPreStartTemperature;

    @Column(name = "status_real_light_status")
    private Long statusRealLightStatus;

    @Column(name = "status_realtime_current")
    private Long statusRealtimeCurrent;

    @Column(name = "status_soc")
    private Long statusSoc;

    @Column(name = "status_soh")
    private Long statusSoh;

    @Column(name = "status_usb_power_status")
    private Long statusUsbPowerStatus;

    @Column(name = "cell_voltage_list0")
    private List<Long> cellVoltageList0;

    @Column(name = "cell_voltage_list1")
    private List<Long> cellVoltageList1;

    @Column(name = "over_charge_error")
    private Long overChargeError;

    @Column(name = "primary_over_discharge_error")
    private Long primaryOverDischargeError;

    @Column(name = "secondary_over_discharge_error")
    private Long secondaryOverDischargeError;

    @Column(name = "pre_start_fail")
    private Long preStartFail;

    @Column(name = "over_charge_temperature_error")
    private Long overChargeTemperatureError;

    @Column(name = "type")
    private Long type;

    @Column(name = "deployment_status")
    private String deploymentStatus;

    @Column(name = "deployment_date")
    private String deploymentDate;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "comments")
    private String comments;

    @Column(name = "msisdn")
    private Long msisdn;

    @Column(name = "aeris_device_id")
    private Long aerisDeviceId;

    @Column(name = "server_api_port")
    private Integer serverApiPort;

    @Column(name = "working_status")
    private String workingStatus;

}

