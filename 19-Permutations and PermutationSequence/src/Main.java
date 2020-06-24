
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PermutationFinder pf1 = new PermutationFinderS1 ();
		System.out.println ( pf1.getPermutation(4, 7) );
		
		
		
		PermutationFinder pf2 = new PermutationFinderS2 ();
		System.out.println ( pf2.getPermutation(4, 7) );
		
		
		
		PermutationFinderS3 pf3 = new PermutationFinderS3 ();
		pf3.permute(new int [] {1,2,3});
		pf3.printPermutationsList();

	}

}
