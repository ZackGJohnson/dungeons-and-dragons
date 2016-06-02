package db;

public class DataScoreTester {

	public static void main(String[] args) {
		
		DataBaseRead reader = new DataBaseRead();
		
		System.out.println(reader.toString() + "\n");
		
		reader.insertScore("abc", 18000);
		reader.insertScore("def", 50);
		
		System.out.println(reader.toString());
	}

}
