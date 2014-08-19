package com.eixox.generators.creditCard;

import com.eixox.generators.CreditCardGenerator;


public class Visa extends CreditCardGenerator {
	public Visa() {
		super("40", "43", "47");
	}

	@Override
	public String getTitle() {
		return "Visa";
	}

	@Override
	public String getSummary() {
		return "N�meros de cart�es de cr�dito v�lidos Visa.";
	}

	@Override
	public String getLink() {
		return "http://pt.wikipedia.org/wiki/Visa";
	}

	@Override
	public int getDigitCount() {
		return 16;
	}

}
