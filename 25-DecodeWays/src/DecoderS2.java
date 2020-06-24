/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 6 - 16 
 * 
 * License : Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class DecoderS2 implements Decoder {

  /**
   * ######## Note this solution is not time efficient. #################
   */
	@Override
	public int numDecodings(String s) {

		int numberOfDecodings = decode (s);


		return numberOfDecodings;
	}

	public int decode (String s)
	{
	
		if (Integer.parseInt(s.charAt(0) +"") == 0  || ( s.length() >= 2 && Integer.parseInt(s.charAt(1) +"") == 0 && Integer.parseInt(s.charAt(0) +"") > 2))
			return 0;


		else if ( Integer.parseInt(s.charAt(0) + "") >= 3 )
		{
			
			if (s.length() == 1)
				return 1;
			else
				return decode (s.substring(1));
		}

		else if (  s.length() >= 2 && Integer.parseInt(s.charAt(0) +"") == 2 && Integer.parseInt(s.charAt(1) +"") >= 7)

		{
			
			if (s.length() == 2)
				return 1;
			else
				return decode (s.substring(2));
		}

		else
		{

			
			if (s.length () == 1)
				return 1;


			else if (s.length() == 2)
			{  

				if (Integer.parseInt(s.charAt(1) +"") == 0 )
					return 1;
				else
					return 2;

			}

			else 
				return decode (s.substring(1)) + decode (s.substring(2));
		}


	}

}
