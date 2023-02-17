package com.group3.DataServer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private String id;
    private String date_time;
    private String name;
    private float value;
    private String unit;
}
