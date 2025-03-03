package com.example.application.components;

import com.example.application.data.entity.RadioButton;
import com.example.application.data.entity.TextFieldAndRadioButton;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class ShowTextFieldOnRadioButton extends CustomField<TextFieldAndRadioButton> {
	private final Binder<TextFieldAndRadioButton> binder =
			new Binder<>(TextFieldAndRadioButton.class);

	private TextFieldAndRadioButton textFieldAndRadioButton = new TextFieldAndRadioButton();
	private final String componentText;
	private final String textAreaLabel;

	public ShowTextFieldOnRadioButton(String componentText, String textAreaLabel) {
		this.componentText = componentText;
		this.textAreaLabel = textAreaLabel;
		VerticalLayout layout = new VerticalLayout();
		layout.add(new Div(this.componentText));

		RadioButtonComponent radioButtonGroup = new RadioButtonComponent("",
				new RadioButton(true, "yes"),
				new RadioButton(false, "no"));

		this.binder.forField(radioButtonGroup)
				.asRequired("required")
				.bind(TextFieldAndRadioButton::getradioButton, TextFieldAndRadioButton::setradioButton);

		TextField textField = new TextField(this.textAreaLabel);

		this.binder.forField(textField)
				.bind(TextFieldAndRadioButton::getTextFieldValue, TextFieldAndRadioButton::setTextFieldValue);

		textField.setVisible(false);
		textField.setWidth("100%");
		textField.setHeight("150px");

		radioButtonGroup.addValueChangeListener(event -> textField.setVisible(event.getValue().getValue()));

		if (radioButtonGroup.getValue() != null) {
			textField.setVisible(radioButtonGroup.getValue().getValue());
			if (Boolean.TRUE.equals(radioButtonGroup.getValue().getValue())) {
				this.binder.forField(textField).asRequired("required");
			}
		}

		layout.add(radioButtonGroup);
		layout.add(textField);
		layout.setWidth("100%");

		this.binder.setBean(this.textFieldAndRadioButton);
		this.add(layout);
	}

	@Override
	protected TextFieldAndRadioButton generateModelValue() {
		return this.textFieldAndRadioButton;
	}

	@Override
	protected void setPresentationValue(TextFieldAndRadioButton newPresentationValue) {
		if (newPresentationValue != null) {
			this.textFieldAndRadioButton = newPresentationValue;
			binder.setBean(newPresentationValue);
		}
	}
}
