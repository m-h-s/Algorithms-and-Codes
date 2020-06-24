/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 01 
 * 
 * License : Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class DecoderS1 implements Decoder {

	int numberOfValidDecodings;
	@Override
	public int numDecodings(String s) {
		 /**
		   * ######## Note this solution is not time efficient. #################
		   */
		
		decode (s);
		
		return this.numberOfValidDecodings;
	}
	
	
	void decode (String s)
	{
		
		if (s.length() == 0)
			this.numberOfValidDecodings++;
		
		
		else
		{
			for (int i = 1 ; i <= 2; i++)
			{
				
				if ( i <= s.length() && ((i == 1 && (s.charAt(0) != '0')) || (i == 2 && ( (s.charAt(0) == '1') || (s.charAt(0) == '2')  ) ) ) )
				    { 
					  String initialS = s;
					  String subString ;
					  subString = s.substring(0, i);
					  if (Integer.parseInt(subString) < 27)
						  decode (s.substring(i, s.length ()));
					  s = initialS;
				    }
			}
		}
	}

}
