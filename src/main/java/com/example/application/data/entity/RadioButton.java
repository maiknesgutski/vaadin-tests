package com.example.application.data.entity;

import java.util.Objects;

public class RadioButton {
	private String label;
	private Boolean value;

	public RadioButton(boolean value, String label) {
		this.value = value;
		this.label = label;
	}

	public RadioButton() {
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (this.value == ((RadioButton) o).value) {
			return true;
		}
		RadioButton that = (RadioButton) o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(label, value);
	}
}
