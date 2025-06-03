package crud.controller.otkaziTrening;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import crud.model.Clan;
import crud.model.Trening;
import crud.model.db.Baza;
import crud.view.OtkazivanjeTreningaView;

public class OtkazivanjeTreningaController {
	private OtkazivanjeTreningaView treningView;
	private Baza baza;
	private Clan clan;
	
	public ArrayList<Trening> getTreninzi() {
		ArrayList<Trening> sviTreninzi = baza.readAllTrening();
		ArrayList<Trening> naredniTreninzi = new ArrayList<>();
		
		LocalDateTime trenutnoVreme = LocalDateTime.now();
		LocalDateTime maxVreme = trenutnoVreme.plusDays(10);
		
		for (Trening t : sviTreninzi) {
			if (t.getVremeTreninga().isAfter(trenutnoVreme) && t.getVremeTreninga().isBefore(maxVreme) && t.postojiClan(clan))
				naredniTreninzi.add(t);
		}
		
		return naredniTreninzi;
	}
	

	
	public void obrisiTrening(Trening trening) {
		baza.deleteTrening(trening.getID());
	}
	
	public OtkazivanjeTreningaController(Baza baza, Clan clan, OtkazivanjeTreningaView treningView) {
		this.baza = baza;
		this.clan = clan;
		this.treningView= treningView;
		
		treningView.setOtkaziTreningListener(e -> otkaziTrening());
		
	}
	
	public void start() {
		this.prikaziTreninge();
		treningView.init();
	}
	
	private void prikaziTreninge() {
		ArrayList<Trening> treninzi = this.getTreninzi();
		treningView.prikaziTreninge(treninzi);
	}
	
	private void otkaziTrening() {
		Trening selektovanTrening = treningView.getSelektovanTrening();
		
		if(selektovanTrening == null) {
			treningView.prikaziPoruku("Niste izabrali trening.");
			return;
		}
		
		if(!nijeMoguce(selektovanTrening)) {
			treningView.prikaziPoruku("Ima manje od 24h do treninga.");
			return;
		}
		
		if (selektovanTrening.getUkupnoMesta() > 1) {
			selektovanTrening.ukloniClana(clan);
		} else {
			this.obrisiTrening(selektovanTrening);
		}
		
		treningView.prikaziPoruku("Trening uspesno otkazan.");
	}
	
	private boolean nijeMoguce(Trening trening) {
		LocalDateTime trenutnoVreme = LocalDateTime.now();
		Duration trajanje = Duration.between(trenutnoVreme, trening.getVremeTreninga());
		return trajanje.toHours() > 24;
	}
}
