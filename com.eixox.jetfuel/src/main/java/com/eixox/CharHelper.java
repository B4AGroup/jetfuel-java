package com.eixox;

public final class CharHelper {

	public static final char removeAccent(char c) {
		switch (c) {
		case '�':
		case '�':
		case '�':
		case '�':
		case '�':
			return 'a';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'e';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'i';
		case '�':
		case '�':
		case '�':
		case '�':
		case '�':
			return 'o';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'u';
		case '�':
		case '�':
		case '�':
		case '�':
		case '�':
			return 'A';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'E';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'I';
		case '�':
		case '�':
		case '�':
		case '�':
		case '�':
			return 'O';
		case '�':
		case '�':
		case '�':
		case '�':
			return 'u';
		case '�':
			return 'c';
		case '�':
			return 'C';
		case '�':
			return 'n';
		case '�':
			return 'N';
		default:
			return c;
		}
	}
}
