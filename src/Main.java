import javax.swing.JOptionPane;


public class Main {
	public static void main(String [] args)
	{
		int a = Integer.parseInt(JOptionPane.showInputDialog("Enter number of Circle")); 
		if(a>0&a<10)
		{
			new Game(a);
		}
	}
}
