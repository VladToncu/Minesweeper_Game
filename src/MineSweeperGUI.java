import javax.swing.JFrame;


public class MineSweeperGUI
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MineSweeper");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MineSweeper ms = new MineSweeper();
		
		
		MineComponent comp = new MineComponent(ms);
		
		frame.add(comp);
		frame.setVisible(true);
	}
}
