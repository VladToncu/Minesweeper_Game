import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class BoardView extends JPanel implements Observer
{
	private MineModel model;
	private JButton[][] buttons;
	/**
	 * Creates the buttons of the game
	 * @param model The model which we want to observe
	 */
	public BoardView(MineModel model)
	{
		super();
		this.model = model;
		buttons = new JButton[10][10];
		
		//Set Layout
		setLayout(new GridLayout(10, 10));
		
		for(int i = 0; i < buttons.length; i++)
		{
			for(int j = 0; j < buttons.length; j++)
			{
				buttons[i][j] = new JButton(" ");
				buttons[i][j].addActionListener(new SquareListener(model, i, j));
				add(buttons[i][j]);
			}
		}
	}
	/**
	 * Update method
	 */
	public void update(Observable obs, Object obj)
	{		
		boolean lost = false;
		boolean won  = false;
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(model.getBoard(i, j) == MineSweeper.BLANK)
				{
						buttons[i][j].setText("");
						buttons[i][j].setEnabled(true);
				}
				else if(model.getBoard(i, j) == MineSweeper.MINE)
				{
					buttons[i][j].setText("");
					buttons[i][j].setEnabled(true);
				}
						
				if(model.getBoard(i, j) == MineSweeper.EMPTY)
				{					
						String string = "" + model.getNum(i, j);
						
						buttons[i][j].setText(string);
						
						buttons[i][j].setEnabled(false);
						
						model.checkWin();
						if(model.checkWin() == true)
						{
							won = true;
						}
				}
				else if(model.getBoard(i, j) == MineSweeper.BOMB)
				{
					buttons[i][j].setText("X");					
					lost = true;
				}
			}
		}
		
		if(lost == true)
		{
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(model.getBoard(i, j)==MineSweeper.MINE)
					{
						buttons[i][j].setText("X");	
					}
					buttons[i][j].setEnabled(false);
				}
			}
		}
		
		if(won == true)
		{
			JOptionPane.showMessageDialog(null, "You won!", "MineSweeper", JOptionPane.CLOSED_OPTION);
		}
		repaint();
	}
}
