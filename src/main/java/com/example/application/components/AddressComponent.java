package com.example.application.components;

import com.example.application.data.entity.AddressField;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Style;

public class AddressComponent extends CustomField<AddressField> {

	private final Binder<AddressField> binder =
			new Binder<>(AddressField.class);

	private AddressField addressField = new AddressField();

	private TextField streetAndNumberField;
	private TextField postcode;
	private TextField cityField;
	private TextField countryField;

	public AddressComponent() {
		Paragraph address = new Paragraph("Standort der/des Betriebsstätte/Risikoorts");
		address.getStyle().setFontWeight(Style.FontWeight.BOLD);
		this.add(new HorizontalLayout(address));
		this.add(this.buildRow2());
		this.binder.setBean(this.addressField);
	}

	private HorizontalLayout buildRow2() {
		HorizontalLayout row = new HorizontalLayout();
		row.setWidth("100%");
		this.streetAndNumberField = new TextField();
		streetAndNumberField.setLabel("street and number");
		this.binder.forField(streetAndNumberField).bind(AddressField::getStreetAndNumber, AddressField::setStreetAndNumber);
		row.add(streetAndNumberField);

		this.postcode = new TextField();
		postcode.setLabel("postal code");
		postcode.setPattern("[0-9]*");
		this.binder.forField(postcode).bind(AddressField::getPostalCode, AddressField::setPostalCode);
		row.add(postcode);

		this.cityField = new TextField();
		cityField.setLabel("place");
		this.binder.forField(cityField).bind(AddressField::getCity, AddressField::setCity);
		row.add(cityField);

		this.countryField = new TextField();
		countryField.setLabel("country");
		this.binder.forField(countryField).bind(AddressField::getCountry, AddressField::setCountry);
		row.add(countryField);

		return row;
	}

	@Override
	protected AddressField generateModelValue() {
		return this.addressField;
	}

	@Override
	protected void setPresentationValue(AddressField newPresentationValue) {
		if (newPresentationValue != null) {
			this.addressField = newPresentationValue;
			binder.setBean(newPresentationValue);
		}
	}

	public Binder<AddressField> getBinder() {
		return binder;
	}
}
