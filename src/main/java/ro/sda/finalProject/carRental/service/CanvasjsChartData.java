package ro.sda.finalProject.carRental.service;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
 

public class CanvasjsChartData {
 
	static JSONArray json = null;
 
	static {
 
		try {
			json = readJsonFromUrl("https://canvasjs.com/data/gallery/spring-mvc/starbucks-corporation-stock-price.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
 
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
 
	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
 
	public static String getCanvasjsDataList() {
		return json.toString();
	}
}                        