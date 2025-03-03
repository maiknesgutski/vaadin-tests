package com.example.application.components;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import com.vaadin.flow.component.html.Div;
import org.vaadin.miki.superfields.numbers.SuperBigDecimalField;

public class BigDecimalFieldWithEuroSuffix extends SuperBigDecimalField {

	public BigDecimalFieldWithEuroSuffix() {
		super();
		this.setLocale(Locale.GERMANY);
		this.setMinimumFractionDigits(2);
		this.setMaximumFractionDigits(2);
		Div euroSuffix = new Div();
		euroSuffix.setText("€");
		this.setSuffixComponent(euroSuffix);
		this.addValueChangeListener(event -> {
			BigDecimal value = event.getValue();
			if (value != null) {
				value = value.setScale(2, RoundingMode.HALF_UP);
				this.setValue(value);
			} else {
				this.setValue(BigDecimal.ZERO);
			}
		});
	}
}
