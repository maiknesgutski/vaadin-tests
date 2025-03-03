package com.example.application.components;

import com.example.application.data.entity.RadioButton;

public class TextAreaAndRadioButton	{
	private RadioButton radioButton;
	private String textAreaValue;

	public void setTextAreaValue(String textAreaValue) {
		this.textAreaValue = textAreaValue;
	}

	public String getTextAreaValue() {
		return textAreaValue;
	}

	public void setradioButton(RadioButton radioButton) {
		this.radioButton = radioButton;
	}

	public RadioButton getradioButton() {
		return radioButton;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || ((TextAreaAndRadioButton) o).radioButton == null || getClass() != o.getClass()) {
			return false;
		}

		TextAreaAndRadioButton that = (TextAreaAndRadioButton) o;

		if (this.radioButton.getValue() == that.radioButton.getValue() &&
			(that.textAreaValue != null && this.textAreaValue.equals(that.textAreaValue))) {
			return true;
		}

		return this.radioButton.getValue() == that.radioButton.getValue();
	}
}
