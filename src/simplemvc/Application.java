package simplemvc;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		IModel m = new MyModel();
		MyView v = new MyView();
		MyController c = new MyController();
		c.setModel(m);
		v.setController(c);
		v.run();				
	}

}
