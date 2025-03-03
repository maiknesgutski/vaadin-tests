package com.example.application.data.entity;

import java.util.List;

/**
 * Entity to bind for the informationStep.
 */
public class InformationForm {

	private List<PlaceValues> newPlaceValuesList;
	private RadioButton newPlaceValueRadioButton;
	private List<AddressField> removedPlacesList;
	private RadioButton removedPlacesRadioButton;
	private TextAreaAndRadioButton newPlaceTextField;
	private TextAreaAndRadioButton removedPlaceTextField;
	private Integer numberofEmployees;

	public InformationForm() {

	}

	public List<PlaceValues> getNewPlaceValueList() {
		return newPlaceValuesList;
	}

	public void setNewPlaceValueList(List<PlaceValues> risikoortFunnyValueseList) {
		this.newPlaceValuesList = risikoortFunnyValueseList;
	}

	public List<AddressField> getRemovedPlaceLists() {
		return removedPlacesList;
	}

	public void setRemovedPlacesList(
			List<AddressField> removedPlacesList) {
		this.removedPlacesList = removedPlacesList;
	}

	public TextAreaAndRadioButton getNewPlaceTextField() {
		return newPlaceTextField;
	}

	public void setNewPlaceTextField(TextAreaAndRadioButton newPlaceTextField) {
		this.newPlaceTextField = newPlaceTextField;
	}

	public TextAreaAndRadioButton getRemovedPlaceTextField() {
		return removedPlaceTextField;
	}

	public void setRemovedPlaceTextField(TextAreaAndRadioButton removedPlaceTextField) {
		this.removedPlaceTextField = removedPlaceTextField;
	}

	public Integer getNumberofEmployees() {
		return numberofEmployees;
	}

	public void setNumberofEmployees(Integer numberofEmployees) {
		this.numberofEmployees = numberofEmployees;
	}

	public RadioButton getNewPlaceValueRadioButton() {
		return newPlaceValueRadioButton;
	}

	public void setNewPlaceValueRadioButton(RadioButton newPlaceValueRadioButton) {
		this.newPlaceValueRadioButton = newPlaceValueRadioButton;
	}

	public RadioButton getAufgegebeneRisikoOrtListRadioButton() {
		return removedPlacesRadioButton;
	}

	public void setAufgegebeneRisikoOrtListRadioButton(
			RadioButton aufgegebeneRisikoOrtListRadioButton) {
		this.removedPlacesRadioButton = aufgegebeneRisikoOrtListRadioButton;
	}
}

