
public class Main {

	public static void main(String[] args) {
		
        UnCommonWords uw = new UnCommonWordsS1 ();
        // String [] results  =  uw.uncommonFromSentences("this apple is sweet" , "this apple is sour");
        // String [] results  =  uw.uncommonFromSentences("apple apple", "banana");
        String [] results  =  uw.uncommonFromSentences("d b zu d t"  , "udb zu ap");

        for (int i = 0; i < results.length; i++)
        	System.out.print (results [i] + "  " );
	}

}
