package com.example.application.components;

import com.example.application.data.entity.RadioButton;
import com.example.application.data.entity.TextAreaAndRadioButton;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.Binder;

public class ShowTextAreaOnRadioButton extends CustomField<TextAreaAndRadioButton> {

	private final Binder<TextAreaAndRadioButton> binder =
			new Binder<>(TextAreaAndRadioButton.class);

	private TextAreaAndRadioButton textAreaAndRadioButton = new TextAreaAndRadioButton();

	private String componentText;
	private String textAreaLabel;

	public ShowTextAreaOnRadioButton(String componentText, String textAreaLabel) {
		VerticalLayout layout = new VerticalLayout();
		this.componentText = componentText;
		this.textAreaLabel = textAreaLabel;
		layout.add(new Div(this.componentText));

		RadioButtonComponent radioButtonGroup = new RadioButtonComponent("",
				new RadioButton(true, "yes"),
				new RadioButton(false, "no"));

		this.binder.forField(radioButtonGroup)
				.asRequired("required")
				.bind(TextAreaAndRadioButton::getradioButton, TextAreaAndRadioButton::setradioButton);

		TextArea textArea = new TextArea(this.textAreaLabel);

		this.binder.forField(textArea)
				.bind(TextAreaAndRadioButton::getTextAreaValue, TextAreaAndRadioButton::setTextAreaValue);

		textArea.setVisible(false);
		textArea.setWidth("100%");
		textArea.setHeight("150px");

		radioButtonGroup.addValueChangeListener(event -> textArea.setVisible(event.getValue().getValue()));

		if (radioButtonGroup.getValue() != null) {
			textArea.setVisible(radioButtonGroup.getValue().getValue());
		}

		layout.add(radioButtonGroup);
		layout.add(textArea);
		layout.setWidth("100%");

		this.binder.setBean(this.textAreaAndRadioButton);
		this.add(layout);
	}

	@Override
	protected TextAreaAndRadioButton generateModelValue() {
		return this.textAreaAndRadioButton;
	}

	@Override
	protected void setPresentationValue(TextAreaAndRadioButton newPresentationValue) {
		if (newPresentationValue != null) {
			this.textAreaAndRadioButton = newPresentationValue;
			binder.setBean(newPresentationValue);
		}
	}
}
