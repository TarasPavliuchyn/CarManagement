package com.carmanagement.car;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("H")
@PrimaryKeyJoinColumn(name = "HYBRID_ID")
public class HybridCar extends Car {

	private Integer voltage;
	@Column(name = "tankVolume")
	private Integer volume;

	public HybridCar(Integer voltage, Integer volume) {
		super();
		this.voltage = voltage;
		this.volume = volume;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getVoltage() {
		return voltage;
	}

	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}

	public HybridCar(String model, Integer power, CarType carType,
			Double maxSpeed, Integer voltage) {
		super(model, power, carType, maxSpeed);
		this.voltage = voltage;
	}

	public HybridCar() {
		super();
	}

	@Override
	public String toString() {
		return "HybridCar [voltage=" + voltage + ", volume=" + volume + "]";
	}

}
