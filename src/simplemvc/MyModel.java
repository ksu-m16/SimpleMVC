package simplemvc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MyModel implements IModel {
	File f = new File("E:\\MyDocuments\\Eclipse\\SimpleMVC\\data.txt");
	
	public int getNumber() throws IOException{
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	int n = Integer.parseInt(reader.readLine());
	reader.close();
	return n;	
	}
	
	public void setNumber(int n) throws IOException{
		PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		out1.print(n);
		out1.close();
	}
	
}
