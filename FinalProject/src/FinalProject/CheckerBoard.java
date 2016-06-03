package FinalProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CheckerBoard extends Canvas implements MouseListener {
	
	private int mouseX, mouseY;
	private boolean mouseClicked, gameOver;
	private int mouseButton, prevMouseButton;
	private Board board;
	
	private ArrayList<CheckerPiece> redPieces;
	private ArrayList<CheckerPiece> bluePieces;
	
	private final static int WIDTH=50;
	private final static int HEIGHT=50;
	private final static int SCALE = 50;
	private final static int BOARDSIZE=8;
	
	public CheckerBoard(){
		mouseClicked = false;
		mouseX = mouseY = 0;
		mouseButton = 0;
		prevMouseButton = -1;
		
		addMouseListener(this);
		setBackground(Color.WHITE);
		
		board = new Board(BOARDSIZE,BOARDSIZE);
		
		redPieces = new ArrayList<CheckerPiece>();
		bluePieces = new ArrayList<CheckerPiece>();
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		mouseX=e.getX();
		mouseY=e.getY();
		mouseButton = e.getButton();
		//System.out.println(mouseX);
		repaint();
	}
	
	public void paint(Graphics window){
		window.setColor(Color.white);
		window.fillRect(0,0,640,480);
		window.setFont(new Font("TAHOMA",Font.BOLD,20));
		window.setColor(Color.red);
		window.drawString("Checkers", 600,55);
		
		int rcount = 0;
		int ccount = 0;
		for(int i = 0; i <BOARDSIZE;i++){
			for(int j = 0; j < BOARDSIZE; j++){
				if(rcount%2==0 && ccount%2==0){
					window.setColor(Color.white);
				}
				else if(rcount%2==0 && ccount%2==1){
					window.setColor(Color.black);
				}
				else if(rcount%2==1 && ccount%2==0){
					window.setColor(Color.BLACK);
				}
				else{
					window.setColor(Color.white);
				}
				window.fillRect((i+1)*50,(j+1)*50,WIDTH,HEIGHT);
				window.setColor(Color.black);
				window.drawRect((i+1)*50,(j+1)*50,WIDTH,HEIGHT);
				ccount++;
			}
			rcount++;
		}
		int count = 0;
		for(int i = 0; i<3;i++){
			for(int j = 0; j<8;j++){
				if(i%2==1){
					if(j%2==0)
						bluePieces.add(new CheckerPiece((j+1)*50+5, (i+1)*50+5, Color.blue));
						board.setSpot(i,j, bluePieces.get(count));
						count++;
				}
				else{
					if(j%2==1)
						bluePieces.add(new CheckerPiece((j+1)*50+5, (i+1)*50+5, Color.blue));
						board.setSpot(i,j, bluePieces.get(count));
						count++;
				}
			}
		}
		count = 0;
		for(int i = 5; i<8;i++){
			for(int j = 0; j<8;j++){
				if(i%2==1){
					if(j%2==0)
						redPieces.add(new CheckerPiece((j+1)*50+5, (i+1)*50+5, Color.red));
						board.setSpot(i,j, bluePieces.get(count));
						count++;
				}
				else{
					if(j%2==1)
						redPieces.add(new CheckerPiece((j+1)*50+5, (i+1)*50+5, Color.red));
						board.setSpot(i,j, bluePieces.get(count));
						count++;
				}
			}
		}
		
		for(int i =0; i<12; i++){
			redPieces.get(i).draw(window);
			bluePieces.get(i).draw(window);
		}
	}
	
	public void markBoard()
	{
		if(mouseX>=WIDTH/3&&mouseX<=WIDTH+50&&mouseY>=HEIGHT/3&&mouseY<=HEIGHT+50)
		{
			int r = mouseY/50-1;
			int c = mouseX/50-1;
			CheckerPiece piece = (CheckerPiece)board.getSpot(r,c);
			//if BUTTON1 was pressed and BUTTON1 was not pressed last mouse press
			if(mouseButton==MouseEvent.BUTTON1&&prevMouseButton!=mouseButton)		//left mouse button pressed
			{
				if(piece==null)
				{
					
				}
				//save the current button pressed to compare to next button pressed
				prevMouseButton=mouseButton;
			}
			//if BUTTON3 was pressed and BUTTON3 was not pressed last mouse press
			if(mouseButton==MouseEvent.BUTTON3&&prevMouseButton!=mouseButton){
				if(piece ==null){
					
				}
			}

				//save the current button pressed to compare to next button pressed
				prevMouseButton=mouseButton;				
		
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}