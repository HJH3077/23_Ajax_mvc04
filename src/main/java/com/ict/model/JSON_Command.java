package com.ict.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSON_Command {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTime/1/5/");
			URLConnection conn = url.openConnection();
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String msg = "";
			while((msg = br.readLine())!=null) {
				sb.append(msg+"\n");
			}
		} catch (Exception e) {
		} finally {
			try {
				br.close();
			} catch (Exception e2) {
			}
		}
		return sb.toString();
	}
}
