package crud;

import java.time.LocalDateTime;

import crud.controller.MainViewController;
import crud.controller.otkaziTrening.OtkazivanjeTreningaController;
import crud.controller.uvidUTreningIOdabir.UvidUTreningeIOdabirController;
import crud.model.*;
import crud.model.db.Baza;
import crud.view.MainView;
import crud.view.OtkazivanjeTreningaView;
import crud.view.UvidUTreningeIOdabirView;

public class Aplikacija {

	//Clan koji je trenutno ulogovan (jer ne modelujemo login)
	private static Clan trenutniClan;
	private static Baza baza = new Baza();
	public static void main(String[] args) {
		
		databaseSeed();
		
		//Test za proveru da li radi
//		baza.ispisClanovi();
//		baza.ispisTreninzi();
		
		//TODO: Ovde inicijalizovati kontrolere i view-ove i proslediti im odgovarajuce dependecy-e
		
		OtkazivanjeTreningaView otkazView = new OtkazivanjeTreningaView();
		UvidUTreningeIOdabirView uvidView = new UvidUTreningeIOdabirView();
		MainView mv = new MainView();
		
		OtkazivanjeTreningaController otkazController = new OtkazivanjeTreningaController(baza, trenutniClan, otkazView);
		UvidUTreningeIOdabirController uvidController = new UvidUTreningeIOdabirController(uvidView, trenutniClan, baza);
		MainViewController mvc = new MainViewController(uvidController, otkazController, mv);
		
		mvc.start();
	}
	
	public Clan getTrenutniClan() {
		return trenutniClan;
	}

	//Rucno popunjavanje baze podataka sa testnim podacima
	private static void databaseSeed() { 
		Clan anja = baza.createClan("anja.andjelkovic@gmail.com", "0661234567", Pol.ZENSKO);
		Clan nikolaM = baza.createClan("nikola.milasinovic@gmail.com", "0661234568", Pol.MUSKO);
		Clan nikolaB = baza.createClan("nikola.baric@gmail.com", "0661234569", Pol.MUSKO);
		Clan jovan = baza.createClan("jovan.stoiljkovic@gmail.com", "0661234560", Pol.MUSKO);

		trenutniClan = anja;
		
		Trening t1 = baza.createTrening(LocalDateTime.of(2025, 6, 10, 17, 0), "Mirko", 10);
		t1.dodajClana(nikolaM);
		t1.dodajClana(nikolaB);
		Trening t2 = baza.createTrening(LocalDateTime.of(2025, 6, 10, 18, 0), "Mirko", 5);
		t2.dodajClana(jovan);
		Trening t3 = baza.createTrening(LocalDateTime.of(2025, 6, 11, 17, 0), "Teodora", 1);
		t2.dodajClana(anja);
		Trening t4 = baza.createTrening(LocalDateTime.of(2025, 6, 11, 17, 0), "Mirko", 10);
		Trening t5 = baza.createTrening(LocalDateTime.of(2025, 6, 11, 18, 0), "Sara", 1);
		t5.dodajClana(nikolaM);
		Trening t6 = baza.createTrening(LocalDateTime.of(2025, 6, 12, 18, 0), "Sara", 10);
		t6.dodajClana(anja);
		t6.dodajClana(nikolaM);
		t6.dodajClana(nikolaB);
		t6.dodajClana(jovan);
	}

}
