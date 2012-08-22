package simplemvc;

import java.io.IOException;

public interface IModel {
	public int getNumber() throws IOException;
	public void setNumber(int n) throws IOException;
}
