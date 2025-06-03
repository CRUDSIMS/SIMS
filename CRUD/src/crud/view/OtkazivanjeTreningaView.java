package crud.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import crud.model.Trening;
import crud.model.tableModels.TreningTableModel;

public class OtkazivanjeTreningaView extends JFrame{

	private static final long serialVersionUID = 4644739079421383938L;

	private TreningTableModel treningTableModel = new TreningTableModel();
	private JTable tabelaTreninga = new JTable(treningTableModel);
	private JButton otkaziTreningDugme = new JButton("Otkazi");


	
	 public void init() {
	        this.setTitle("Otkazivanje treninga");
	        this.setLayout(new BorderLayout());
	        this.add(new JScrollPane(tabelaTreninga), BorderLayout.CENTER);
	        this.add(otkaziTreningDugme, BorderLayout.SOUTH);
	        this.setSize(800, 600);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
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
}
 