package businesslogic.basebl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import businesslogic.orderbl.BaseInfo_Order;
import dataservice.basedataservice.BaseDataService;
import po.BasePO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:32:38
 */
public class BaseInfo implements BaseInfo_Order{
	Base base;
	BaseDataService baseData;
	public BaseInfo() throws MalformedURLException, RemoteException, NotBoundException {
		base = new Base();
		baseData = base.getData();
	}
	/**
	 * @see BaseInfo_Order#getArrialDateByCities(String, String, String, double)
	 */
	public String getArrialDateByCities(String cityFrom, String cityTo, String begindate, BigDecimal transSpeed) throws RemoteException {
		BasePO po = this.findBaseByCities(cityFrom, cityTo);
		if(po==null){
			System.out.println("No Data In BasePO from "+cityFrom+" To "+cityTo);
			return getArrialDate(begindate,3);
		}else{
			BigDecimal days = po.getDistance().divide(new BigDecimal(1000)).multiply(transSpeed);
			return getArrialDate(begindate, (int)Math.ceil(days.doubleValue()));
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
	/**
	 * @throws RemoteException 
	 * @see BaseInfo_Order#getArrialPriceByCities(String, String, double, double)
	 */
	@Override
	public BigDecimal getArrialPriceByCities(String cityFrom, String cityTo, BigDecimal weight, BigDecimal priceConstant) throws RemoteException {
		BasePO po = this.findBaseByCities(cityFrom, cityTo);
		BigDecimal distance;
		if(po==null)
			distance= new BigDecimal(1000);
		else
			distance = po.getDistance();
		BigDecimal price = this.getPrice(distance,weight,priceConstant);
		return price;
	}
	private BigDecimal getPrice(BigDecimal distance, BigDecimal weight, BigDecimal priceConstant) {
		return distance.divide(new BigDecimal(1000)).multiply(weight).multiply(priceConstant);
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
