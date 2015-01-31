package com.carmanagement.car;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Engine {
	@Column(name = "engine_model")
	private String model;
	private Integer volume;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Engine(String model, Integer volume) {
		super();
		this.model = model;
		this.volume = volume;
	}

	public Engine() {
		super();
	}

	@Override
	public String toString() {
		return "Engine [model=" + model + ", volume=" + volume + "]";
	}

}
