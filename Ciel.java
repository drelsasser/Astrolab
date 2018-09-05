/**
 *	La classe Ciel permet d'afficher des planètes, étoiles et galaxies dans une fenêtre
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Ciel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Tableau permettant de représenter les 8 planètes du Système solaire,
	 * Pluton étant une planète naine.
	 */
	Planete planete[] = new Planete[8];
	
	Dimension m_dimension = new Dimension();	// Taille du ciel
	Point m_centre = new Point();
	
	public Ciel()
	{
		this.m_dimension.setSize(800, 600);
		this.initialisation();
	}
	
	public Ciel(Dimension d)
	{
		this.m_dimension.setSize(d);
		this.initialisation();
	}
	
	private void initialisation()
	{
		this.m_centre.setLocation(this.m_dimension.width/2, this.m_dimension.height/2);
		
		planete[0] = new Planete("Mercure",	57909175l,	69817079l,	46001272l,	4878,	0.054f,	3.302f,	23,	58.6462f,	87.97f,		this.m_centre);
		planete[1] = new Planete("Venus",	108208930l,	108942109l,	107476259l,	12250,	0.88f,	4.8685f,24,	-243.0185f,	224.7f,		this.m_centre);
		planete[3] = new Planete("Mars",	227936640l,	249228730l,	206644545l,	6828,	0.149f,	6.4185f,23,	1.026f,		686.96f,	this.m_centre);
		planete[4] = new Planete("Jupiter",	778412010l,	816620000l,	740520000l,	142000,	1316f,	1.8986f,27,	0.41351f,	4335.35f,	this.m_centre);
		planete[5] = new Planete("Saturne",	1426725400l,1503983449l,1349467375l,107200,	755f,	5.6846f,26,	0.444f,		10757.74f,	this.m_centre);
		planete[6] = new Planete("Uranus",	2870972200l,3004419704l,2748938461l,49260,	52f,	8.6832f,25,	-0.718f,	30708.16f,	this.m_centre);
		planete[7] = new Planete("Neptune",	4498252900l,4536874325l,4459631496l,44600,	44f,	1.0243f,26,	0.67125f,	60224.90f,	this.m_centre);
		planete[2] = new Planete();	// la Terre.
		planete[2].setM_centre(this.m_centre);	// Centre
		
		this.setBackground(Color.BLACK);
		this.setSize(m_dimension);
		this.repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.m_dimension.width, this.m_dimension.height);
		
		g.setColor(Color.BLUE);
		for(Planete p : planete)
		{
			p.actualisePosition();
			g.fillOval(p.getM_point().x-5, p.getM_point().y-5, 10, 10);
			g.drawOval(this.m_centre.x-p.orbite().x, this.m_centre.y-p.orbite().y, p.orbite().x*2, p.orbite().y*2);
		}
	}
}
