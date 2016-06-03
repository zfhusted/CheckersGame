package FinalProject;

import java.awt.Component;

import javax.swing.JFrame;


public class Checkers extends JFrame{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Checkers()
	{
		super("CHECKERS");
		setSize(WIDTH,HEIGHT);

		CheckerBoard theGame = new CheckerBoard();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Checkers run = new Checkers();
	}
}
