package com.nt.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

public class LocalDateTimeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String[] ldtData = text.split("T");
		String[] localDateData = ldtData[0].split("-");
		int year = Integer.parseInt(localDateData[0]);
		int month = Integer.parseInt(localDateData[1]);
		int day = Integer.parseInt(localDateData[2]);
		String[] localTimeData = ldtData[1].split(":");
		int hour = Integer.parseInt(localTimeData[0]);
		int minute = Integer.parseInt(localTimeData[1]);
		LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, minute);
		setValue(ldt);
	}
}
