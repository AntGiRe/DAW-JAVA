package version2;

public class SueldoException extends Exception{

	private String text;
	
	SueldoException(String txt){
		text = txt;
	}
	
	public String toString() {
		return text;
	}
}

