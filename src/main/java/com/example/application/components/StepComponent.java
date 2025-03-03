package com.example.application.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;

public class StepComponent<T> extends CustomField<T> {

	protected final VerticalLayout questionLayout = new VerticalLayout();
	protected final List<Component> pdfComponents = new ArrayList<>();
	protected T value;
	protected Binder<T> binder = new Binder<>();
	private final Button button = new Button();
	private boolean visible;
	private String label;


	public StepComponent(String label, T value) {
		super();
		this.setWidthFull();
		this.value = value;
		this.label = label;
		this.button.setText(this.label);
		this.button.setWidth("100%");
		add(button);
		this.questionLayout.getStyle().set("overflow", "auto");
		this.questionLayout.setVisible(false);
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		this.binder.setReadOnly(readOnly);
	}

	public VerticalLayout getQuestionLayout() {
		return questionLayout;
	}

	public void showQuestions(boolean show) {
		this.visible = show;
		this.questionLayout.setVisible(show);
	}

	public boolean isActive() {
		return this.visible;
	}

	protected void addQuestionComponent(Component component) {
		this.questionLayout.add(component);
	}

	@Override
	protected T generateModelValue() {
		return value;
	}

	@Override
	protected void setPresentationValue(T newPresentationValue) {
		this.value = newPresentationValue;
	}

	public void addClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
		this.button.addClickListener(listener);
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}
}
