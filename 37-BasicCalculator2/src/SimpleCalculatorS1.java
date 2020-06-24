import java.util.*;
public class SimpleCalculatorS1 implements SimpleCalculator {

	List <String> input;
	@Override
	public int calculate(String s) {
		/**
		 * #####################This solution is native and not time-efficient.#####################
		 */

		parseString (s);

		compile ();

		return Integer.parseInt(input.get(0));
	}


	public void parseString (String s)
	{
		input = new ArrayList <String> ();
		String num ="";

		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '/' || s.charAt(i) == '*' || s.charAt(i) == '+' || s.charAt(i) == '-')
			{  
				input.add(num);
				input.add(s.charAt(i)+"");
				num ="";
			}

			else
				if (s.charAt(i) != ' ' )
					num+= s.charAt(i);	
		}

		if (num != "")
			input.add(num);
	}

	public void compile ()
	{
		int i = 0;
		while (i < input.size())

		{

			if (input.get(i).equals("*"))
			{

				int num1 = Integer.parseInt(input.get(i - 1));
				int num2 = Integer.parseInt(input.get(i + 1));
				Integer result = num1 * num2;
				input.remove(i - 1);
				input.add(i - 1, result.toString());
				input.remove (i);
				input.remove(i);
				
			}
			else if (input.get(i).equals("/"))
			{
				int num1 = Integer.parseInt(input.get(i - 1));
				int num2 = Integer.parseInt(input.get(i + 1));
				Integer result = num1 / num2;
				input.remove(i - 1);
				input.add(i - 1, result.toString());
				input.remove (i);
				input.remove(i);
			
			}

			else
				i++;
		}
		
		
		i = 0;
		while (i < input.size())

		{

			if (input.get(i).equals("+"))
			{

				int num1 = Integer.parseInt(input.get(i - 1));
				int num2 = Integer.parseInt(input.get(i + 1));
				Integer result = num1 + num2;
				input.remove(i - 1);
				input.add(i - 1, result.toString());
				input.remove (i);
				input.remove(i);

			}
			else if (input.get(i).equals("-"))
			{
				int num1 = Integer.parseInt(input.get(i - 1));
				int num2 = Integer.parseInt(input.get(i + 1));
				Integer result = num1 - num2;
				input.remove(i - 1);
				input.add(i - 1, result.toString());
				input.remove (i);
				input.remove(i);
				
			}

			else
				i++;
		}
	}
}


