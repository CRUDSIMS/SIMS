package crud.model;

import java.util.UUID;

//Klasa koja implementira generisanje nasumicnog unikatnog ID-a
public class Identifiable {
	private long ID;

	public Identifiable() {
		this.ID = UUID.randomUUID().getLeastSignificantBits();
	}
	 
	public long getID() {
		return ID;
	}
}
