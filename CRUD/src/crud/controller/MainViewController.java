package crud.controller;

import crud.controller.otkaziTrening.OtkazivanjeTreningaController;
import crud.controller.uvidUTreningIOdabir.UvidUTreningeIOdabirController;

public class MainViewController {
	private MainView mainView;
	
	private UvidUTreningeIOdabirController uvidController;
	private OtkazivanjeTreningaController otkazivanjeController;

	
	public MainViewController(UvidUTreningeIOdabirController uvidController,
			OtkazivanjeTreningaController otkazivanjeController) {
		this.uvidController = uvidController;
		this.otkazivanjeController = otkazivanjeController;
		this.mainView = mainView;
		
		this.mainView.addActionListenerMojiTreninzi (e -> otvoriOtkazivanje());
	}
		
	 public void otvoriUvidUTreningeIOdabir() {
	     	mainView.dispose()
	     	this.uvidController.start();
	    }

	 public void otvoriOtkazivanje() {
	        mainView.dispose();
	        this.otkazivanjeController.start();
	    }
	 
	 public void start() {
		 mainView.init();
	 }
}
