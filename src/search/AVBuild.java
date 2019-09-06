package search;


import com.travelsky.ibe.client.AV;
import com.travelsky.ibe.client.AvResult;
import com.travelsky.ibe.client.DSG;
import com.travelsky.ibe.client.FD;
import com.travelsky.ibe.client.FDResult;
import com.travelsky.ibe.client.pnr.BookFC;
import com.travelsky.ibe.client.pnr.BookFN;
import com.travelsky.ibe.client.pnr.BookOSI;
import com.travelsky.ibe.client.pnr.ETDZ;
import com.travelsky.ibe.client.pnr.RT;
import com.travelsky.ibe.client.pnr.RTResult;
import com.travelsky.ibe.client.pnr.SSResult;
import com.travelsky.ibe.client.pnr.SellSeat;
import com.travelsky.ibe.client.DsgResult;
import com.travelsky.ibe.client.DsgSegment;
public class AVBuild {

	protected static void av(){
		//与ebuild服务器创建一个链接，固定配置，在D:\ExternalWebs\config\XDIST\TSDF.xml中配置
		AV av = new AV();
	   // PID？？
		av.setAppName("huhkk68n1");
		// HAK969：部门代号、0：工作号？？、9：密码？？
		av.setAgentInfo("HAK969", "0", "9");
		// 主机的IP与端口
		av.setConnectionInfo("10.221.136.60", 6891);
		
		
		try {
			//执行机票查询，起始地，目的地，航班起始时间(终止时间默认为当天)，航司编码
			AvResult avResult = av.getAvailability("PEK","HAK","20191010 10:00:00","HU");
			//AvResult为航班查询结果
			System.out.println(avResult);
			
			//AvResult avResultOne = av.getAvailByFltNo("HU7182", "20191010 10:00:00");
			//System.out.println(avResultOne);
			
			avResult.getItem(0);//获取航班查询结果列表中的某一项，还有其他显而易见的方法
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		 // av();//查票
	    // sellSeat();//定票
		//etdz();//出票
		// rt();//根据pnr号查pnr信息
		money();//查票价
	}

	static void sellSeat(){
		SellSeat sellSeat = new SellSeat();
		sellSeat.setAppName("huhkk68n1");
		sellSeat.setAgentInfo("HAK969", "0", "9");
		sellSeat.setConnectionInfo("10.221.136.60", 6891);
		
		try {
			//必须输入项
			sellSeat.addAdult("Zhang/San");
			sellSeat.addAirSeg("HU7024",'Y',"SZX","HAK","NN",1,"2019-09-23");
			sellSeat.addSSR_FOID("HU", "NI", "123456", "Zhang/San");
			sellSeat.addContact("010-123456");
			sellSeat.setTimelimit("2019-09-22 08:00:00");
			//没有他就不能生成PNR，输入的是乘客的联系方式，CTC固定
			sellSeat.addOSI(new BookOSI("HU","CTC13674187590","Zhang/San"));
			//sellSeat.addOSI("HU7291", "CTC13674187590");
			
			//FN项
			BookFN fn = new BookFN();
			fn.setAmount(BookFN.F, "CNY", 1760);
			fn.setAmount(BookFN.S, "CNY", 1760);
			fn.addTax(BookFN.T, "CNY", 50, "CN");
			fn.addTax(BookFN.T, "CNY", BookFN.EXEMPTTAX, "YQ");
			fn.setC(0);
			sellSeat.addFN(fn);
			
			BookFC fc = new BookFC();
			fc.addFC("SZX", "HAK", "HU", "Y", 1760);
			fc.setMoneytype("CNY");
			sellSeat.addFC(fc);
			
			SSResult ssr = sellSeat.commit1();
			System.out.println(ssr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void rt(){
		
		RT rt = new RT();
		rt.setAppName("huhkk68n1");
		rt.setAgentInfo("HAK969", "0", "9");
		rt.setConnectionInfo("10.221.136.60", 6891);
		
		try {
			//填pnr
			RTResult result = rt.retrieve("MHMBGC");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 static void money(){
		//连接消息
		 /*生成运价查询对象*/
		 FD fd =new FD();
		 fd.setAppName("huhkk68n1");
		
		 fd.setAgentInfo("HAK969", "0", "9");
		 fd.setConnectionInfo("10.221.136.60", 6891);
		 /*查询成人上海至北京国航运价*/
		 FDResult fdres;
		try {
			fdres = fd.findPrice("pek","hak","01sep19","HU");
			 System.out.println(fdres);
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
			String e = et.issueBSPTicket("NLP6H7", 1);
			System.out.println(e);
			//报错Error: com.travelsky.ibe.exceptions.ETDZFailedException:Error :  INCOMPLETE PNR/FN    
			//没有传票价，所以报错，无法出票
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
