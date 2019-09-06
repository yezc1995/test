package search;

import java.util.Vector;

import com.travelsky.ibe.client.AV;
import com.travelsky.ibe.client.AvResult;
import com.travelsky.ibe.client.pnr.BookFC;
import com.travelsky.ibe.client.pnr.BookFN;
import com.travelsky.ibe.client.pnr.BookInfomation;
import com.travelsky.ibe.client.pnr.BookOSI;
import com.travelsky.ibe.client.pnr.BookPassenger;
import com.travelsky.ibe.client.pnr.ETDZ;
import com.travelsky.ibe.client.pnr.ETDZResult;
import com.travelsky.ibe.client.pnr.PNRAirSeg;
import com.travelsky.ibe.client.pnr.PNRPassenger;
import com.travelsky.ibe.client.pnr.PnrManage;
import com.travelsky.ibe.client.pnr.RT;
import com.travelsky.ibe.client.pnr.RTResult;
import com.travelsky.ibe.client.pnr.SSResult;
import com.travelsky.ibe.client.pnr.SellSeat;

public class adult_child {
	public static void main(String[] args){
		/*try {
			seat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//rt();
		//etdz();
	  /* try {
			spilt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			tq();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//FN 税价
	//FC 票价
  static void seat() throws Exception{
	/*生成预定类对象*/
	SellSeat SellSeatexample= new SellSeat();
	SellSeatexample.setAppName("huhkk68n1");
	SellSeatexample.setAgentInfo("HAK969", "0", "9");
	SellSeatexample.setConnectionInfo("10.221.136.60", 6891);
	/*添加旅客姓名*/
	String name="IBETESTER/IBEGROUP";
	String name1="zhang/san";
	SellSeatexample.addAdult(name);
	SellSeatexample.addAdult(name1);
	/*添加旅客姓名*/
	String name_c="li/si";
	String name_c2="wang/wu";
	SellSeatexample.addChild(name_c);
	SellSeatexample.addChild(name_c2);
	/*添加旅客乘坐航段信息*/
	String airNo="HU7382"; //航班号
	char fltClass='Y';
	String orgCity="PEK";//出发地
	String dstCity="HAK";//到达地
	String actionCode="NN";//行动代码
	int tktNum=4;//订座人数
	String departureTime="2019-09-05";//出发时间
	SellSeatexample.addAirSeg(airNo,fltClass,orgCity,dstCity,actionCode,tktNum,departureTime);
	/*添加旅客乘坐航段信息*/
	String airNo2="HU7047"; 
	char fltClass2='Y';
	String orgCity2="HAK";
	String dstCity2="XMN";
	String actionCode2="NN";
	int tktNum2=4;
	String departureTime2="2019-09-07";
	SellSeatexample.addAirSeg(airNo2,fltClass2,orgCity2,dstCity2,actionCode2,tktNum2,departureTime2);
	/*添加旅客身份证信息*/
	String airline="HU";//航空公司代码
	String idtype="NI";//旅客证件信息
	String id="123456789";
	SellSeatexample.addSSR_FOID(airline,idtype,id,name);
	/*添加旅客身份证信息*/
	String airline_c="HU";
	String idtype_c="NI";
	String id_c="234567890";
	SellSeatexample.addSSR_FOID(airline_c,idtype_c,id_c,name_c);
	/*添加旅客身份证信息*/
	String airline_b="HU";
	String idtype_b="NI";
	String id_b="234567890";
	SellSeatexample.addSSR_FOID(airline_b,idtype_b,id_b,name1);
	/*添加旅客身份证信息*/
	String airline_c2="HU";
	String idtype_c2="NI";
	String id_c2="234567890";
	SellSeatexample.addSSR_FOID(airline_c2,idtype_c2,id_c2,name_c2);
	

	//FN项
	BookFN fn = new BookFN();
	fn.setAmount(BookFN.F, "CNY", 1760);
	fn.setAmount(BookFN.S, "CNY", 1760);
	fn.addTax(BookFN.T, "CNY", 50, "CN");
	fn.addTax(BookFN.T, "CNY", BookFN.EXEMPTTAX, "YQ");
	fn.setC(0);
	SellSeatexample.addFN(fn);
	//FC
	BookFC fc = new BookFC();
	fc.addFC("PEK", "HAK", "HU", "Y", 2382);
	fc.addFC("HAK", "XMN", "HU", "Y", 1047);
	fc.setMoneytype("CNY");
	SellSeatexample.addFC(fc);
	//没有他就不能生成PNR，输入的是乘客的联系方式，CTC固定
	SellSeatexample.addOSI(new BookOSI("HU","CTC13674187590","Zhang/San"));
	//备注
	SellSeatexample.addRMK("","Booked By yezhichao");
	/*添加旅客联系组信息*/
	String contactinfo="010-84669396";
	SellSeatexample.addContact(contactinfo);
	/*添加旅客出票时限*/
	String dateLimit="2019-09-05 08:00:00";
	SellSeatexample.setTimelimit(dateLimit);
	SSResult ssr = SellSeatexample.commit1();
	System.out.println(ssr);
}
  static void rt(){
		
		RT rt = new RT();
		rt.setAppName("huhkk68n1");
		rt.setAgentInfo("HAK969", "0", "9");
		rt.setConnectionInfo("10.221.136.60", 6891);
		
		try {
			//填pnr
			RTResult result = rt.retrieve("MJWNHR");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  static void etdz(){
		ETDZ et = new ETDZ();
		et.setAppName("huhkk68n1");
		et.setAgentInfo("HAK969", "0", "9");
		et.setConnectionInfo("10.221.136.60", 6891);
		
		try {
			//填pnr号
		ETDZResult[]prntRes=et.issueTicketWithTN("MJWNHR",1,"","");
		for(int i=0;i<prntRes.length;i++){
		System.out.println(prntRes[i]);
		}
			//报错Error: com.travelsky.ibe.exceptions.ETDZFailedException:Error :  INCOMPLETE PNR/FN    
			//没有传票价，所以报错，无法出票
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  static void spilt() throws Exception{
	  PnrManage pnrman = new PnrManage();
	  pnrman.setAppName("huhkk68n1");
	  pnrman.setAgentInfo("HAK969", "0", "9");
	  pnrman.setConnectionInfo("10.221.136.60", 6891);
	  Vector psgrs2 = new Vector();
	  BookPassenger psgr =new BookPassenger("li/si CHD");//分离儿童要加CHD
	  psgrs2.add(psgr);
	    BookInfomation bi = new BookInfomation();
	    bi.addOSI(new BookOSI("HU","CTC13674187590","li/si"));
        pnrman.addPnrInfo("MJWNHR",bi);
       String res = pnrman.splitPNR("MJWNHR", psgrs2, 4);
        System.out.println(res);//新 PNR
  }

static void tq() throws Exception{
	
	/*
	* 实现 PNR 旅客信息提取
	* */
	/*生成 RT 对象*/
	RT rtExample=new RT();
	rtExample.setAppName("huhkk68n1");
	rtExample.setAgentInfo("HAK969", "0", "9");
	rtExample.setConnectionInfo("10.221.136.60", 6891);
	/*提取 PNR 信息*/
	RTResult rtres = rtExample.retrieve ("MJWNHR");
	/*显示旅客信息*/
	//System.out.println("显示成人和儿童旅客");
	for(int i=0;i<rtres.getPassengersCount();i++){
		if(i==1){
			System.out.print("第二位旅客");
			PNRPassenger pnrPass=rtres.getPassengerAt(i);
			System.out.println(" 姓名:"+pnrPass.getName());
			System.out.print("PNR 序号:"+pnrPass.getIndex()); 
			System.out.print(" 年龄:"+pnrPass.getAge());
			System.out.print(" PNR 中姓名:"+pnrPass.getNameInPnr());
			System.out.println();
			
			System.out.println("显示航段组信息:");
			for(int a=0;a<rtres.getAirSegsCount();a++){
			PNRAirSeg pnrAirseg=rtres.getAirSegAt(i);
			System.out.println("PNR 序号:"+pnrAirseg.getIndex());
			System.out.println(" 航班号:"+pnrAirseg.getAirNo());
			System.out.println(" 出发城市"+pnrAirseg.getOrgCity());
			System.out.println(" 到达城市:"+pnrAirseg.getDesCity());
			System.out.println(" 出发时间"+pnrAirseg.getDepartureTimeString());
			System.out.println(" 到达时间:"+pnrAirseg.getArrivalTimeString());
			System.out.println(" 航班舱位:"+pnrAirseg.getFltClass());
			
			}
		}
	}

}
}
