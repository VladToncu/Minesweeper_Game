import java.util.Observable;


public class MineModel extends Observable
{
	MineSweeper ms;
	/**
	 * Creates a model of the game
	 * @param ms The game which we want to display
	 */
	public MineModel(MineSweeper ms)
	{
		super();
		this.ms = ms;
	}
	/**
	 * Gets the difficulty
	 * @return The difficulty of the game
	 */
	public String getDifficulty()
	{
		return this.ms.getDifficulty();
	}
	/**
	 * Gets a button
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 * @returnThe chosen button given the coordinates
	 */
	public int getBoard(int i, int j)
	{
		return this.ms.getBoard(i, j);
	}
	/**
	 * Flips the button
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 */
	public void flip(int i, int j)
	{
		this.ms.flip(i, j);
		setChanged();
		notifyObservers();
	}
	/**
	 * Reveals the game
	 */
	public void reveal()
	{
		this.ms.reveal();
		setChanged();
		notifyObservers();
	}
	/**
	 * Gets the number of mines near to a button
	 * @param i The Y Coordinate of the button
	 * @param j The X Coordinate of the button
	 * @return The number of mines near to a button
	 */
	public int getNum(int i, int j)
	{
		return this.ms.getNum(i, j);
	}
	/**
	 * Reveals the bombs
	 */
	public void revealBombs()
	{
		this.ms.revealBombs();
	}
	/**
	 * Check if the player won
	 * @return The value true if the player won and false otherwise
	 */
	public boolean checkWin()
	{
		return this.ms.checkWin();
	}
	
	//Set methods
	/**
	 * Creates the board of the game
	 */
	public void makeBoard()
	{
		this.ms.makeBoard();
		setChanged();
		notifyObservers();
	}
	/**
	 * Sets the difficulty to easy
	 */
	public void setEasy()
	{
		this.ms.setEasy();
		setChanged();
		notifyObservers();
	}
	/**
	 * Sets the difficulty to normal
	 */
	public void setNormal()
	{
		this.ms.setNormal();
		setChanged();
		notifyObservers();
	}
	/**
	 * Sets the difficulty to hard
	 */
	public void setHard()
	{
		this.ms.setHard();
		setChanged();
		notifyObservers();
	}
}
