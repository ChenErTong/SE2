package po;

/** @author lxl
	 *  @version Oct 23,2015
	 *      **/
	
//下午改 TODO 下午改
public class InventoryPO extends PersistentObject  {
	/** serialVersionUID */
	private static final long serialVersionUID = -2898348688803208513L;
	
	 //区
		public int area;
		//排;
		public int row;
		//架
		public int frame;
		//位
		public int position;
		//空或满
		public String EmptyOrFull;
		public InventoryPO(String id, int area, int row, int frame, int position, String emptyOrFull) {
			super(id);
			this.area = area;
			this.row = row;
			this.frame = frame;
			this.position = position;
			EmptyOrFull = emptyOrFull;
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
		public String getEmptyOrFull() {
			return EmptyOrFull;
		}
		public void setEmptyOrFull(String emptyOrFull) {
			EmptyOrFull = emptyOrFull;
		}
	
	}
	
	
	
	
	
	
	

