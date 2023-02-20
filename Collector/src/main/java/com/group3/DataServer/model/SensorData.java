package com.group3.DataServer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SensorData {

    @Id
    private String id;
    private String date_time;
    private String name;
    private float value;
    private String unit;

}
