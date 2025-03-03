package com.example.application.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.application.components.FormComponent;
import com.example.application.components.InformationStep;
import com.example.application.components.StepComponent;
import com.example.application.data.entity.InformationForm;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route(value = "", layout = MainLayout.class)
public class ChangeNotification extends Composite<VerticalLayout> implements HasDynamicTitle, BeforeEnterObserver {

	private final Button backButton;
	private final Button forwardButton;
	private final Anchor downloadLink = new Anchor();
	private final Button saveButton;
	private final Button sendButton;
	private FormComponent industryForm;
	protected String version;
	protected String page;


	private List<StepComponent> stepComponents;

	public ChangeNotification() {
		super();
		this.backButton = new Button("back");
		this.forwardButton = new Button("continue");
		this.saveButton = new Button("save");
		this.sendButton = new Button("send");
		this.sendButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		this.backButton.addClickListener(clickEvent -> goBack());
		this.forwardButton.addClickListener(clickEvent -> goForward());
		this.saveButton.addClickListener(clickEvent -> save());
		this.sendButton.addClickListener(clickEvent -> saveAndSend());


		InformationStep customerStep =
				new InformationStep("places and values",
						new InformationForm());


		this.stepComponents = new ArrayList<>(Arrays.asList(customerStep));


		this.industryForm = new FormComponent(this.stepComponents, this.page);
		this.industryForm.getContent().setHeight("90%");
		VerticalLayout content = new VerticalLayout();
		content.setPadding(false);
		content.setSpacing(false);
		content.setHeightFull();
		content.add(this.industryForm);
		final HorizontalLayout footer = this.getFooter();
		content.add(footer);

		getContent().add(content);
		getContent().setWidthFull();
		getContent().getStyle().set("flex-grow", "1");
	}

	@Override
	public String getPageTitle() {
		return "mega changes";
	}

	public HorizontalLayout getFooter() {
		downloadLink.getElement().setAttribute("download", true);
		downloadLink.setVisible(false);

		HorizontalLayout footerRow = new HorizontalLayout();
		footerRow.setAlignItems(FlexComponent.Alignment.CENTER);
		footerRow.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		footerRow.addClassName(LumoUtility.Gap.MEDIUM);
		footerRow.addClassName(LumoUtility.Border.TOP);
		footerRow.setWidth("100%");
		footerRow.setPadding(true);
		footerRow.add(this.backButton);
		footerRow.add(this.forwardButton);
		footerRow.add(this.saveButton);
		footerRow.add(this.sendButton);
		return footerRow;
	}

	public void saveAndSend() {
		save();

		// send the formular message to camunda with the variable formularAttachmentId
		Dialog dialog = new Dialog();
		dialog.add(new Paragraph("Ihre Eingaben wurden gesendet"));
		dialog.setModal(true);
		dialog.setWidth(50, Unit.PERCENTAGE);
		dialog.setHeight(50, Unit.PERCENTAGE);
		dialog.setCloseOnEsc(false);
		dialog.setCloseOnOutsideClick(false);
		dialog.open();
	}

	public void save() {
		var currentStep = industryForm.getCurrentStep();
		var currentStepValue = currentStep.getValue();
		// to save a form we get the values lying in the step and send them to our
		// backend service where its getting saved through the repository
	}

	public void goForward() {
	}

	public void goBack() {
	}
}
