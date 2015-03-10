import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SquareListener implements ActionListener
{
	private MineModel model;
	private int i;
	private int j;
	/**
	 * Creates the listener for the buttons of the game
	 * @param model The model of the game
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 */
	public SquareListener(MineModel model, int i, int j)
	{
		this.model = model;
		this.i = i;
		this.j = j;
	}
	/**
	 * Performs the action
	 */
	public void actionPerformed(ActionEvent e)
	{
		model.flip(i, j);
	}
}
