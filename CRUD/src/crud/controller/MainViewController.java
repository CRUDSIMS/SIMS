package crud.controller;

import crud.controller.otkaziTrening.OtkazivanjeTreningaController;
import crud.controller.uvidUTreningIOdabir.UvidUTreningeIOdabirController;
import crud.view.MainView;

public class MainViewController {
	private MainView mainView;
	
	private UvidUTreningeIOdabirController uvidController;
	private OtkazivanjeTreningaController otkazivanjeController;

	
	public MainViewController(UvidUTreningeIOdabirController uvidController,
			OtkazivanjeTreningaController otkazivanjeController, 
			MainView mainView) {
		this.uvidController = uvidController;
		this.otkazivanjeController = otkazivanjeController;
		this.mainView = mainView;
		
		this.mainView.init();
		
		this.mainView.addActionListenerMojiTreninzi (e -> otvoriOtkazivanje());
		this.mainView.addActionListenerTreninzi(e -> otvoriUvidUTreningeIOdabir());
		
		this.uvidController.setBackDugme(e -> zatvoriUvidUTreningeIOdabir());
		this.otkazivanjeController.setBackDugme(e -> zatvoriOtkazivanje());
	}
		
	 public void otvoriUvidUTreningeIOdabir() {
	     	this.mainView.stop();
	     	this.uvidController.start();
	    }
	 public void zatvoriUvidUTreningeIOdabir() {
	     	this.uvidController.stop();
	     	this.mainView.start();
	 }
	 public void otvoriOtkazivanje() {
	        this.mainView.stop();
	        this.otkazivanjeController.start();
	    }
	 
	 public void zatvoriOtkazivanje() {
		 this.otkazivanjeController.stop();
		 this.mainView.start();
	 }
	 
	 public void start() {
		 this.mainView.start();
	 }
}
