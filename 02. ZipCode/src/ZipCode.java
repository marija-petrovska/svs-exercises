public class ZipCode {

	private int zipCode;

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zip) {
		if (containsOnlyDigits(zip) && hasValidLength(zip)) {
			this.zipCode = Integer.valueOf(zip);
		}
	}

	public boolean containsOnlyDigits(String zip) {
		for (int i = 0; i < zip.length(); i++) {
			if (!Character.isDigit(zip.charAt(i)))
				return false;
		}
		return true;
	}

	private boolean hasValidLength(String zip) {
		if (!(zip.length() == 5 || zip.length() == 9)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ZipCode code = new ZipCode();
		code.setZipCode("123456789");
		System.out.println("The zip code is: " + code.getZipCode());
	}
}
