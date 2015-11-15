package vo;

public class InventoryViewVO {

	  /** @author lxl
		 *  @version Oct 23,2015
		 *      **/
		
	/** 出库数量 **/
	public int exportNumber;
	/** 入库数量）**/
	public int importNumber;
	/**库存数量**/
	public int num;
	
	
	public InventoryViewVO(int exportNumber, int importNumber, int num) {
		super();
		this.exportNumber = exportNumber;
		this.importNumber = importNumber;
		this.num=num;
	}


	public int getExportNumber() {
		return exportNumber;
	}


	public void setExportNumber(int exportNumber) {
		this.exportNumber = exportNumber;
	}


	public int getImportNumber() {
		return importNumber;
	}


	public void setImportNumber(int importNumber) {
		this.importNumber = importNumber;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
}
