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
		
		this.mainView.addActionListenerMojiTreninzi (e -> otvoriOtkazivanje());
		this.mainView.addActionListenerTreninzi(e -> otvoriUvidUTreningeIOdabir());
	}
		
	 public void otvoriUvidUTreningeIOdabir() {
	     	this.mainView.dispose();
	     	this.uvidController.start();
	    }

	 public void otvoriOtkazivanje() {
	        this.mainView.dispose();
	        this.otkazivanjeController.start();
	    }
	 
	 public void start() {
		 mainView.init();
	 }
}
