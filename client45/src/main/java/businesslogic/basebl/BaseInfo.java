package businesslogic.basebl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import businesslogic.orderbl.BaseInfo_Order;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
import ui.mainForUITest;

public class BaseInfo implements BaseInfo_Order{
	Base base;
	BaseDataService baseData;
	public BaseInfo() {
		base = new Base();
		baseData = base.getData();
	}
	@Override
	public String getArrialDateByCities(String cityFrom, String cityTo, String begindate, double transSpeed) throws RemoteException {
		BasePO po = this.findBaseByCities(cityFrom, cityTo);
		if(po==null){
			System.out.println("No Data In BasePO from "+cityFrom+" To "+cityTo);
			return getArrialDate(begindate,3);
		}else{
			double days = po.getDistance()/1000*transSpeed;
			return getArrialDate(begindate, (int)Math.ceil(days));
		}
	}
	
	private BasePO findBaseByCities(String cityFrom,String cityTo) throws RemoteException{
		ArrayList<BasePO> pos = baseData.find();
		for (BasePO basePO : pos) {
			if(isCorrectBase(basePO,cityFrom,cityTo)){
				return basePO;
			}
		}
		return null;
	}
	private boolean isCorrectBase(BasePO basePO, String cityFrom, String cityTo) {
		return (basePO.getCityFrom().equals(cityFrom)&&basePO.getCityTo().equals(cityTo))||
				(basePO.getCityFrom().equals(cityTo)&&basePO.getCityTo().equals(cityFrom));
	}
	
	private String getArrialDate(String begindate,int days){
		//yyyy-MM-dd
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc=new GregorianCalendar(); 
		try {
			Date date = sdf.parse(begindate);
			gc.setTime(date); 
			//5表示按日添加
			gc.add(5, days);
			return sdf.format(gc.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc=new GregorianCalendar(); 
		Date date = new Date();
		gc.setTime(date);
		System.out.println(sdf.format(date));
		gc.add(5, 1);
		System.out.println(sdf.format(gc.getTime()));
		gc.add(5, 1);
		System.out.println(sdf.format(gc.getTime()));
	}*/

}
