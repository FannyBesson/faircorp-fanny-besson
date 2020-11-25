package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;
    private List<HeaterDto> heaters;
    private List<WindowDto> windows;

    public RoomDto() {
    }

    public RoomDto(Room room){
        this.id= room.getId();
        this.name= room.getName();
        this.floor= room.getFloor();
        this.currentTemperature=room.getCurrentTemperature();
        this.targetTemperature= room.getTargetTemperature();
        this.heaters=room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toList());;
        this.windows=room.getWindows().stream().map(WindowDto::new).collect(Collectors.toList());;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public List<HeaterDto> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<HeaterDto> heaters) {
        this.heaters = heaters;
    }

    public List<WindowDto> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowDto> windows) {
        this.windows = windows;
    }
}
