package crud.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;

import crud.model.Trening;
import crud.model.tableModels.TreningTableModel;

public class UvidUTreningeIOdabirView extends JFrame {

    private static final long serialVersionUID = 1L;

    private TreningTableModel treningTableModel = new TreningTableModel();
    private JTable tabelaTreninga = new JTable(treningTableModel);
    private JButton ZakaziTrening = new JButton("Zakazi Trening");
    private JButton backDugme = new JButton("Povratak na glavni meni");
    private JToolBar toolbar = new JToolBar();

    public void init() {
    	
        this.setTitle("Uvid i odabir treninga");
        this.setLayout(new BorderLayout());
        
        toolbar.add(backDugme);
        this.add(toolbar, BorderLayout.NORTH);
        this.add(new JScrollPane(tabelaTreninga), BorderLayout.CENTER);
        this.add(ZakaziTrening, BorderLayout.SOUTH);
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

    public void setOdaberiTreningListener(ActionListener al) {
        ZakaziTrening.addActionListener(al);
    }
    public void setBackDugmeListener(ActionListener al) {
    	backDugme.addActionListener(al);
    }

    public Trening getSelektovanTrening() {
        int red = tabelaTreninga.getSelectedRow();
        if (red < 0) return null;
        return treningTableModel.getTrening(red);
    }
}

