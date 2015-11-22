package businesslogic;

import businesslogic.facility.DriverController;
import businesslogic.facility.FacilityController;
import businesslogic.userbl.UserController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
	
	public static DriverController getDriverController(){
		return new DriverController();
	}

	public static UserController getUserController() {
		return new UserController();
	}
}
