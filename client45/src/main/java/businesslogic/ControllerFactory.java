package businesslogic;

import businesslogic.facility.FacilityController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
}
