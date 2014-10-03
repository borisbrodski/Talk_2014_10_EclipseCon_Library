package com.github.borisbrodski.ece2014.library.testtools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.github.xfactory.AbstractXFactory;
import org.github.xfactory.XFactory;
import org.hamcrest.Matcher;
import org.junit.Assert;

public class XtendTestContrib {
	public <T, F extends AbstractXFactory<T>> T xbuild(F xfactory) {
		return XFactory.xbuild(xfactory);
	}

	public <T, F extends AbstractXFactory<T>> T xbuild(F xfactory,
			Procedure1<F> initBlock) {
		return XFactory.xbuild(xfactory, initBlock);
	}

	@SuppressWarnings("unchecked")
	public void operator_spaceship(Object o1, Object o2) {
		if (o2 instanceof Matcher<?>) {
			Assert.assertThat(o1, (Matcher<Object>) o2);
		} else {
			Assert.assertEquals(o2, o1);
		}
	}

	public Date april(int day, int year) {
		return DateTimeTools.date(year, 4, day);
	}

	public long years(final int years) {
		Calendar date = Calendar.getInstance();
		Date now = date.getTime();
		date.add(Calendar.YEAR, years);
		return date.getTime().getTime() - now.getTime();
	}

	public Date ago(final long timeInMillis) {
		return new Date(System.currentTimeMillis() - timeInMillis);
	}

	public Date operator_plus(Date date, long timeInMillis) {
		return new Date(date.getTime() + timeInMillis);
	}

	public <T> List<T> applyTransformation(List<T> list) {
		return new ArrayList<>(list);
	}
}
