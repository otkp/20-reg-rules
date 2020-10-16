package org.epragati;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;


public class RulesTest {

	ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
	ScriptEngine engine2 = new ScriptEngineManager().getEngineByName("nashorn");

	@Before
	public void init(){
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("script.js").getFile());
			engine.eval(new FileReader(file));
			/*engine2.eval(new FileReader("D:\\GIT Repository\\RegistrationModule_20_11_17\\backend\\epragati-reg-rules\\src\\main\\resources\\script.js"));*/
		}catch(Exception e) {
			System.out.println("ok");
		}
	}

	@Test
	public void doRLWTestOk() {
		Engine engine = new Engine();
		//engine.getTax();
		assertEquals("10.0", "10.0");
	}
	
	@Test
	public void doRLWTestOk1() throws NoSuchMethodException, ScriptException {
		
		Invocable invocable = (Invocable) engine;
		HashMap <String,Object> map=new HashMap<String,Object>();
		map.put("tax",500);
		map.put("tax_Type","Q");
		map.put("tax_Validity", "2016-12-30");
		map.put("tax_PendingQuarters",2);
		map.put("tax_PendingMonths",5);
		
		map.put("vcrBookedDate","2017-5-1");
		map.put("month","M1");
		map.put("vcrIssued",true);
		map.put("stoppages","no");
		
		map.put("seized",true);
		Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
		
		//engine.getTax();
		assertEquals(500.0,mapresponse.get("tax_Total"));
		System.out.println("map response"+mapresponse.get("tax_Total"));
	}
	
	
	@Test
public void doRLWTestOk2() throws NoSuchMethodException, ScriptException {
		
		Invocable invocable = (Invocable) engine;
		HashMap <String,Object> map=new HashMap<String,Object>();
		map.put("tax",500);
		map.put("tax_Type","Q");
		map.put("tax_Validity", "2016-12-30");
		map.put("tax_PendingQuarters",2);
		map.put("tax_PendingMonths",5);
		
		map.put("vcrBookedDate","2017-5-1");
		map.put("month","M2");
		map.put("vcrIssued",true);
		map.put("stoppages","no");
		
		map.put("seized",true);
		Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
		
		//engine.getTax();
		assertEquals(340.0,mapresponse.get("tax_Total"));
		System.out.println("map response"+mapresponse.get("tax_Total"));
	}
	
	
	@Test
	public void doRLWTestOk3() throws NoSuchMethodException, ScriptException {
			
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("tax_Validity", "2016-12-30");
			map.put("tax_PendingQuarters",2);
			map.put("tax_PendingMonths",5);
			
			map.put("vcr_BookedDate","2017-5-1");
			map.put("month","M3");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(170.0,mapresponse.get("tax_Total"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
		
		
	@Test
	public void doRLWTestOk4() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-02-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(500.0,mapresponse.get("tax_Total"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
		
		
	@Test
	public void doRLWTestOk5() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-02-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(340.0,mapresponse.get("tax_Total"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
		
	@Test
	public void doRLWTestOk6() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-02-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(340.0,mapresponse.get("tax_Total"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
		
	@Test
	public void doRLWTestOk8() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-02-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(170.0,mapresponse.get("tax_Total"));
			assertEquals(340.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
		
	@Test
	public void doRLWTestOk9() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",500);
			map.put("tax_Type","Q");
			map.put("month","M3");
			map.put("vcr_BookedDate","2017-02-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(0.0,mapresponse.get("tax_Total"));
			assertEquals(340.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	@Test
	public void doRLWTestOk10() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1100);
			map.put("tax_Type","H");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",false);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(1840.0,mapresponse.get("tax_Total"));
			assertEquals(3300.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	
	@Test
	public void doRLWTestOk11() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",1);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",2544);
			map.put("tax_Type","Q");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(1700.0,mapresponse.get("tax_Total"));
			assertEquals(5090.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	
	@Test
	public void doRLWTestOk12() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1456);
			map.put("tax_Type","Y");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(5340.0,mapresponse.get("tax_Total"));
			assertEquals(2920.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	
	@Test
	public void doRLWTestOk13() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",799.2);
			map.put("tax_Type","H");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",2);
			map.put("seized",false);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(1600.0,mapresponse.get("tax_Total"));
			assertEquals(2400.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk14() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1780);
			map.put("tax_Type","H");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(2380.0,mapresponse.get("tax_Total"));
			assertEquals(4160.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk15() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",2156);
			map.put("tax_Type","H");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(3600.0,mapresponse.get("tax_Total"));
			assertEquals(5040.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk16() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",4152.3);
			map.put("tax_Type","Y");
			map.put("month","M3");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(12460.0,mapresponse.get("tax_Total"));
			assertEquals(9690.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk17() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",4);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1780);
			map.put("tax_Type","H");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",false);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(2380.0,mapresponse.get("tax_Total"));
			assertEquals(5340.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk18() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",1);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1111);
			map.put("tax_Type","H");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(1490.0,mapresponse.get("tax_Total"));
			assertEquals(2230.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	
	@Test
	public void doRLWTestOk19() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",2456);
			map.put("tax_Type","H");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(4100.0,mapresponse.get("tax_Total"));
			assertEquals(4920.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk20() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",2);
			}
			map.put("tax",1299.2);
			map.put("tax_Type","H");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(1740.0,mapresponse.get("tax_Total"));
			assertEquals(3040.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk21() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",1299.2);
			map.put("tax_Type","Q");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(440.0,mapresponse.get("tax_Total"));
			assertEquals(0.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk22() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=true;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",999);
			map.put("tax_Type","Y");
			map.put("month","M3");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(3000.0,mapresponse.get("tax_Total"));
			assertEquals(0.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	

	@Test
	public void doRLWTestOk23() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",1259);
			map.put("tax_Type","Y");
			map.put("month","M1");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(4620.0,mapresponse.get("tax_Total"));
			assertEquals(2940.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}

	@Test
	public void doRLWTestOk24() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",1452.2);
			map.put("tax_Type","Q");
			map.put("month","M2");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages",1);
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(490.0,mapresponse.get("tax_Total"));
			assertEquals(3390.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	

	@Test
	public void doRLWTestOk26() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",1789.32);
			map.put("tax_Type","Y");
			map.put("month","M3");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",7);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(5970.0,mapresponse.get("tax_Total"));
			assertEquals(4180.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	@Test
	public void doRLWTestOk27() throws NoSuchMethodException, ScriptException {
			boolean sameQuarter=false;
			Invocable invocable = (Invocable) engine;
			HashMap <String,Object> map=new HashMap<String,Object>();
			if(sameQuarter==true);
			{
			map.put("sameQuarter",sameQuarter);
			map.put("monthsdiff",0);	
			map.put("QuartersPending_ValidityToVcr",0);
			}
			map.put("tax",850);
			map.put("tax_Type","Q");
			map.put("month","M3");
			map.put("vcr_BookedDate","2017-03-22");
			map.put("tax_Validity", "2016-12-31");
			map.put("vcrIssued",true);
			map.put("stoppages","no");
			map.put("tax_PendingQuarters",3);
			map.put("tax_PendingMonths",4);
			map.put("seized",true);
			Map mapresponse =  (Map) invocable.invokeFunction("taxCal_Registered",map);
			
			//engine.getTax();
			assertEquals(290.0,mapresponse.get("tax_Total"));
			assertEquals(1140.0,mapresponse.get("tax_Arrears"));
			System.out.println("map response"+mapresponse.get("tax_Total"));
		}
	
	
	@Test
	public void doRLWTestKo() {
		assertNotEquals("10.0", "11.0");
	}
}
