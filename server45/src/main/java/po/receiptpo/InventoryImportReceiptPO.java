package po.receiptpo;

import state.ReceiptType;

public class InventoryImportReceiptPO extends ReceiptPO {
	/**
	 * @author lxl
	 * @version Oct 23,2015
	 **/

	private static final long serialVersionUID = 1L;

	// 目的地
	public String depture;
	public String destination;
	public String CommoditiesID;
	// 区号
	public int a;
	// 排号
	public int b;
	// 架号
	public int c;
	// 位号
	public int d;

	public InventoryImportReceiptPO(String ID, ReceiptType type, String depture, String destination,
			String commoditiesID, int a, int b, int c, int d) {
		super(ID, type);
		this.depture = depture;
		this.destination = destination;
		CommoditiesID = commoditiesID;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public String getDepture() {
		return depture;
	}

	public void setDepture(String depture) {
		this.depture = depture;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCommoditiesID() {
		return CommoditiesID;
	}

	public void setCommoditiesID(String commoditiesID) {
		CommoditiesID = commoditiesID;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
