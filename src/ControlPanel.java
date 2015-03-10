import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ControlPanel extends JPanel implements Observer
{
	MineModel model;
	JRadioButton easy;
	JRadioButton normal;
	JRadioButton hard;
	MineSweeper mine;
	/**
	 * The panel which contains the buttons
	 * @param model The MineModel wich we want to observe
	 */
	public ControlPanel(MineModel model)
	{
		this.model = model;
		
		JButton restart = new JButton("Restart");
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				model.makeBoard();
			}
		});
		
		JButton exit 	= new JButton("Exit");
		exit.addActionListener(e -> System.exit(0));
		
		JButton reveal 	= new JButton("Reveal");
		reveal.addActionListener(e -> model.reveal());
		
		easy = new JRadioButton("Easy");		
		easy.addActionListener(e -> {model.setEasy();model.makeBoard();});
		normal = new JRadioButton("Normal");
		normal.addActionListener(e -> {model.setNormal();model.makeBoard();});		
		hard = new JRadioButton("Hard");
		hard.addActionListener(e -> {model.setHard();model.makeBoard();});
		
		normal.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		add(restart);		
		add(reveal);
		add(exit);
		
		bg.add(easy);
		add(easy);
		
		bg.add(normal);
		add(normal);
		
		bg.add(hard);
		add(hard);
		
	}
	/**
	 * The update method
	 */
	public void update(Observable o, Object arg) {
		
	model=new MineModel(mine);
	repaint();
		
	}
}
