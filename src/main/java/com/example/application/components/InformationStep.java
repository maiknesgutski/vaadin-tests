package com.example.application.components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.application.data.entity.AddressField;
import com.example.application.data.entity.InformationForm;
import com.example.application.data.entity.PlaceValues;
import com.example.application.data.entity.RadioButton;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.theme.lumo.LumoIcon;

public class InformationStep extends StepComponent<InformationForm> {

	private final transient InformationForm versicherungsnehmerForm;
	private final Binder<InformationForm> versicherungsnehmerFormBinder = new Binder<>();

	public InformationStep(String label, InformationForm versicherungsnehmerForm) {
		super(label, versicherungsnehmerForm);
		this.versicherungsnehmerForm = versicherungsnehmerForm;
		VerticalLayout content = new VerticalLayout();

		if (this.versicherungsnehmerForm.getNewPlaceValueList() == null ||
			this.versicherungsnehmerForm.getNewPlaceValueList().isEmpty()) {
			this.versicherungsnehmerForm.setNewPlaceValueList(new ArrayList<>());
		}
		if (this.versicherungsnehmerForm.getRemovedPlaceLists() == null ||
			this.versicherungsnehmerForm.getRemovedPlaceLists().isEmpty()) {
			this.versicherungsnehmerForm.setRemovedPlacesList(new ArrayList<>());
		}
		content.add(this.getInfoBox());
		content.add(this.getPlacesAndDescription());
		content.add(this.getRemovedPlaces());

		this.versicherungsnehmerFormBinder.setBean(this.versicherungsnehmerForm);
		this.questionLayout.add(content);
	}

	private VerticalLayout getInfoBox() {
		VerticalLayout layout = new VerticalLayout();
		layout.add(new H1("Information Form"));
		layout.addClassName("info-box");
		layout.add(new Div("Dear Customer"
						   + ": "
						   + "Important Customer"));
		layout.add(new Div("Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit Sed Do Eiusmod Tempor Incididunt Ut"
						   + " Labore Et Dolore Magna Aliqua Ut Enim Ad Minim Veniam"));

		// Bitte geben Sie die gesamtzahl der Mitarbeiter an
		IntegerField employeeCount = new IntegerField();
		employeeCount.setLabel("Number of Employees");
		employeeCount.setWidth("100%");
		this.versicherungsnehmerFormBinder.forField(employeeCount)
				.bind(InformationForm::getNumberofEmployees, InformationForm::setNumberofEmployees);

		ShowTextAreaOnRadioButton neueUnternehmen = new ShowTextAreaOnRadioButton(
				"got a new place",
				"write the new place into this textArea");
		ShowTextAreaOnRadioButton geloeschteUnternehmen = new ShowTextAreaOnRadioButton(
				"removed a place",
				"write the removed place into this textArea");

		this.versicherungsnehmerFormBinder.forField(neueUnternehmen)
				.bind(InformationForm::getNewPlaceTextField, InformationForm::setNewPlaceTextField);

		this.versicherungsnehmerFormBinder.forField(geloeschteUnternehmen)
				.bind(InformationForm::getRemovedPlaceTextField, InformationForm::setRemovedPlaceTextField);

		this.pdfComponents.add(neueUnternehmen);
		this.pdfComponents.add(geloeschteUnternehmen);

		layout.add(employeeCount);
		layout.add(neueUnternehmen);
		layout.add(geloeschteUnternehmen);

		return layout;
	}

	private VerticalLayout getPlacesAndDescription() {
		VerticalLayout layout = new VerticalLayout();
		layout.add(new H1("Customer Description"));
		HorizontalLayout rowWithRadioButtons = new HorizontalLayout();
		RadioButtonComponent radioButtonComponent = new RadioButtonComponent(
				"Got new places?",
				true,
				new RadioButton(true, "yes"),
				new RadioButton(false, "no")
		);

		this.pdfComponents.add(radioButtonComponent);

		this.versicherungsnehmerFormBinder.forField(radioButtonComponent)
				.bind(InformationForm::getNewPlaceValueRadioButton, InformationForm::setNewPlaceValueRadioButton);
		VerticalLayout newRiskAddressCluster = new VerticalLayout();

		Button generateMoreRisikoorteButton = new Button();
		generateMoreRisikoorteButton.setVisible(false);
		generateMoreRisikoorteButton.getStyle().setAlignSelf(Style.AlignSelf.END);
		generateMoreRisikoorteButton.setIcon(LumoIcon.PLUS.create());
		generateMoreRisikoorteButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		generateMoreRisikoorteButton.setText("add");

		generateMoreRisikoorteButton.addClickListener(clickEvent -> {
			PlaceValueComponent risikoortComponent = new PlaceValueComponent();
			PlaceValues risikoortFunnyValuese = new PlaceValues();
			risikoortComponent.getBinder().setBean(risikoortFunnyValuese);
			this.versicherungsnehmerForm.getNewPlaceValueList().add(risikoortFunnyValuese);
			this.pdfComponents.add(risikoortComponent);
			Button deleteButton =
					this.getDeleteButton(risikoortComponent, this.versicherungsnehmerForm.getNewPlaceValueList(),
							risikoortFunnyValuese);
			newRiskAddressCluster.add(deleteButton);
			newRiskAddressCluster.add(risikoortComponent);
		});

		Paragraph moreParagraph = new Paragraph("have mor to register?");
		moreParagraph.setVisible(false);
		rowWithRadioButtons.add(radioButtonComponent, generateMoreRisikoorteButton);
		layout.add(rowWithRadioButtons);

		if (this.versicherungsnehmerForm.getNewPlaceValueList().isEmpty()) {
			PlaceValueComponent risikoortComponent = new PlaceValueComponent();
			PlaceValues risikoortFunnyValuese = new PlaceValues();
			risikoortComponent.getBinder().setBean(risikoortFunnyValuese);
			this.versicherungsnehmerForm.getNewPlaceValueList().add(risikoortFunnyValuese);
			this.pdfComponents.add(risikoortComponent);
			risikoortComponent.setVisible(false);
			newRiskAddressCluster.setVisible(false);
			newRiskAddressCluster.add(risikoortComponent);
		} else {
			AtomicInteger counter = new AtomicInteger();
			this.versicherungsnehmerForm.getNewPlaceValueList().forEach(risikoortFunnyValuese -> {
				PlaceValueComponent risikoortComponent = new PlaceValueComponent();
				if (risikoortFunnyValuese == null) {
					risikoortFunnyValuese = new PlaceValues();
				}

				// only show delete button when not first iteration of component
				if (counter.getAndIncrement() != 0) {
					Button deleteButton =
							this.getDeleteButton(risikoortComponent, this.versicherungsnehmerForm.getNewPlaceValueList(),
									risikoortFunnyValuese);
					newRiskAddressCluster.add(deleteButton);
				}
				risikoortComponent.getBinder().setBean(risikoortFunnyValuese);
				this.pdfComponents.add(risikoortComponent);
				risikoortComponent.setValue(risikoortFunnyValuese);
				newRiskAddressCluster.add(risikoortComponent);
				newRiskAddressCluster.setVisible(true);
			});
		}

		radioButtonComponent.addValueChangeListener(event -> {
			newRiskAddressCluster.setVisible(event.getValue().getValue());
			newRiskAddressCluster.getChildren().forEach(component -> component.setVisible(event.getValue().getValue()));
			generateMoreRisikoorteButton.setVisible(event.getValue().getValue());
			moreParagraph.setVisible(event.getValue().getValue());
		});

		layout.add(moreParagraph);
		layout.add(newRiskAddressCluster);
		return layout;
	}

	private VerticalLayout getRemovedPlaces() {
		VerticalLayout layout = new VerticalLayout();
		HorizontalLayout rowWithRadioButtons = new HorizontalLayout();
		RadioButtonComponent radioButtonComponent = new RadioButtonComponent(
				"removed some places?",
				true,
				new RadioButton(true, "yes"),
				new RadioButton(false, "no")
		);
		this.versicherungsnehmerFormBinder.forField(radioButtonComponent)
				.bind(InformationForm::getAufgegebeneRisikoOrtListRadioButton,
						InformationForm::setAufgegebeneRisikoOrtListRadioButton);
		this.pdfComponents.add(radioButtonComponent);

		Button generateMoreRisikoorteButton = new Button();
		generateMoreRisikoorteButton.setVisible(false);
		generateMoreRisikoorteButton.getStyle().setAlignSelf(Style.AlignSelf.END).setAlignSelf(Style.AlignSelf.FLEX_END);
		generateMoreRisikoorteButton.setIcon(LumoIcon.PLUS.create());
		generateMoreRisikoorteButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		generateMoreRisikoorteButton.setText("add");
		VerticalLayout deletedAddressCluster = new VerticalLayout();

		generateMoreRisikoorteButton.addClickListener(clickEvent -> {
			AddressComponent addressComponent = new AddressComponent();
			AddressField risikoortAdresse = new AddressField();
			addressComponent.getBinder().setBean(risikoortAdresse);
			this.versicherungsnehmerForm.getRemovedPlaceLists().add(risikoortAdresse);
			this.pdfComponents.add(addressComponent);
			Button deleteButton =
					this.getDeleteButton(addressComponent, this.versicherungsnehmerForm.getRemovedPlaceLists(), risikoortAdresse);
			deletedAddressCluster.add(deleteButton);
			deletedAddressCluster.add(addressComponent);
		});

		rowWithRadioButtons.add(radioButtonComponent, generateMoreRisikoorteButton);
		Paragraph moreParagraph = new Paragraph("removed more?");
		moreParagraph.setVisible(false);

		if (this.versicherungsnehmerForm.getRemovedPlaceLists().isEmpty()) {
			AddressField risikoortAdresse = new AddressField();
			AddressComponent addressComponent = new AddressComponent();
			addressComponent.getBinder().setBean(risikoortAdresse);
			this.pdfComponents.add(addressComponent);
			this.versicherungsnehmerForm.getRemovedPlaceLists().add(risikoortAdresse);
			addressComponent.setVisible(false);
			deletedAddressCluster.setVisible(false);
			deletedAddressCluster.add(addressComponent);
		} else {
			AtomicInteger counter = new AtomicInteger();
			this.versicherungsnehmerForm.getRemovedPlaceLists().forEach(risikoortAdresse -> {
				AddressComponent addressComponent = new AddressComponent();
				if (risikoortAdresse == null) {
					risikoortAdresse = new AddressField();
				}

				// only show delete button when not first iteration of component
				if (counter.getAndIncrement() != 0) {
					Button deleteButton =
							this.getDeleteButton(addressComponent, this.versicherungsnehmerForm.getRemovedPlaceLists(),
									risikoortAdresse);
					deletedAddressCluster.add(deleteButton);
				}
				addressComponent.getBinder().setBean(risikoortAdresse);
				this.pdfComponents.add(addressComponent);
				addressComponent.setValue(risikoortAdresse);
				deletedAddressCluster.add(addressComponent);
			});
		}

		radioButtonComponent.addValueChangeListener(event -> {
			deletedAddressCluster.setVisible(event.getValue().getValue());
			deletedAddressCluster.getChildren().forEach(component -> component.setVisible(event.getValue().getValue()));
			generateMoreRisikoorteButton.setVisible(event.getValue().getValue());
			moreParagraph.setVisible(event.getValue().getValue());
		});

		layout.add(rowWithRadioButtons);
		layout.add(deletedAddressCluster);
		return layout;
	}


	private Button getDeleteButton(Component component, List list, Object objectToRemove) {
		Button deleteButton = new Button();
		deleteButton.setText("remove");
		deleteButton.setIcon(LumoIcon.MINUS.create());
		deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
		deleteButton.addClickListener(event -> {
			component.removeFromParent();
			list.remove(objectToRemove);
			this.pdfComponents.remove(component);
			deleteButton.removeFromParent();
		});

		return deleteButton;
	}
}
