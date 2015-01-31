package com.carmanagement.car;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("E")
@PrimaryKeyJoinColumn(name = "ELECTRIC_ID")
public class ElectricCar extends Car {

	private Integer voltage;

	public Integer getVoltage() {
		return voltage;
	}

	public void setVoltage(Integer voltage) {
		this.voltage = voltage;
	}

	public ElectricCar(String model, Integer power, CarType carType,
			Double maxSpeed, Integer voltage) {
		super(model, power, carType, maxSpeed);
		this.voltage = voltage;
	}

	public ElectricCar() {
		super();
	}

	@Override
	public String toString() {
		return "ElectricCar [voltage=" + voltage + "]";
	}
}
