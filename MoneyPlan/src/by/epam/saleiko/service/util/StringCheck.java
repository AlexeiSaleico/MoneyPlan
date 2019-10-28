package by.epam.saleiko.service.util;

public class StringCheck {
	public static boolean hasForbiddenCharacters(String... input) {
		for (String str : input) {
			if (str.contains("#") || str.contains("/"))
				return false;
		}
		return true;
	}
}
