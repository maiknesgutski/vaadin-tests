package com.example.application.components;

import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class FormComponent extends Composite<VerticalLayout> {
	private final List<StepComponent> stepComponents;

	public FormComponent(List<StepComponent> stepComponents, String currentPage) {
		this.stepComponents = stepComponents;

		HorizontalLayout layoutRow = new HorizontalLayout();
		layoutRow.setHeight("100%");
		VerticalLayout navButtonLayout = new VerticalLayout();
		navButtonLayout.addClassName(LumoUtility.Border.RIGHT);
		navButtonLayout.setWidth("25%");
		navButtonLayout.setPadding(false);
		navButtonLayout.addClassName(LumoUtility.Padding.Right.MEDIUM);
		navButtonLayout.addClassName(LumoUtility.Padding.Top.LARGE);
		navButtonLayout.setSpacing(false);

		// originally this gets filtered
		this.stepComponents.stream()
				.forEach(stepComponent -> stepComponent.showQuestions(true));

		layoutRow.add(navButtonLayout);
		this.stepComponents.forEach(stepComponent -> {
			navButtonLayout.add(stepComponent);
			layoutRow.add(stepComponent.getQuestionLayout());
			stepComponent.addClickListener(event -> {
				stepComponents.forEach(s -> s.showQuestions(false));
				stepComponent.showQuestions(true);
			});
		});

		layoutRow.addClassName(LumoUtility.Gap.MEDIUM);
		layoutRow.setWidth("100%");

		getContent().add(layoutRow);
	}

	/**
	 * Function to get the currently active step component.
	 * Should always be only one.
	 *
	 * @return The currently active StepComponent.
	 */
	public StepComponent getCurrentStep() {
		return stepComponents.stream().filter(StepComponent::isActive).findFirst().orElse(null);
	}
}
