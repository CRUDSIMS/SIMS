package crud.controller.uvidUTreningIOdabir;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import crud.model.Clan;
import crud.model.Trening;
import crud.model.db.Baza;

public class UvidUTreningeIOdabirController {
	private UvidUTreningeIOdabirView view;
	private Clan clan;
	private Baza baza;
	
	public UvidUTreningeIOdabirController (UvidUTreningeIOdabirView view, Clan clan, Baza baza) {
        this.view = view;
        this.clan = clan;
        this.baza = baza;

        prikaziTreninge();
    }
	
	private void prikaziTreninge() {
		ArrayList<Trening> treninzi = this.getTreninzi();
		view.prikaziTreninge(treninzi);
	}
	
	public ArrayList<Trening> getTreninzi() {
		ArrayList<Trening> sviTreninzi = baza.readAllTrening();
		ArrayList<Trening> naredniTreninzi = new ArrayList<>();
		
		LocalDateTime trenutnoVreme = LocalDateTime.now();
		LocalDateTime maxVreme = trenutnoVreme.plusDays(10);
		
		for (Trening t : sviTreninzi) {
			if (t.getVremeTreninga().isAfter(trenutnoVreme) && t.getVremeTreninga().isBefore(maxVreme))
				naredniTreninzi.add(t);
		}
		
		return naredniTreninzi;
	}
	
	public void start() {
		this.prikaziTreninge();
		view.init();
	}
	
	public boolean rezervisiTrening(Trening trening) {
		Trening selektovanTrening = view.getSelektovanTrening();
		
        if (trening.getBrojSlobodnihMesta() <= 0) {
        	view.prikaziPoruku("Nema slobodnih mesta.");
			return false;
        }

        if (trening.postojiClan(clan)) {
        	view.prikaziPoruku("Vec ste prijavljeni na taj trening.");
            return false;
        }

        trening.dodajClana(clan);
        view.prikaziPoruku("Uspesno ste rezervisali.");
        return true;
    }
	

}
