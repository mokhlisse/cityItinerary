package com.badre.cityitinerary.cityservice.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModelProperty;

/**
 * a route entity, represents a connection between two cities
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@ApiModelProperty(notes = "city id", required = true)
	private Integer id;

	@Column(name = "city", nullable = false)
	@ApiModelProperty(notes = "city source name", required = true)
	private String city;

	@Column(name = "destiny", nullable = false)
	@ApiModelProperty(notes = "city destination name", required = true)
	private String destiny;

	@Column(name = "departure_time", nullable = false)
	@ApiModelProperty(notes = "departure time", required = true)
	private Time departureTime;

	@Column(name = "duration", nullable = false)
	@ApiModelProperty(notes = "travel duration in minutes", required = true)
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
}
