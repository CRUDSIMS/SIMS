package crud.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1859576488598457634L;
	
	private JPanel dugmeKontejner;
	private JButton mojiTreninziDugme = new JButton("Moji Treninzi");
	private JButton treninziDugme = new JButton("Treninzi");
	
	
	public MainView() throws HeadlessException {
		super();
	}

	public void init() {
		
		dugmeKontejner = new JPanel();
		
		dugmeKontejner.add(mojiTreninziDugme);
		dugmeKontejner.add(treninziDugme);
				
		this.getContentPane().add(dugmeKontejner, BorderLayout.CENTER);
		
		this.setSize(300, 100);
		this.setTitle("Aplikacija");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void start() {
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void stop() {
		this.setVisible(false);
	}
	public void addActionListenerMojiTreninzi(ActionListener al) {
		this.mojiTreninziDugme.addActionListener(al);
	}
	public void addActionListenerTreninzi(ActionListener al) {
		this.treninziDugme.addActionListener(al);
	}
}
