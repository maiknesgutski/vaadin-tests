package com.example.application.components;

import com.example.application.data.entity.RadioButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class RadioButtonComponent extends RadioButtonGroup<RadioButton> {

	private Boolean toFoSeperatly = false;

	public RadioButtonComponent() {
		super();
		this.setRenderer(new ComponentRenderer<>(this::render));
	}

	public RadioButtonComponent(String label, RadioButton... items) {
		super(label, items);
		this.setRenderer(new ComponentRenderer<>(this::render));
	}

	public RadioButtonComponent(String label, Boolean toFoSeperatly, RadioButton... items) {
		super(label, items);
		this.toFoSeperatly = toFoSeperatly;
		this.setRenderer(new ComponentRenderer<>(this::render));
	}

	public Component render(final RadioButton booleanLabelRadioButton) {
		HorizontalLayout answer = new HorizontalLayout();
		Span text = new Span(booleanLabelRadioButton.getLabel());
		answer.add(text);
		return answer;
	}
}
