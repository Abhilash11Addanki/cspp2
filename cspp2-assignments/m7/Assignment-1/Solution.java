import java.util.*;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	private String data;
	private int length;
	InputValidator(String d) {
		data = d;
		length = 6;
	}
	boolean validateData() {
		if (data.length() >= length) {
			return true;
		}
		return false;
	}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
