package simplemvc;

public interface IController {
//	public IModel getModel();
//
//	public void setModel(IModel model) ;

	public boolean checkValue(String s);
	void setValue(String s);
	String getValue();
	
}
