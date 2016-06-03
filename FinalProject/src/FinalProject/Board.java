package FinalProject;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Board
{
	private Square[][] grid;
	
	public Board()
	{
		setSize(0,0);
	}

	public Board(int rows, int cols)
	{	
		setSize(rows, cols);

	}

	public void setSize(int rows, int cols)
	{
		grid = new Square[rows][cols];

	}

	public void setSpot(int row,int col, Square val)
	{
		grid[row][col]= val;

	}
	
	public Square getSpot(int row, int col)
	{
		return grid[row][col];
	}
	
	public int getNumRows()
	{
		return grid.length;
	}
	
	public int getNumCols()
	{
		return grid[0].length;
	}

	public boolean drawGrid(Graphics window)
	{
		boolean full=true;
		
		//for loop for row
		for(Square[] r: grid){

			//for loop for col
			for(Square c: r){
				//get current Cell
				//if it is null
				if(c==null){	
					full = false;
					//System.out.println("0");
				}
				else{
					c.draw(window);
					//System.out.println("1");
				}
				//System.out.println("9");
			}
		}

		return full;
	}
	
	public String toString()
	{
		String output="";
		for(Square[] r: grid){
			for(Square c: r){
				output+=c+" ";
			}
		}




		return output;
	}
}