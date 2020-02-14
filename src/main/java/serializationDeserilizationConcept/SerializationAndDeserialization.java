package serializationDeserilizationConcept;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable {

	int a = 10, b = 20;
}

public class SerializationAndDeserialization {

	public static void main(String[] args) throws Exception {

		Test t1 = new Test();

		// Serialization

		FileOutputStream fos = new FileOutputStream("test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(t1);

		oos.close();
		fos.close();

		// DeSerialization

		FileInputStream fis = new FileInputStream("test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Test t2 = (Test) ois.readObject();

		System.out.println("Value of a : " + t2.a);
		System.out.println("Value of b : " + t2.b );
		
		ois.close();
		fis.close();

	}

}
