package po;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
public class InventoryPO extends PersistentObject {
	/**serialVersionUID*/
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
=======
	private String id;
>>>>>>> origin/master
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
<<<<<<< HEAD
		super(id);
=======
		this.id=id;
>>>>>>> origin/master
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
<<<<<<< HEAD
=======

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
>>>>>>> origin/master
	
	
	
}
<<<<<<< HEAD

=======
>>>>>>> origin/master
