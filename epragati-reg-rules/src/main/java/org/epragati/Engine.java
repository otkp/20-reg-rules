package org.epragati;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.JSObject;

public class Engine {
	public static void main(String[] args) {

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			
			engine.eval(new FileReader("script.js"));
			
			Invocable invocable = (Invocable) engine;
			Object result;
			
			Map<String, Object> map = new TreeMap<String, Object>();
			map.put("type", "I");
			map.put("weight", 3001);
			
			JSObject obj = ( JSObject)invocable.invokeFunction("basicCal", map);
		//	System.out.println(obj.values());
			
			//result = invocable.invokeFunction("fun2", map);
			//System.out.println(result);
			//System.out.println(result.getClass());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
