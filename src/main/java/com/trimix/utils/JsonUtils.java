package com.trimix.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

	public static int getIntValueFromJson(String json, String atrib) {
		JSONObject obj = new JSONObject(json);
		int atributoValor = 0;
		try {
			atributoValor = obj.getInt(atrib);
		} catch (JSONException e) {
			atributoValor = 0;
		}
		return atributoValor;
	}

	public static long getLongValueFromJson(String json, String atrib) {
		JSONObject obj = new JSONObject(json);
		long atributoValor = 0;
		try {
			atributoValor = obj.getLong(atrib);
		} catch (JSONException e) {
			atributoValor = 0;
		}
		return atributoValor;
	}

	public static String getStringValueFromJson(String json, String atrib) {
		JSONObject obj = new JSONObject(json);
		String atributoValor = "";
		try {
			atributoValor = obj.getString(atrib);
		} catch (JSONException e) {
			atributoValor = "";
		}
		return atributoValor;
	}

	public static Date getDateyyyyMMddFromJson(String json, String atrib) throws JSONException, ParseException {
		JSONObject obj = new JSONObject(json);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		Date r = (Date) df.parse(obj.getString(atrib));
		return r;
	}

	public static JSONObject getObjectJson(String json, String atrib) throws JSONException, ParseException {
		JSONObject obj = new JSONObject();
		try {
			obj = new JSONObject(json);
			return obj.getJSONObject(atrib);
		} catch (JSONException e) {
			obj = null;
		}
		return null;
	}

}
