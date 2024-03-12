package com.nt.editors;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class LocalTimeEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] dateContent = text.split(":");
		int hours = Integer.parseInt(dateContent[0]);
		int minutes = Integer.parseInt(dateContent[1]);
		LocalTime lt = LocalTime.of(hours, minutes);
		setValue(lt);
	}
}
