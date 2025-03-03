package com.example.application.data.entity;

import java.util.Objects;

public class AddressField {
	String streetAndNumber;
	String postalCode;
	String city;
	String country;

	public AddressField(String streetAndNumber, String postalCode, String city, String country) {
		this.streetAndNumber = streetAndNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public AddressField() {
	}

	public String getStreetAndNumber() {
		return streetAndNumber;
	}

	public void setStreetAndNumber(String streetAndNumber) {
		this.streetAndNumber = streetAndNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AddressField that = (AddressField) o;
		return Objects.equals(getStreetAndNumber(), that.getStreetAndNumber()) &&
			   Objects.equals(getPostalCode(), that.getPostalCode()) && Objects.equals(getCity(), that.getCity()) &&
			   Objects.equals(getCountry(), that.getCountry());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStreetAndNumber(), getPostalCode(), getCity(), getCountry());
	}

	@Override
	public String toString() {
		return "AddressField{" +
			   "streetAndNumber='" + streetAndNumber + '\'' +
			   ", postalCode='" + postalCode + '\'' +
			   ", city='" + city + '\'' +
			   ", country='" + country + '\'' +
			   '}';
	}
}
