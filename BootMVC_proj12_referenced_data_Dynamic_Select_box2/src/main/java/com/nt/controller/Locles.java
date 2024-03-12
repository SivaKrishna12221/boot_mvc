package com.nt.controller;

import java.util.Arrays;
import java.util.Locale;

public class Locles {
	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		System.out.println(Arrays.toString(locales));
		for (Locale lo : locales) {
			System.out.print(lo.getCountry() + ",");
		}
		for (Locale lo : locales) {
			System.out.println(lo.getDisplayCountry());
		}
		for (Locale lo : locales) {
			System.out.println(lo.getDisplayName());
		}
	}
}
