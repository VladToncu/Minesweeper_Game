import java.awt.BorderLayout;

import javax.swing.JPanel;


public class MineComponent extends JPanel
{
	/**
	 * The component of the game
	 * @param game The game we want to display
	 */
	public MineComponent(MineSweeper game)
	{
		super();
		
		MineModel model = new MineModel(game);
		
		BoardView view = new BoardView(model);
		ControlPanel cpanel = new ControlPanel(model);
		
		model.addObserver(view);
		model.addObserver(cpanel);
		
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);
		add(cpanel, BorderLayout.SOUTH);
		
	}	
}
