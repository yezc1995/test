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
	//FN ˰��
	//FC Ʊ��
  static void seat() throws Exception{
	/*����Ԥ�������*/
	SellSeat SellSeatexample= new SellSeat();
	SellSeatexample.setAppName("huhkk68n1");
	SellSeatexample.setAgentInfo("HAK969", "0", "9");
	SellSeatexample.setConnectionInfo("10.221.136.60", 6891);
	/*����ÿ�����*/
	String name="IBETESTER/IBEGROUP";
	String name1="zhang/san";
	SellSeatexample.addAdult(name);
	SellSeatexample.addAdult(name1);
	/*����ÿ�����*/
	String name_c="li/si";
	String name_c2="wang/wu";
	SellSeatexample.addChild(name_c);
	SellSeatexample.addChild(name_c2);
	/*����ÿͳ���������Ϣ*/
	String airNo="HU7382"; //�����
	char fltClass='Y';
	String orgCity="PEK";//������
	String dstCity="HAK";//�����
	String actionCode="NN";//�ж�����
	int tktNum=4;//��������
	String departureTime="2019-09-05";//����ʱ��
	SellSeatexample.addAirSeg(airNo,fltClass,orgCity,dstCity,actionCode,tktNum,departureTime);
	/*����ÿͳ���������Ϣ*/
	String airNo2="HU7047"; 
	char fltClass2='Y';
	String orgCity2="HAK";
	String dstCity2="XMN";
	String actionCode2="NN";
	int tktNum2=4;
	String departureTime2="2019-09-07";
	SellSeatexample.addAirSeg(airNo2,fltClass2,orgCity2,dstCity2,actionCode2,tktNum2,departureTime2);
	/*����ÿ����֤��Ϣ*/
	String airline="HU";//���չ�˾����
	String idtype="NI";//�ÿ�֤����Ϣ
	String id="123456789";
	SellSeatexample.addSSR_FOID(airline,idtype,id,name);
	/*����ÿ����֤��Ϣ*/
	String airline_c="HU";
	String idtype_c="NI";
	String id_c="234567890";
	SellSeatexample.addSSR_FOID(airline_c,idtype_c,id_c,name_c);
	/*����ÿ����֤��Ϣ*/
	String airline_b="HU";
	String idtype_b="NI";
	String id_b="234567890";
	SellSeatexample.addSSR_FOID(airline_b,idtype_b,id_b,name1);
	/*����ÿ����֤��Ϣ*/
	String airline_c2="HU";
	String idtype_c2="NI";
	String id_c2="234567890";
	SellSeatexample.addSSR_FOID(airline_c2,idtype_c2,id_c2,name_c2);
	

	//FN��
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
	//û�����Ͳ�������PNR��������ǳ˿͵���ϵ��ʽ��CTC�̶�
	SellSeatexample.addOSI(new BookOSI("HU","CTC13674187590","Zhang/San"));
	//��ע
	SellSeatexample.addRMK("","Booked By yezhichao");
	/*����ÿ���ϵ����Ϣ*/
	String contactinfo="010-84669396";
	SellSeatexample.addContact(contactinfo);
	/*����ÿͳ�Ʊʱ��*/
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
			//��pnr
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
			//��pnr��
		ETDZResult[]prntRes=et.issueTicketWithTN("MJWNHR",1,"","");
		for(int i=0;i<prntRes.length;i++){
		System.out.println(prntRes[i]);
		}
			//����Error: com.travelsky.ibe.exceptions.ETDZFailedException:Error :  INCOMPLETE PNR/FN    
			//û�д�Ʊ�ۣ����Ա����޷���Ʊ
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
	  BookPassenger psgr =new BookPassenger("li/si CHD");//�����ͯҪ��CHD
	  psgrs2.add(psgr);
	    BookInfomation bi = new BookInfomation();
	    bi.addOSI(new BookOSI("HU","CTC13674187590","li/si"));
        pnrman.addPnrInfo("MJWNHR",bi);
       String res = pnrman.splitPNR("MJWNHR", psgrs2, 4);
        System.out.println(res);//�� PNR
  }

static void tq() throws Exception{
	
	/*
	* ʵ�� PNR �ÿ���Ϣ��ȡ
	* */
	/*���� RT ����*/
	RT rtExample=new RT();
	rtExample.setAppName("huhkk68n1");
	rtExample.setAgentInfo("HAK969", "0", "9");
	rtExample.setConnectionInfo("10.221.136.60", 6891);
	/*��ȡ PNR ��Ϣ*/
	RTResult rtres = rtExample.retrieve ("MJWNHR");
	/*��ʾ�ÿ���Ϣ*/
	//System.out.println("��ʾ���˺Ͷ�ͯ�ÿ�");
	for(int i=0;i<rtres.getPassengersCount();i++){
		if(i==1){
			System.out.print("�ڶ�λ�ÿ�");
			PNRPassenger pnrPass=rtres.getPassengerAt(i);
			System.out.println(" ����:"+pnrPass.getName());
			System.out.print("PNR ���:"+pnrPass.getIndex()); 
			System.out.print(" ����:"+pnrPass.getAge());
			System.out.print(" PNR ������:"+pnrPass.getNameInPnr());
			System.out.println();
			
			System.out.println("��ʾ��������Ϣ:");
			for(int a=0;a<rtres.getAirSegsCount();a++){
			PNRAirSeg pnrAirseg=rtres.getAirSegAt(i);
			System.out.println("PNR ���:"+pnrAirseg.getIndex());
			System.out.println(" �����:"+pnrAirseg.getAirNo());
			System.out.println(" ��������"+pnrAirseg.getOrgCity());
			System.out.println(" �������:"+pnrAirseg.getDesCity());
			System.out.println(" ����ʱ��"+pnrAirseg.getDepartureTimeString());
			System.out.println(" ����ʱ��:"+pnrAirseg.getArrivalTimeString());
			System.out.println(" �����λ:"+pnrAirseg.getFltClass());
			
			}
		}
	}

}
}
