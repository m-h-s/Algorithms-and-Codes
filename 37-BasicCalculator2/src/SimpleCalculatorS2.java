import java.util.*;
/**
 * 
 * @author Mahsa Sadi
 * 
 * @since 2020 - 06 - 10
 * 
 * License Creative Commons
 * 
 * Copyright by Mahsa Sadi
 *
 */
public class SimpleCalculatorS2 implements SimpleCalculator {

	StackQueue <Integer> numberStackQueue;
	StackQueue <Character> operatorStackQueue;
	Map <Character, Integer> priority;

	@Override
	public int calculate(String s) {
		/**
		 * 1- Consider two double-headed queues (I call them stack queues): 1) a  number stack queue. 2) an operator stack queue
		 * 2- Read and parse the string and update the number and the operator stack queues, with the following considerations
		 * 3- If the currently read char is /, *, +, -,
		 *     Check top of the operator stack queue.
		 *     1- Until the priority of the top operator is >= the priority of current read char, perform the related calculations and update both stack queues.
		 *     2- Put the currently read operator in the operator stack queue.
		 * 4 - While operator stack queue is not empty
		 *        1- Dequeue an operator and the related numbers from the operator stack queue and the number stack queue.
		 *        2- Perform the operation.
		 *        3- Update the number stack queue.
		 *        
		 * 5 - Return the only element in the number stack queue.
		 */
		numberStackQueue = new StackQueue <Integer> ();
		operatorStackQueue = new StackQueue <Character> ();
		priority = new HashMap <Character, Integer> ();
		priority.put ('*', 2);
		priority.put ('/', 2);
		priority.put ('+', 1);
		priority.put ('-', 1);

		parseString (s);
		calculate ();


		return numberStackQueue.top();
	}

	public void parseString (String s)
	{
		String str = "";
		for (int i  = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-')
			{
				int number = Integer.parseInt(str);
				numberStackQueue.push(number);

				if (!operatorStackQueue.isEmpty() && priority.get(s.charAt(i)) <= priority.get(operatorStackQueue.top ()))
					operateOnStack (s.charAt(i));

				operatorStackQueue.push(s.charAt(i));

				str = "";
			}

			else
				if (s.charAt(i) != ' ')
					str+= s.charAt(i);
		}

		numberStackQueue.push(Integer.parseInt(str));

		if (! operatorStackQueue.isEmpty() && (operatorStackQueue.top() == '/' || operatorStackQueue.top() == '*'))
			operateOnStack (operatorStackQueue.top());
	}



	public void calculate ()
	{
		while (! operatorStackQueue.isEmpty())
			operateOnQueue ();	
	}



	public void operateOnStack (char newOperator)
	{
		int n1, n2;

		while (!operatorStackQueue.isEmpty() && priority.get(operatorStackQueue.top()) >= priority.get (newOperator))
		{   
			n2 = numberStackQueue.pop ();
			n1 = numberStackQueue.pop ();
			char op = operatorStackQueue.pop ();
			int result = operate(n1, n2, op);

			numberStackQueue.push(result);
		}

	}

	public void operateOnQueue ()
	{
		int n1 = numberStackQueue.dequeue();
		int n2 = numberStackQueue.dequeue();
		char op = operatorStackQueue.dequeue ();
		int result = operate(n1, n2, op);

		numberStackQueue.enqueue(result);

	}

	private int operate(int n1, int n2, char op) {
		int result;

		if (op == '*')
			result = n1 * n2;
		else if (op == '/')
			result = n1 / n2;
		else if (op == '+')
			result = n1 + n2;
		else
			result = n1 - n2;
		return result;
	}



	public class StackQueue <T>
	{
		List <T> stackQueue;



		public StackQueue  ()
		{
			stackQueue = new ArrayList <T>();
		}

		public void push (T item)
		{
			stackQueue.add(item);

		}

		public T pop ()
		{

			T item  = stackQueue.remove(stackQueue.size() - 1);
			return item;
		}

		public T top ()
		{
			return stackQueue.get(stackQueue.size() - 1);
		}

		public boolean isEmpty ()
		{
			return stackQueue.size() == 0;
		}


		public String toString ()
		{
			String str = "";

			for (int i = 0 ;  i < stackQueue.size(); i++)
				str +=  stackQueue.get(i) + " ";
			return str;

		}

		public T dequeue ()
		{
			return this.stackQueue.remove(0);
		}

		public void enqueue (T item)
		{
			this.stackQueue.add(0, item);
		}
	}
}
