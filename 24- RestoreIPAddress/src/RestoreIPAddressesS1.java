/**
 * @author Mahsa Sadi
 * 
 * @since 2020 - 05 - 04
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 * 
 * 
 */
import java.util.*;

public class RestoreIPAddressesS1 implements RestoreIPAddresses {

	/**
	 * Problem: Restore IP Addresses
	 * 
	 * 
	 * @see https://leetcode.com/problems/restore-ip-addresses/
	 * 
	 * 
	 * Description:
	 * 
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
	 * 
	 * 
	 * Solution:
	 * 
	 * A valid IP has four sections and each section has one to three digits.
	 * For n = 4 to 1
	 *    a) pick i digits (between 1 to 3) from the given string.
	 *    b) Check that the picked digits are valid; i.e.; the  resulting number is less than or equal to 255 and there are no zeros at the beginning.
	 *    c) Check if i digits are removed, the rest of the string can be distributed between n-1 sections in a valid form.
	 *    d) If Yes, remove i digits and continue the steps for the rest of the string.
	 *    e) If No, change i.
	 * 
	 * There is a valid form for distributing a string between m sections if
	 *    string.length () >= m and string.length <= m*3.
	 *    
	 * 
	 */

	List <String>  validIPs = new ArrayList <String> ();

	@Override
	public List<String> restoreIpAddresses(String s) {

		generateValidIPs (s, "", 4);

		return validIPs;
	}


	void generateValidIPs (String s, String IP, int numberOfSections)
	{



		if  (numberOfSections == 1)

		{
			if (s.length() != 0 && s.length () <=3 && Integer.parseInt(s) <= 255 && !(s.charAt(0) == '0' && s.length() > 1))
			{ 
				IP+= s.substring(0, s.length());
				validIPs.add(IP);

			}
		}


		else 
		{

			for (int i = 1; i <= 3; i++ )
			{ 
				if (s.length() - i <= (numberOfSections- 1) * 3 && (s.length() - i) >= (numberOfSections - 1) )
					if (!(s.charAt(0) == '0' && i > 1) && Integer.parseInt(s.substring(0, i)) <= 255)
					{
						String initialIP = IP;
						IP += s.substring(0, i) +".";
						numberOfSections--;
						generateValidIPs (s.substring(i, s.length()), IP, numberOfSections);
						IP = initialIP;
						numberOfSections++;
					}
			}
		}
	}


	void printValidIPs ()
	{
		for (int i = 0; i < validIPs.size(); i++ )
			System.out.println (validIPs.get(i));
	}

}
