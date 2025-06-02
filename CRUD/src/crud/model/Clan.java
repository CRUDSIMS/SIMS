package crud.model;

public class Clan extends Korisnik{
	private boolean primioPodsetnik;

	public Clan() {
		super();
	}

	public Clan(String email, String brojTelefona, Pol pol) {
		super(email, brojTelefona, pol);
		this.primioPodsetnik = false;
	}

	public Clan(String email, String brojTelefona, Pol pol, boolean primioPodsetnik) {
		super(email, brojTelefona, pol);
		this.primioPodsetnik = primioPodsetnik;
	}

	public boolean isPrimioPodsetnik() {
		return primioPodsetnik;
	}

	public void setPrimioPodsetnik(boolean primioPodsetnik) {
		this.primioPodsetnik = primioPodsetnik;
	}
	
	@Override
	public String toString() {
		return "Korisnik [email=" + this.getEmail() + ", brojTelefona=" + this.getBrojTelefona() + ", pol=" + this.getPol() + "]";
	}
	
	
}
