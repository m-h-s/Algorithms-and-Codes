
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RestoreIPAddressesS1 generator = new RestoreIPAddressesS1 ();
		String s = "101023";
		generator.restoreIpAddresses(s);
		generator.printValidIPs();

	}

}
