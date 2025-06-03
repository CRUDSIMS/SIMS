package crud.model.tableModels;

import crud.model.Trening;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TreningTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 3600355342415534537L;

	private ArrayList<Trening> treninzi = new ArrayList<Trening>();
	

	public TreningTableModel() {
		super();
	}

	public void setTreninzi(ArrayList<Trening> treninzi) {
		this.treninzi = treninzi;
		this.fireTableDataChanged();
	}
	
	public void addTrening(Trening t) {
		treninzi.add(t);
		this.fireTableDataChanged();
	}
	public Trening getTrening(int index) {
		return treninzi.get(index);
	}
	public void removeTrening(int index) {
		treninzi.remove(index);
		this.fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return treninzi.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override 
	public String getColumnName(int column) {
		if(column == 0) return "Datum i vreme treninga";
		if(column == 1) return "Trener";
		if(column == 2) return "Ukupno mesta";
		
		return "";
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Trening t = treninzi.get(rowIndex);
		
		if(columnIndex == 0) return t.getVremeTreninga();
		if(columnIndex == 1) return t.getTrener();
		if(columnIndex == 2) return t.getBrojSlobodnihMesta();
	
		return null;
	}

}
