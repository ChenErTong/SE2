package businesslogic;

import businesslogic.facilitybl.DriverController;
import businesslogic.facilitybl.FacilityController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
	
	public static DriverController getDriverController(){
		return new DriverController();
	}
}
