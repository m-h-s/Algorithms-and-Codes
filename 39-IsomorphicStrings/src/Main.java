
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ShapeEquivalanceChecker checker1 = new ShapeEquivalanceCheckerS1 ();
//		String s = "egg";
//		String t = "add";
		
//		String s = "paper";
//     	String t = "title";
		
		String s = "foo";
        String t = "bar";
		
		ShapeEquivalanceChecker checker1 = new ShapeEquivalanceCheckerS2 ();
		
		System.out.println (checker1.isIsomorphic(s, t));
		
		
		

	}

}
