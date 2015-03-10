import java.util.Random;


public class MineSweeper
{
	public static final int BLANK = 0;
	public static final int EMPTY = 1;
	public static final int MINE  = 2;
	public static final int BOMB  = 3;
	
	public boolean EASY = false;
	public boolean NORMAL = true;
	public boolean HARD = false;
	
	private int bombLimit;
	
	private int board[][];
	
	Random rdm=new Random();
	/**
	 * Creates a board of numbers, which is the number displayed on the buttons
	 */
	public MineSweeper()
	{		
		board = new int[10][10];
		
		makeBoard();
	}
	/**
	 * Creates the board of the game
	 */
	public void makeBoard()
	{	
		if		(EASY)	{bombLimit = 10;}
		else if (NORMAL){bombLimit = 15;}
		else if (HARD)	{bombLimit = 20;}
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				board[i][j]=BLANK;
		for(int i=0;i<bombLimit;i++)
		{
			int x=rdm.nextInt(10);
			int y=rdm.nextInt(10);
			while(board[x][y]==MINE)
			{
				x=rdm.nextInt(10);
				y=rdm.nextInt(10);
			}
			board[x][y]=MINE;
		}
	}
	/**
	 * Gets a particular board
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 * @return The board at the selected coordinates
	 */
	public int getBoard(int i, int j)
	{
		return this.board[i][j];
	}
	/**
	 * Selects the difficulty of the game 
	 * @return The difficulty of the game
	 */
	public String getDifficulty()
	{
		String str = "";
		
		if(this.EASY == true)
		{
			str = "EASY";
		}
		else if(this.NORMAL == true)
		{
			str = "NORMAL";
		}
		else if(this.HARD == true)
		{
			str = "HARD";
		}
		
		return str;
	}
	/**
	 * If a button is selected, it will change the values
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 */
	public void flip(int i, int j)
	{
			if(board[i][j] == BLANK)
			{
				board[i][j] = EMPTY;
			}
			
			if(board[i][j] == MINE)
			{
				board[i][j] = BOMB;
			}
	}
	/**
	 * Reveals the entire buttons (Flips the board)
	 */
	public void reveal()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(board[i][j] == BLANK)
				{
					board[i][j] = EMPTY;
				}
				
				if(board[i][j] == MINE)
				{
					board[i][j] = BOMB;
				}
			}
		}
	}
	/**
	 * Flips all the bombs
	 */
	public void revealBombs()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(board[i][j] == MINE)
				{
					board[i][j] = BOMB;
				}
			}
		}
	}
	/**
	 * Gets the number of the mines near to the safe places 
	 * @param i The Y Coordinate of the button
	 * @param j	The X Coordinate of the button
	 * @return The number of near mines
	 */
	public int getNum(int i, int j)
	{
		int count = 0;

		if(i > 0 && board[i-1][j] == MINE ^ board[i-1][j] == BOMB)
		{
			count = count + 1;
		}
	
		if(i < 9 && board[i+1][j] == MINE ^ board[i+1][j] == BOMB)
		{
			count = count + 1;
		}

		if(j > 0 && board[i][j-1] == MINE ^ board[i][j-1] == BOMB)
		{
			count = count + 1;
		}

		if(j < 9 && board[i][j+1] == MINE ^ board[i][j+1] == BOMB)
		{
			count = count + 1;
		}

		if(i > 0 && j > 0 && board[i-1][j-1] == MINE ^ board[i-1][j-1] == BOMB)
		{
			count = count + 1;
		}

		if(i > 0 && j < 9 && board[i-1][j+1] == MINE ^ board[i-1][j+1] == BOMB)
		{
			count = count + 1;
		}

		if(i < 9 && j > 0 && board[i+1][j-1] == MINE ^ board[i+1][j-1] == BOMB)
		{
			count = count + 1;
		}

		if(i < 9 && j < 9 && board[i+1][j+1] == MINE ^ board[i+1][j+1] == BOMB)
		{
			count = count + 1;
		}

		return count;
	}
	/**
	 * Check if the player won the game
	 * @return the value of the win
	 */
	public boolean checkWin()
	{
		int count = 0;
		int bombCount = 0;
		
		boolean win = false;
		
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(board[i][j] == EMPTY)
				{
					count++;
				}
				else if(board[i][j] == BOMB)
				{
					bombCount++;
				}
				
				if(count == (100-bombLimit) && bombCount == 0)
				{
					win = true;
				}
			}
		}
		
		return win;
	}
	/**
	 * Sets the difficulty to easy
	 */
	public void setEasy()
	{
		EASY = true;
		NORMAL = false;
		HARD = false;	
		MineSweeper sweep=new MineSweeper();
	}
	/**
	 * Sets the difficulty to normal
	 */
	public void setNormal()
	{
		EASY = false;
		NORMAL = true;
		HARD = false;
		MineSweeper sweep=new MineSweeper();
	}
	/**
	 * Sets the difficulty to hard
	 */
	public void setHard()
	{
		EASY = false;
		NORMAL = false;
		HARD = true;
		MineSweeper sweep=new MineSweeper();
	}
}
