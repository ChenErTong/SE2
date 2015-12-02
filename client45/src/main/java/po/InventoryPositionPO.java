package po;

import vo.CommodityVO;

public class InventoryPositionPO extends PersistentObject{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int area;
		//排;
		private int row;
		//架
		private int frame;
		//位
		private int position;
		private boolean isEmpty;
		private CommodityVO commodity;
		public InventoryPositionPO( int area, int row, int frame, int position,boolean isEmpty,CommodityVO commodity) {
			this.area = area;
			this.row = row;
			this.frame = frame;
			this.position = position;
			this.isEmpty=isEmpty;
			this.commodity=commodity;
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
		public CommodityVO getCommodity() {
			return commodity;
		}
		public void setCommodity(CommodityVO commodity) {
			this.commodity = commodity;
		}

}
