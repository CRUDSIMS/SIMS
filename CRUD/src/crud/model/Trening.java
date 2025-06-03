package crud.model;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Trening extends Identifiable {
	private LocalDateTime vremeTreninga;
	private String trener;
	private int ukupnoMesta;
	private ArrayList<Clan> spisakClanova = new ArrayList<Clan>();
	
	public Trening() {
		super();
	}
	public Trening(LocalDateTime vremeTreninga, String trener, int ukupnoMesta) {
		super();
		this.vremeTreninga = vremeTreninga;
		this.trener = trener;
		this.ukupnoMesta = ukupnoMesta;
	}
	
	public LocalDateTime getVremeTreninga() {
		return vremeTreninga;
	}
	public void setVremeTreninga(LocalDateTime vremeTreninga) {
		this.vremeTreninga = vremeTreninga;
	}
	public String getTrener() {
		return trener;
	}
	public void setTrener(String trener) {
		this.trener = trener;
	}
	
	public int getUkupnoMesta() {
		return ukupnoMesta;
	}
	public void setUkupnoMesta(int brojSlobodnihMesta) {
		this.ukupnoMesta = brojSlobodnihMesta;
	}
	public int getBrojSlobodnihMesta() {
		return this.ukupnoMesta - this.spisakClanova.size();
	}
	
	public void dodajClana(Clan clan) {
		if(this.getBrojSlobodnihMesta() > 0) {
			this.spisakClanova.add(clan);
		}
	}
	public void ukloniClana(Clan clan) {
		this.spisakClanova.remove(clan);
	}
	
	public boolean postojiClan(Clan clan) {
		for (Clan c : this.spisakClanova) {
			if (clan.getID() == c.getID()) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Trening [vremeTreninga=" + vremeTreninga + ", trener=" + trener + ", ukupnoMesta=" + ukupnoMesta
				+ ", spisakClanova=" + spisakClanova + "]";
	}
	
	
	
}
