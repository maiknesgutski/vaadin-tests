package com.example.application.components;

import com.example.application.data.entity.PlaceValues;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class PlaceValueComponent extends CustomField<PlaceValues> {
	private final Binder<PlaceValues> binder =
			new Binder<>(PlaceValues.class);

	private PlaceValues placeFunnyValues = new PlaceValues();
	private AddressComponent addressComponent = new AddressComponent();


	public PlaceValueComponent() {
		VerticalLayout layout = new VerticalLayout();

		layout.add(this.buildRow1());
		layout.add(this.buildRow2());
		layout.add(this.buildRow3());
		layout.add(this.buildRow4());
		layout.add(this.buildRow5());
		layout.add(this.getModeChange());
		this.binder.setBean(this.placeFunnyValues);
		this.add(layout);
	}

	private HorizontalLayout buildRow1() {
		HorizontalLayout row = new HorizontalLayout();
		row.setWidth("100%");
		TextField descriptionField = new TextField();
		descriptionField.setLabel("description");
		descriptionField.setWidth("50%");
		this.binder.forField(descriptionField)
				.bind(PlaceValues::getDescription, PlaceValues::setDescription);
		row.add(descriptionField);

		DatePicker acquisitionDate = new DatePicker();
		acquisitionDate.setLabel("date of acquisition");
		acquisitionDate.setWidth("50%");
		this.binder.forField(acquisitionDate)
				.bind(PlaceValues::getDateOfAcquisition, PlaceValues::setDateOfAcquisition);
		row.add(acquisitionDate);

		return row;
	}

	/**
	 * Builds the second row of the RisikoortComponent.
	 * This row contains the address fields.
	 *
	 * @return The second row of the RisikoortComponent.
	 */
	private AddressComponent buildRow2() {
		this.binder.forField(addressComponent)
				.bind(PlaceValues::getAddressField, PlaceValues::setAddressField);

		return addressComponent;
	}

	private HorizontalLayout buildRow3() {
		HorizontalLayout row = new HorizontalLayout();
		row.setWidth("100%");
		BigDecimalFieldWithEuroSuffix funnyValueApples = new BigDecimalFieldWithEuroSuffix();
		funnyValueApples.setLabel(
				"building value"
		);
		funnyValueApples.setWidth("50%");
		this.binder.forField(funnyValueApples)
				.bind(PlaceValues::getFunnyValuesApples, PlaceValues::setFunnyValuesApples);
		row.add(funnyValueApples);

		BigDecimalFieldWithEuroSuffix funnyValueFurniture = new BigDecimalFieldWithEuroSuffix();
		funnyValueFurniture.setLabel(
				"furniture value"
		);
		funnyValueFurniture.setWidth("50%");
		this.binder.forField(funnyValueFurniture)
				.bind(PlaceValues::getFunnyValuesFurniture,
						PlaceValues::setFunnyValuesFurniture);
		row.add(funnyValueFurniture);

		return row;
	}

	private HorizontalLayout buildRow4() {
		HorizontalLayout row = new HorizontalLayout();
		row.setWidth("100%");
		BigDecimalFieldWithEuroSuffix funnyValuePears = new BigDecimalFieldWithEuroSuffix();
		funnyValuePears.setLabel(
				"pear value"
		);
		funnyValuePears.setWidth("50%");
		this.binder.forField(funnyValuePears)
				.bind(PlaceValues::getFunnyValuesPears, PlaceValues::setFunnyValuesPears);
		row.add(funnyValuePears);

		BigDecimalFieldWithEuroSuffix funnyValueTablets = new BigDecimalFieldWithEuroSuffix();
		funnyValueTablets.setLabel(
				"tablet value");
		funnyValueTablets.setWidth("50%");
		this.binder.forField(funnyValueTablets)
				.bind(PlaceValues::getFunnyValuesTablets,
						PlaceValues::setFunnyValuesTablets);
		row.add(funnyValueTablets);

		return row;
	}

	private HorizontalLayout buildRow5() {
		HorizontalLayout row = new HorizontalLayout();
		row.setWidth("100%");
		BigDecimalFieldWithEuroSuffix funnyValueCars = new BigDecimalFieldWithEuroSuffix();
		funnyValueCars.setLabel(
				"cars value");
		funnyValueCars.setWidth("50%");
		this.binder.forField(funnyValueCars)
				.bind(PlaceValues::getFunnyValuesCars,
						PlaceValues::setFunnyValuesCars);
		row.add(funnyValueCars);
		return row;
	}

	private VerticalLayout getModeChange() {
		VerticalLayout layout = new VerticalLayout();
		layout.add(new H2("change"));
		ShowTextFieldOnRadioButton changesToMode = new ShowTextFieldOnRadioButton(
				"did something change?",
				"what changed?");
		this.binder.forField(changesToMode)
				.bind(PlaceValues::getChangesToMode, PlaceValues::setChangesToMode);
		layout.add(changesToMode);
		return layout;
	}

	@Override
	protected PlaceValues generateModelValue() {
		return this.placeFunnyValues;
	}

	@Override
	protected void setPresentationValue(PlaceValues newPresentationValue) {
		if (newPresentationValue != null) {
			this.placeFunnyValues = newPresentationValue;
			binder.setBean(newPresentationValue);
		}
	}

	public Binder<PlaceValues> getBinder() {
		return this.binder;
	}
}
