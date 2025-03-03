package com.example.application.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class PlaceValues {
	private LocalDate dateOfAcquisition;
	private BigDecimal funnyValuesApples;
	private BigDecimal funnyValuesFurniture;
	private BigDecimal funnyValuesPears;
	private BigDecimal funnyValuesTablets;
	private BigDecimal funnyValuesCars;
	private TextFieldAndRadioButton changesToMode;
	private String description;
	private AddressField addressField;

	public PlaceValues() {
	}

	public LocalDate getDateOfAcquisition() {
		return dateOfAcquisition;
	}

	public void setDateOfAcquisition(LocalDate dateOfAcquisition) {
		this.dateOfAcquisition = dateOfAcquisition;
	}

	public BigDecimal getFunnyValuesApples() {
		return funnyValuesApples;
	}

	public void setFunnyValuesApples(BigDecimal funnyValuesApples) {
		this.funnyValuesApples = funnyValuesApples;
	}

	public BigDecimal getFunnyValuesFurniture() {
		return funnyValuesFurniture;
	}

	public void setFunnyValuesFurniture(BigDecimal funnyValuesFurniture) {
		this.funnyValuesFurniture = funnyValuesFurniture;
	}

	public BigDecimal getFunnyValuesPears() {
		return funnyValuesPears;
	}

	public void setFunnyValuesPears(BigDecimal funnyValuesPears) {
		this.funnyValuesPears = funnyValuesPears;
	}

	public BigDecimal getFunnyValuesTablets() {
		return funnyValuesTablets;
	}

	public void setFunnyValuesTablets(BigDecimal funnyValuesTablets) {
		this.funnyValuesTablets = funnyValuesTablets;
	}

	public BigDecimal getFunnyValuesCars() {
		return funnyValuesCars;
	}

	public void setFunnyValuesCars(BigDecimal funnyValuesCars) {
		this.funnyValuesCars = funnyValuesCars;
	}

	public TextFieldAndRadioButton getChangesToMode() {
		return changesToMode;
	}

	public void setChangesToMode(TextFieldAndRadioButton changesToMode) {
		this.changesToMode = changesToMode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressField getAddressField() {
		return addressField;
	}

	public void setAddressField(AddressField addressField) {
		this.addressField = addressField;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		PlaceValues that = (PlaceValues) o;
		return Objects.equals(getDescription(), that.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getDescription());
	}

	@Override
	public String toString() {
		return "NeuerRisikoort{" +
			   "description='" + description + '\'' +
			   ", streetAndNumber='" + addressField.getStreetAndNumber() + '\'' +
			   ", postalCode='" + addressField.getPostalCode() + '\'' +
			   ", city='" + addressField.getCity() + '\'' +
			   ", country='" + addressField.getCountry() + '\'' +
			   ", dateOfAcquisition='" + dateOfAcquisition.toString() + '\'' +
			   ", funnyValuesFurniture='" + funnyValuesFurniture.toString() + '\'' +
			   ", funnyValuesTablets='" + funnyValuesTablets.toString() + '\'' +
			   ", funnyValuesApples='" + funnyValuesApples + '\'' +
			   ", funnyValuesCars='" + funnyValuesCars + '\'' +
			   ", funnyValuesPears='" + funnyValuesPears + '\'' +
			   '}';
	}
}
