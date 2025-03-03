package com.example.application.data.entity;

public class TextFieldAndRadioButton {
	private RadioButton radioButton;
	private String textFieldValue;

	public void setTextFieldValue(String textFieldValue) {
		this.textFieldValue = textFieldValue;
	}

	public String getTextFieldValue() {
		return textFieldValue;
	}

	public void setradioButton(RadioButton radioButton) {
		this.radioButton = radioButton;
	}

	public RadioButton getradioButton() {
		return radioButton;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || ((TextFieldAndRadioButton) o).radioButton == null || getClass() != o.getClass()) {
			return false;
		}

		TextFieldAndRadioButton that = (TextFieldAndRadioButton) o;

		if (this.radioButton.getValue() == that.radioButton.getValue() &&
			(that.textFieldValue != null && this.textFieldValue.equals(that.textFieldValue))) {
			return true;
		}

		return this.radioButton.getValue() == that.radioButton.getValue();
	}
}

