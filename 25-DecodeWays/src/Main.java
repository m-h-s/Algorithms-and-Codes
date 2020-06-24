
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String input  = "2839";
		//String input = "1212";
		//String input = "226";
		//String input = "0";
		//String input = "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565";
		String input = "9355141842519423434975558424574331479338913773268525913972842463395324957127519863135646135786662832";
		//DecoderS1 decoder = new DecoderS1 ();
		//DecoderS2 decoder = new DecoderS2 ();
		DecoderS3 decoder = new DecoderS3 ();
		System.out.println (decoder.numDecodings(input));

	}

}
