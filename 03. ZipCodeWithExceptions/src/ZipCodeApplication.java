
public class ZipCodeApplication {
	
	public static void main(String[] args) {
			ZipCode code = new ZipCode();
				try {
					code.setZipCode("123456789");
					System.out.println("Valid zip code: "+ code.getZipCode());
				} 
				catch (InvalidZipCodeException ex) {
					System.out.println("This is not a valid zip code.");
				}
		}
}
