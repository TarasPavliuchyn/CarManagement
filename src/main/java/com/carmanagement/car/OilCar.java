package com.carmanagement.car;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("O")
@PrimaryKeyJoinColumn(name = "OIL_ID")
public class OilCar extends Car {
	
	@Column(name = "tankVolume")
	private Integer volume;

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "OilCar [volume=" + volume + "]";
	}

	public OilCar() {
		super();
	}

	public OilCar(String model, Integer power, CarType carType, Double maxSpeed, Integer volume) {
		super(model, power, carType, maxSpeed);
		this.volume = volume;
	}
}
