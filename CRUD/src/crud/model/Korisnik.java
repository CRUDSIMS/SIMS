package crud.model;

public abstract class Korisnik extends Identifiable{
	private String email;
	private String brojTelefona;
	private Pol pol;
	

	public Korisnik() {
		super();
	}
	public Korisnik(String email, String brojTelefona, Pol pol) {
		super();
		this.email = email;
		this.brojTelefona = brojTelefona;
		this.pol = pol;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
		this.pol = pol;
	}
	@Override
	public String toString() {
		return "Korisnik [email=" + email + ", brojTelefona=" + brojTelefona + ", pol=" + pol + "]";
	}
	
}
