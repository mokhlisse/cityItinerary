package com.badre.cityitinerary.itineraryservice.model;

import java.sql.Time;

/**
 * represents a route between 2 adjacent cities
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class Route {

	private Integer id;
	private String city;
	private String destiny;
	private Time departureTime;
	private Integer duration;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", city=" + city + ", destiny=" + destiny + ", departureTime="
				+ departureTime + ", duration=" + duration + "]";
	}
}
