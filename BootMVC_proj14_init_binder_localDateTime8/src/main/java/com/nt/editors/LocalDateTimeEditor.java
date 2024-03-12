package com.nt.editors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class LocalDateTimeEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] ldtContent = text.split("T");
		String[] dateContent = ldtContent[0].split("-");
		String[] timeContent = ldtContent[1].split(":");
		int year = Integer.parseInt(dateContent[0]);
		int month = Integer.parseInt(dateContent[1]);
		int day = Integer.parseInt(dateContent[2]);
		int hour = Integer.parseInt(timeContent[0]);
		int minutes = Integer.parseInt(timeContent[1]);
		LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, minutes);
		setValue(ldt);

	}
}
