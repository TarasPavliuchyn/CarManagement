package com.carmanagement.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SpeedConverter implements AttributeConverter<Double, Double> {
	private final static double K = 1.6093;

	@Override
	public Double convertToDatabaseColumn(Double speedKM) {
		return speedKM / K;
	}

	@Override
	public Double convertToEntityAttribute(Double speedMi) {
		return speedMi * K;
	}

}
