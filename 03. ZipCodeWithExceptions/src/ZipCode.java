
public class ZipCode {

	private int zipCode = 0;

	public void setZipCode(String zip) throws InvalidZipCodeException {

		if (!containsOnlyDigits(zip) || !hasValidLength(zip)) {
			throw new InvalidZipCodeException();
		}
		
		this.zipCode = Integer.valueOf(zip);
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

	public int getZipCode() {
		return this.zipCode;
	}

}
