package com.carmanagement.car;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.carmanagement.common.SpeedConverter;

@Entity
@Table(name = "CARS")
@SecondaryTable(name = "CARS_PHOTO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CAR_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("C")
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	@Basic(optional = false)
	private String model;
	@Column(name = "car_power", length = 5)
	private Integer power;
	@Embedded
	private Engine engine;
	@Enumerated(EnumType.STRING)
	private CarType carType;
	@Convert(converter = SpeedConverter.class)
	private Double maxSpeed;
	@Version
	private Integer version;
	@Transient
	private String temp;
	@Lob
	@Column(table = "CARS_PHOTO")
	private byte[] carPhoto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public byte[] getCarPhoto() {
		return carPhoto;
	}

	public void setCarPhoto(byte[] carPhoto) {
		this.carPhoto = carPhoto;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car() {
		super();
	}

	public Car(String model, Integer power, CarType carType, Double maxSpeed) {
		super();
		this.model = model;
		this.power = power;
		this.carType = carType;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", power=" + power
				+ ", engine=" + engine + ", carType=" + carType + ", maxSpeed="
				+ maxSpeed + ", version=" + version + ", temp=" + temp
				+ ", carPhoto=" + Arrays.toString(carPhoto) + "]";
	}

}
