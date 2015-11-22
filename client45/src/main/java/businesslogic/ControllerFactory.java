package businesslogic;

import businesslogic.facility.DriverController;
import businesslogic.facility.FacilityController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
	
	public static DriverController getDriverController(){
		return new DriverController();
	}
}
