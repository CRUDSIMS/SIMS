package crud.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import crud.model.Trening;
import crud.model.tableModels.TreningTableModel;

public class OtkazivanjeTreningaView extends JFrame{

	private static final long serialVersionUID = 4644739079421383938L;

	private TreningTableModel treningTableModel = new TreningTableModel();
	private JTable tabelaTreninga = new JTable(treningTableModel);
	private JButton otkaziTreningDugme = new JButton("Otkazi");
	private JButton backDugme = new JButton("Povratak na glavni meni");
	private JToolBar toolbar = new JToolBar();


	
	 public void init() {
	        this.setTitle("Otkazivanje treninga");
	        this.setLayout(new BorderLayout());
	        
	        this.toolbar.add(backDugme);
	        this.add(this.toolbar, BorderLayout.NORTH);
	        
	        this.add(new JScrollPane(tabelaTreninga), BorderLayout.CENTER);
	        this.add(otkaziTreningDugme, BorderLayout.SOUTH);
	        this.setSize(800, 600);      

	    }

	public void start() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	public void stop() {
		this.setVisible(false);
	}
	public void prikaziPoruku(String poruka) {
		JOptionPane.showMessageDialog(this, poruka);
	}
	public void prikaziTreninge(ArrayList<Trening> treninzi) {
		treningTableModel.setTreninzi(treninzi);
	}
	public void setOtkaziTreningListener(ActionListener al) {
		otkaziTreningDugme.addActionListener(al);
	}
	public Trening getSelektovanTrening(){
		int row = tabelaTreninga.getSelectedRow();
		if(row < 0) return null;

		return treningTableModel.getTrening(row);
	}
	public void setBackDugmeListener(ActionListener al) {
		this.backDugme.addActionListener(al);
	}
}
 