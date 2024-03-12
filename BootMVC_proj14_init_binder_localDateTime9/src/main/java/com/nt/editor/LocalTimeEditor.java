package com.nt.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class LocalTimeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String[] timeData = text.split(":");
		int hour = Integer.parseInt(timeData[0]);
		int minute = Integer.parseInt(timeData[1]);
		LocalTime lt = LocalTime.of(hour, minute);
		setValue(lt);
	}

}
