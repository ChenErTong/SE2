package businesslogic;

import businesslogic.facilitybl.DriverController;
import businesslogic.facilitybl.FacilityController;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.userbl.UserController;

public class ControllerFactory {
	public static FacilityController getFacilityController(){
		return new FacilityController();
	}
	
	public static DriverController getDriverController(){
		return new DriverController();
	}
	public static UserController getUserController(){
		return new UserController();
	}
	public static OrganizationController getOrganizationController(){
		return new OrganizationController();
	}
}
