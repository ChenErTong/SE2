package vo;
/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public class InventoryVO {
	
	public int a;
	public int b;
	public int c;
	public int d;
	public String EmptyOrFull;
	public InventoryVO(int a, int b, int c, int d, String emptyOrFull) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		EmptyOrFull = emptyOrFull;
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
	public String getEmptyOrFull() {
		return EmptyOrFull;
	}
	public void setEmptyOrFull(String emptyOrFull) {
		EmptyOrFull = emptyOrFull;
	}
	
}
