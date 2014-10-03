package com.github.borisbrodski.ece2014.library.testtools;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateTimeTools {
	public static Date date(int year, int month, int day) {
		Calendar instance = GregorianCalendar.getInstance();
		instance.set(Calendar.YEAR, year);
		instance.set(Calendar.MONTH, month + 1);
		instance.set(Calendar.DAY_OF_MONTH, day);

		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);

		return instance.getTime();
	}
}
