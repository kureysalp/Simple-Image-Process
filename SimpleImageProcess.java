package package_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SimpleImageProcess extends JFrame {
	private DrawingPanel dp;
	private short [][] pixels;
	private int width, height;
	
	SimpleImageProcess() {		
		ReadFile("C:\\Users\\Pc\\Downloads\\text_based_image_file.txt");		
		
		dp = new DrawingPanel();			
		
		this.setContentPane(dp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setVisible(true);
	}
	
	void ReadFile(String path)
	{	
		try {
			Scanner _inFile = new Scanner(new File(path));
			int _fileType = _inFile.nextInt();
			width = _inFile.nextInt();
			height = _inFile.nextInt();
			
			System.out.printf("type: %d, width: %d, height: %d", _fileType, width, height);
			
			pixels = new short[width][height];
			
			for(int row = 0; row < height; row++) 
				for(int col = 0; col < width; col++) 
					pixels[row][col] = _inFile.nextShort();					
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	class DrawingPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g)
		{
			g.drawString("Advanced Programming", 250, 300);
			for(int row = 0; row < height ; row++)
				for(int col = 0; col < width; col++)
				{					
					g.setColor(new Color(pixels[row][col], pixels[row][col], pixels[row][col]));
					g.fillRect(col, row, 1, 1);
				}
				
		}
			
	}
	
	
	public static void main(String[] args) {
		SimpleImageProcess sp = new SimpleImageProcess();
	}

}
