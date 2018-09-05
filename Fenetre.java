import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Fenetre extends JFrame
{
	private static final long serialVersionUID = 1L;

	private BorderLayout layout	= new BorderLayout();
	private Ciel ciel			= new Ciel(new Dimension(1280, 800));
	
	public Fenetre()
	{
		this.setTitle("Astrolab");
		this.setSize(1280, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.initialisation();
		
		this.setVisible(true);
	}
	
	private void initialisation()
	{
		this.setLayout(layout);
		this.getContentPane().add(ciel, BorderLayout.CENTER);
	}
}
