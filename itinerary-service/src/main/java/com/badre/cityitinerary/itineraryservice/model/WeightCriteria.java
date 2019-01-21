package com.badre.cityitinerary.itineraryservice.model;

import java.util.Arrays;

/**
 * weight criteria enumeration
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public enum WeightCriteria {

	TIME("time"), CONNECTIONS("connections");

	private String value;

	private WeightCriteria(String value) {
		this.value = value;
	}

	public static WeightCriteria fromValue(String value) {
		for (WeightCriteria criteria : values()) {
			if (criteria.value.equalsIgnoreCase(value)) {
				return criteria;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
