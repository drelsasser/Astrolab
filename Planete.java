/**
 * La classe Planete permet de créer et de gérer une planète d'un système planétaire
 */

import java.awt.Dimension;
import java.awt.Point;

public class Planete
{
	private String		m_nom			= new String("");	// Nom de la planète
	private long		m_moyen			= 0l;				// Distance moyenne de la planète par rapport à son étoile
	private long		m_aphelie		= 0l;				// Aphélie de la planète
	private long		m_periphelie	= 0l;				// Périphélie de la planète
	private int			m_diametre		= 0;				// Diamètre équatorien de la planète
	private float		m_volume		= 0.0f;				// Volume de la planète
	private float		m_masseBase		= 0.0f;				// Base de la masse de la planète (à multiplier par l'éxposant)
	private int			m_masseExp		= 0;				// Exposant (puissance de 10) pour calculer la masse de la planète
	private float		m_rotation		= 0.0f;				// Période de rotation de la planète en jour sidérale (période de 24h)
	private float		m_revolution	= 0.0f;				// Période de révolution de la planète autour de son étoile
	private boolean		m_posRelle		= true;				// Pour savoir si il faut afficher la position réelle ou relative de la planète

	private Point		m_point			= new Point();		// Centre de la planète
	private Point		m_centre		= new Point();		// Indique la position du centre de l'écran
	private float		m_delataAngle	= 0.0f;				// Déplacement de la planète par jour autour de son étoile
	private float		m_anlge			= 0.0f;				// Angle poour le calcul de la position de la planète
	private long		m_echelle		= 0l;				// Permet de determiner une distance par rapport au foyer

	public Planete()
	{
		this.m_nom			= "Terre";
		this.m_moyen		= 149597890l;
		this.m_aphelie		= 152097701l;
		this.m_periphelie	= 147098074l;
		this.m_diametre		= 12756;
		this.m_volume		= 1.0f;
		this.m_masseBase	= 5.9736f;
		this.m_masseExp		= 24;
		this.m_rotation		= 0.9973f;
		this.m_revolution	= 365.26f;
		
		this.m_centre.setLocation(400, 300);
		
		this.initialisation();
	}
	
	public Planete(String nom, long moy, long aph, long per, int dia, float vol, float base, int exp, float rot, float rev, Point pnt)
	{
		this.m_nom			= nom;
		this.m_moyen		= moy;
		this.m_aphelie		= aph;
		this.m_periphelie	= per;
		this.m_diametre		= dia;
		this.m_volume		= vol;
		this.m_masseBase	= base;
		this.m_masseExp		= exp;
		this.m_rotation		= rot;
		this.m_revolution	= rev;
		
		this.m_centre.setLocation(pnt);
		
		this.initialisation();
	}

	private void initialisation()
	{
		this.m_echelle = 1000000;
		this.m_delataAngle = (float)(2*Math.PI/this.m_revolution);
	}
	
	public void actualisePosition()
	{
		if(this.m_posRelle==true)
		{
			this.m_point.setLocation(
				(int)(Math.cos(m_anlge)*(int)(this.m_aphelie/this.m_echelle)+this.m_centre.x),
				(int)(Math.sin(m_anlge)*(int)(this.m_periphelie/this.m_echelle)+this.m_centre.y));
		}
		else
		{
			this.m_point.setLocation(
				(int)(Math.cos(m_anlge)*(int)(this.m_moyen/this.m_echelle)+this.m_centre.x),
				(int)(Math.sin(m_anlge)*(int)(this.m_moyen/this.m_echelle)+this.m_centre.y));
		}
		
		this.m_anlge += this.m_delataAngle;
	}
	
	public Point orbite()
	{
		Point p = new Point();
		
		if(this.m_posRelle==true)
		{
			p.setLocation(
				(int)((this.m_aphelie/this.m_echelle)/2),
				(int)((this.m_periphelie/this.m_echelle)/2));
		}
		else
		{
			p.setLocation(
				(int)((this.m_moyen/this.m_echelle)/2),
				(int)((this.m_moyen/this.m_echelle)/2));
		}
		
		return p;
	}
	
	/**
	 * Accesseurs et mutateurs
	 */
	public String getM_nom()
	{
		return m_nom;
	}

	public void setM_nom(String m_nom)
	{
		this.m_nom = m_nom;
	}

	public long getM_moyen()
	{
		return m_moyen;
	}

	public void setM_moyen(long m_moyen)
	{
		this.m_moyen = m_moyen;
	}

	public long getM_aphelie()
	{
		return (long)(((m_aphelie/this.m_echelle)/2)-this.m_centre.x);
	}

	public void setM_aphlie(long m_aphelie)
	{
		this.m_aphelie = m_aphelie;
	}

	public long getM_periphelie()
	{
		return (long)(((m_periphelie/this.m_echelle)/2)-this.m_centre.y);
	}

	public void setM_periphelie(long m_periphelie)
	{
		this.m_periphelie = m_periphelie;
	}

	public int getM_diametre()
	{
		return m_diametre;
	}

	public void setM_diametre(int m_diametre)
	{
		this.m_diametre = m_diametre;
	}

	public float getM_volume()
	{
		return m_volume;
	}

	public void setM_volume(float m_volume)
	{
		this.m_volume = m_volume;
	}

	public float getM_masseBase()
	{
		return m_masseBase;
	}

	public void setM_masseBase(float m_masseBase)
	{
		this.m_masseBase = m_masseBase;
	}

	public int getM_masseExp()
	{
		return m_masseExp;
	}

	public void setM_masseExp(int m_masseExp)
	{
		this.m_masseExp = m_masseExp;
	}

	public float getM_rotation()
	{
		return m_rotation;
	}

	public void setM_rotation(float m_rotation)
	{
		this.m_rotation = m_rotation;
	}

	public float getM_revolution()
	{
		return m_revolution;
	}

	public void setM_revolution(float m_revolution)
	{
		this.m_revolution = m_revolution;
	}

	public boolean isM_posRelle()
	{
		return m_posRelle;
	}
	
	public void setM_posRelle(boolean m_posRelle)
	{
		this.m_posRelle = m_posRelle;
	}

	public float getM_delataAngle()
	{
		return m_delataAngle;
	}

	public void setM_delataAngle(float m_delataAngle)
	{
		this.m_delataAngle = m_delataAngle;
	}

	public float getM_anlge()
	{
		return m_anlge;
	}

	public void setM_anlge(float m_anlge)
	{
		this.m_anlge = m_anlge;
	}

	public long getM_echelle()
	{
		return m_echelle;
	}

	public void setM_echelle(long m_echelle)
	{
		this.m_echelle = m_echelle;
	}

	public Point getM_point()
	{
		return m_point;
	}

	public void setM_point(Point m_point)
	{
		this.m_point = m_point;
	}

	public Point getM_centre()
	{
		return m_centre;
	}

	public void setM_centre(Point m_centre)
	{
		this.m_centre = m_centre;
	}
}
