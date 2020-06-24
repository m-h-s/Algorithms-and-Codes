
public class Main {

	public static void main(String[] args) {
		Distributer ds= new DistributerS1 ();
		int [] g = {10,9,8,7};
		int [] s = {5,6,7,8};
		System.out.println (ds.findContentChildren(g, s));

	}

}
