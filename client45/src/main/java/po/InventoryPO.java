package po;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public class InventoryPO extends PersistentObject {
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private int num;
	public String lLocation;
	public int size;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public InventoryPO(String id, String lLocation, int size,int num) {
		super(id);
		this.lLocation = lLocation;
		this.size = size;
		this.num= num;
	}
	
	public String getlLocation() {
		return lLocation;
	}
	public void setlLocation(String lLocation) {
		this.lLocation = lLocation;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}

