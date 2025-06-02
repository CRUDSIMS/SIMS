package crud.model.db;

import java.time.LocalDateTime;
import java.util.ArrayList;

import crud.model.*;

//Mock baze podataka

public class Baza {
	private ArrayList<Clan> clanovi = new ArrayList<Clan>();
	private ArrayList<Trening> treninzi = new ArrayList<Trening>();
	
	//Clanovi CRUD
	public Clan createClan(String email, String brojTelefona, Pol pol) {
		Clan noviClan = new Clan(email, brojTelefona, pol);
		clanovi.add(noviClan);
		
		return noviClan;
	}
	public Clan readClan(long ID) {
		
		for(Clan clan : clanovi) {
			if(clan.getID() == ID) return clan;
		}
		
		return null;
	}
	public ArrayList<Clan> readAllClan() {
		return clanovi;
	}
	public Clan updateClan(long ID, String email, String brojTelefona, Pol pol) {
		for(Clan clan : clanovi) {
			if(clan.getID() == ID) {
				clan.setEmail(email);
				clan.setBrojTelefona(brojTelefona);
				clan.setPol(pol);
				
				return clan;
			}
		}
		
		return null;
	}
	public void deleteClan(long ID) {
		for(Clan clan : clanovi) {
			if(clan.getID() == ID) {
				clanovi.remove(clan);
				break;
			}
		}
		
		return;
	}
	
	//Treninzi CRUD
	public Trening createTrening(LocalDateTime vremeTreninga, String trener, int ukupnoMesta) {
		Trening noviTrening = new Trening(vremeTreninga, trener, ukupnoMesta);
		treninzi.add(noviTrening);
		
		return noviTrening;
	}
	public Trening readTrening(long ID) {
		for(Trening trening : treninzi) {
			if (trening.getID() == ID) {
				return trening;
			}
		}
		
		return null;
	}
	public ArrayList<Trening> readAllTrening() {
		return treninzi;
	}
	public Trening updateTrening(long ID, LocalDateTime vremeTreninga, String trener, int ukupnoMesta) {
		for(Trening trening : treninzi) {
			if(trening.getID() == ID) {
				trening.setVremeTreninga(vremeTreninga);
				trening.setTrener(trener);
				trening.setUkupnoMesta(ukupnoMesta);
				return trening;
			}
		}
		return null;
	}
	public void deleteTrening(long ID) {
		for(Trening trening : treninzi) {
			if(trening.getID() == ID) {
				treninzi.remove(trening);
				break;
			}
		}
		return;
	}
	
	//Metode za ispis
	public void ispisTreninzi() {
		for(Trening trening : treninzi) {
			System.out.println(trening);
		}
	}
	public void ispisClanovi() {
		for(Clan clan : clanovi) {
			System.out.println(clan);
		}
	}
	
}
