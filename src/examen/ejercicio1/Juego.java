package examen.ejercicio1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Juego extends JPanel {
	
	
	private Lienzo lienzo;
	String letras= "abcdefghijklmnñopqrstuvwxyz";
	private Font font;
	
	
	public Juego(Lienzo lienzo) throws FontFormatException,IOException {
		this.lienzo=lienzo;
		
		InputStream in = getClass().getResourceAsStream("/COMIC.TTF");
		font =Font.createFont(Font.PLAIN, in).deriveFont(30.f);
		
		setLayout(new BorderLayout());
		
		JPanel sup=new JPanel(new GridLayout(1,1));
		JLabel lblPalabra = new JLabel("PALABRA");
		sup.add(lblPalabra);
		
		lblPalabra.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30,30,30,30),
				BorderFactory.createCompoundBorder(
						BorderFactory.createLineBorder(Color.DARK_GRAY),
						BorderFactory.createEmptyBorder(20,20,20,20))));
		lblPalabra.setHorizontalAlignment(JLabel.CENTER);
		lblPalabra.setFont(font);
		sup.add(lblPalabra);
		
		JPanel inf=new JPanel(new GridLayout(4,7));
		inf.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(30,30,30,30),
				BorderFactory.createBevelBorder(BevelBorder.RAISED)));
		
		for(int i=0;i<letras.length();i++) {
			JButton b = new JButton("" + letras.substring(i, i + 1));
			b.setFont(font);
			inf.add(b);
		}
		inf.add(new JButton(new ImageIcon(getClass().getResource("/play-button.png"))));
		
		add(sup,BorderLayout.CENTER);
		add(inf,BorderLayout.SOUTH);
		
	}

}
