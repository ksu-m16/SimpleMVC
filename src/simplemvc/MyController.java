package simplemvc;

public class MyController implements IController {
	
	private IModel model;
	
	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	
}
