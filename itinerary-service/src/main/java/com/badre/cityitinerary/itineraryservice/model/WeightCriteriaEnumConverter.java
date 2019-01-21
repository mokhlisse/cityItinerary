package com.badre.cityitinerary.itineraryservice.model;

import java.beans.PropertyEditorSupport;

/**
 * intercept weight criteria in request and converts to {@link WeightCriteria}
 *
 * @author <a href="mailto:mokhlisse_badre@yahoo.fr">Badre Edine Mokhlisse</a>
 */
public class WeightCriteriaEnumConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String upper = text.toUpperCase();
		WeightCriteria criteria = WeightCriteria.valueOf(upper);
		setValue(criteria);
	}
}