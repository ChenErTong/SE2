package po;

/**
 * @author lxl
 * @version Oct 23,2015
 **/

public class InventoryPO extends PersistentObject {
	/** serialVersionUID */
	private static final long serialVersionUID = -2898348688803208513L;

	// 区
	private int area;
	// 排;
	private int row;
	// 架
	private int frame;
	// 位
	private int position;
	// 空或满
	private boolean isEmpty;
	
	private String transferID;

	public InventoryPO(String id, int area, int row, int frame, int position, boolean isEmpty,String transferID) {
		super(id);
		this.area = area;
		this.row = row;
		this.frame = frame;
		this.position = position;
		this.isEmpty = isEmpty;
		this.transferID=transferID;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getTransferID() {
		return transferID;
	}

	public void setTransferID(String transferID) {
		this.transferID = transferID;
	}

}
