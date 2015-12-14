package init;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.ControllerFactory;
import businesslogic.accountbl.AccountController;
import businesslogic.basebl.BaseController;
import businesslogic.facilitybl.DriverController;
import businesslogic.facilitybl.FacilityController;
import businesslogic.organizationbl.OrganizationController;
import businesslogic.userbl.UserController;
import state.OrganizationType;
import state.UserAuthority;
import state.UserIdentity;
import util.GetDate;
import vo.BaseVO;
import vo.BranchVO;
import vo.FacilityVO;
import vo.TransferVO;
import vo.UserVO;
import vo.accountvo.AccountVO;
import vo.accountvo.DriverVO;

public class InitDatas {
	public static void main(String[] args) {
//		initUser();
//		initOrganization();
//		initBase();
		try {
			initAccountInTransfer(ControllerFactory.getAccountController());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void initBase() {
		try {
			BaseController baseController = ControllerFactory.getBaseController();
			baseController.addBase(new BaseVO(baseController.getID(), "北京市", "上海市", new BigDecimal("1064.7"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "上海市", "北京市", new BigDecimal("1064.7"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "北京市", "广州市", new BigDecimal("1888.8"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "广州市", "北京市", new BigDecimal("1888.8"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "北京市", "南京市", new BigDecimal("900"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "南京市", "北京市", new BigDecimal("900"), new BigDecimal(23)));
			
			baseController.addBase(new BaseVO(baseController.getID(), "广州市", "上海市", new BigDecimal("1213"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "上海市", "广州市", new BigDecimal("1213"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "上海市", "南京市", new BigDecimal("266"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "南京市", "上海市", new BigDecimal("266"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "广州市", "南京市", new BigDecimal("1132"), new BigDecimal(23)));
			baseController.addBase(new BaseVO(baseController.getID(), "南京市", "广州市", new BigDecimal("1132"), new BigDecimal(23)));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void initUser() {
		try {
			UserController userController = ControllerFactory.getUserController();
			String ID=userController.getID();
			userController.addUser(new UserVO(ID, ID, "管理员", "", UserIdentity.ADMIN, UserAuthority.HIGHESTLEVEL, ""));
			ID = userController.getID();
			userController.addUser(new UserVO(ID, ID, "总经理1", "", UserIdentity.GENERAL_MANAGER, UserAuthority.MANAGER_LEVEL, ""));
			ID = userController.getID();
			userController.addUser(new UserVO(ID, ID, "总经理2", "", UserIdentity.GENERAL_MANAGER, UserAuthority.MANAGER_LEVEL, ""));
			ID = userController.getID();
			userController.addUser(new UserVO(ID, ID, "财务人员l", "", UserIdentity.FINANCE_MANAGER, UserAuthority.COMMONLEVEL, ""));
			ID = userController.getID();
			userController.addUser(new UserVO(ID, ID, "财务人员h", "", UserIdentity.FINANCE_MANAGER, UserAuthority.ADVANCE_FINANCE, ""));
			for (int i = 0; i < 4*2; i++) {
				ID = userController.getID();
				userController.addUser(new UserVO(ID, ID, "仓库管理"+ID, "", UserIdentity.INVENTORY_MANAGER, UserAuthority.COMMONLEVEL, ""));
			}
			System.out.println(1);
			for (int i = 0; i < 4*15; i++) {
				ID = userController.getID();
				userController.addUser(new UserVO(ID, ID, "中转中心业务员"+ID, "", UserIdentity.TRANSFER_CONTERMAN, UserAuthority.COMMONLEVEL, ""));
			}
			System.out.println(1);
			for (int i = 0; i < 65*5; i++) {
				ID = userController.getID();
				userController.addUser(new UserVO(ID, ID, "营业厅业务员"+ID, "", UserIdentity.BRANCH_COUNTERMAN, UserAuthority.COMMONLEVEL, ""));
			}
			System.out.println(1);
			for (int i = 0; i < 65*50; i++) {
				ID = userController.getID();
				userController.addUser(new UserVO(ID, ID, "快递员"+ID, "", UserIdentity.COURIER, UserAuthority.COMMONLEVEL, ""));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void initOrganization() {
		try {
			OrganizationController organizationController = ControllerFactory.getOrganizationController();
			AccountController accountController =ControllerFactory.getAccountController();
			FacilityController facilityController = ControllerFactory.getFacilityController();
			DriverController driverController = ControllerFactory.getDriverController();
			organizationController.addTransfer(new TransferVO(organizationController.getTransferID("北京市"), "北京市北京市朝阳区霄云路", OrganizationType.TRANSFER));
			organizationController.addTransfer(new TransferVO(organizationController.getTransferID("上海市"), "上海市上海市浦东新区德堡路", OrganizationType.TRANSFER));
			organizationController.addTransfer(new TransferVO(organizationController.getTransferID("广州市"), "广东省广州市越秀区连新路", OrganizationType.TRANSFER));
			organizationController.addTransfer(new TransferVO(organizationController.getTransferID("南京市"), "江苏省南京市雨花台区软件大道", OrganizationType.TRANSFER));
//			initAccountInTransfer(accountController);
			for (int i = 0; i < 20; i++) {
				String branchID = organizationController.getBranchID("北京市");
				organizationController.addBranch(new BranchVO(branchID, "北京市北京市朝阳区新源南路"+(i+17)+"号", OrganizationType.BRANCH));
				initAccountInBranch(accountController, branchID);
				initDriverAndCar(facilityController, driverController, branchID);
				System.out.println(1);
			}
			for (int i = 0; i < 20; i++) {
				String branchID = organizationController.getBranchID("上海市");
				organizationController.addBranch(new BranchVO(branchID, "上海市上海市普陀区桃浦路"+((i+190)*10+i+1)+"号", OrganizationType.BRANCH));
				initAccountInBranch(accountController, branchID);
				initDriverAndCar(facilityController, driverController, branchID);
				System.out.println(2);
			}
			for (int i = 0; i < 15; i++) {
				String branchID = organizationController.getBranchID("广州市");
				organizationController.addBranch(new BranchVO(branchID, "广东省广州市越秀区中山二路"+(i+37)+"号", OrganizationType.BRANCH));
				initAccountInBranch(accountController, branchID);
				initDriverAndCar(facilityController, driverController, branchID);
				System.out.println(3);
			}
			for (int i = 0; i < 10; i++) {
				String branchID = organizationController.getBranchID("南京市");
				organizationController.addBranch(new BranchVO(branchID, "江苏省南京市秦淮区大明路"+(160+i)+"号", OrganizationType.BRANCH));
				initAccountInBranch(accountController, branchID);
				initDriverAndCar(facilityController, driverController, branchID);
				System.out.println(4);
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	private static void initAccountInTransfer(AccountController accountController) throws RemoteException {
		for (int i = 0; i < 15; i++) {
			String ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "中转中心业务员", "业务员" + ID, "", "", "", new BigDecimal("4500"), "0", "0101"));
			ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "中转中心业务员", "业务员" + ID, "", "", "", new BigDecimal("4500"), "0", "0212"));
			ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "中转中心业务员", "业务员" + ID, "", "", "", new BigDecimal("4500"), "0", "0203"));
			ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "中转中心业务员", "业务员" + ID, "", "", "", new BigDecimal("4500"), "0", "0254"));
		}
	}

	private static void initDriverAndCar(FacilityController facilityController, DriverController driverController,
			String branchID) throws RemoteException {
		for (int j = 0; j < 20; j++) {
			String carID = facilityController.getID(branchID);
			String driverID = driverController.getID(branchID);
			driverController.addDriver(new DriverVO(driverID, "司机", "司机" + driverID, "", "", "",
					new BigDecimal(500), "0", carID, branchID));
			facilityController.addFacility(new FacilityVO(driverID, new ArrayList<>(), carID, GetDate.getDate(),
					carID.substring(6), carID.substring(6), "A 00" + carID.substring(6), branchID));
		}
	}

	private static void initAccountInBranch(AccountController accountController, String branchID)
			throws RemoteException {
		for (int j = 0; j < 5; j++) {
			String ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "营业厅业务员", "员工" + ID, GetDate.getDate(), "", "",
					new BigDecimal(3000), "", branchID));
		}
		for (int j = 0; j < 50; j++) {
			String ID = accountController.getID();
			accountController.addAccount(new AccountVO(ID, "快递员", "员工" + ID, GetDate.getDate(), "", "",
					new BigDecimal(1000), "", branchID));
		}
	}
}
