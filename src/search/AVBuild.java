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
		//��ebuild����������һ�����ӣ��̶����ã���D:\ExternalWebs\config\XDIST\TSDF.xml������
		AV av = new AV();
	   // PID����
		av.setAppName("huhkk68n1");
		// HAK969�����Ŵ��š�0�������ţ�����9�����룿��
		av.setAgentInfo("HAK969", "0", "9");
		// ������IP��˿�
		av.setConnectionInfo("10.221.136.60", 6891);
		
		
		try {
			//ִ�л�Ʊ��ѯ����ʼ�أ�Ŀ�ĵأ�������ʼʱ��(��ֹʱ��Ĭ��Ϊ����)����˾����
			AvResult avResult = av.getAvailability("PEK","HAK","20191010 10:00:00","HU");
			//AvResultΪ�����ѯ���
			System.out.println(avResult);
			
			//AvResult avResultOne = av.getAvailByFltNo("HU7182", "20191010 10:00:00");
			//System.out.println(avResultOne);
			
			avResult.getItem(0);//��ȡ�����ѯ����б��е�ĳһ����������Զ��׼��ķ���
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		 // av();//��Ʊ
	    // sellSeat();//��Ʊ
		//etdz();//��Ʊ
		// rt();//����pnr�Ų�pnr��Ϣ
		money();//��Ʊ��
	}

	static void sellSeat(){
		SellSeat sellSeat = new SellSeat();
		sellSeat.setAppName("huhkk68n1");
		sellSeat.setAgentInfo("HAK969", "0", "9");
		sellSeat.setConnectionInfo("10.221.136.60", 6891);
		
		try {
			//����������
			sellSeat.addAdult("Zhang/San");
			sellSeat.addAirSeg("HU7024",'Y',"SZX","HAK","NN",1,"2019-09-23");
			sellSeat.addSSR_FOID("HU", "NI", "123456", "Zhang/San");
			sellSeat.addContact("010-123456");
			sellSeat.setTimelimit("2019-09-22 08:00:00");
			//û�����Ͳ�������PNR��������ǳ˿͵���ϵ��ʽ��CTC�̶�
			sellSeat.addOSI(new BookOSI("HU","CTC13674187590","Zhang/San"));
			//sellSeat.addOSI("HU7291", "CTC13674187590");
			
			//FN��
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
			//��pnr
			RTResult result = rt.retrieve("MHMBGC");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 static void money(){
		//������Ϣ
		 /*�����˼۲�ѯ����*/
		 FD fd =new FD();
		 fd.setAppName("huhkk68n1");
		
		 fd.setAgentInfo("HAK969", "0", "9");
		 fd.setConnectionInfo("10.221.136.60", 6891);
		 /*��ѯ�����Ϻ������������˼�*/
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
			//��pnr��
			String e = et.issueBSPTicket("NLP6H7", 1);
			System.out.println(e);
			//����Error: com.travelsky.ibe.exceptions.ETDZFailedException:Error :  INCOMPLETE PNR/FN    
			//û�д�Ʊ�ۣ����Ա����޷���Ʊ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
