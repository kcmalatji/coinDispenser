package com.chris.service;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.boot.json.GsonJsonParser;

import com.chris.model.CoinDispenserRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CoinDispenserService {
	private final OkHttpClient httpClient = new OkHttpClient();

	public void sendPost(String number, HttpSession session) throws IOException {

		CoinDispenserRequest request = new CoinDispenserRequest();
		request.setAmount(number);
		int httpResponse = 0;
		Gson gs = new Gson();
		gs.toJson(request);
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), gs.toJson(request));

		Request httpRequest = new Request.Builder().url("http://localhost:8080/v1/api/getcoins").post(body).build();

		System.out.println("request " + request);
		
	     try (Response response = httpClient.newCall(httpRequest).execute()) {

	            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	            // Get response body
	            String  responseBody=response.body().string();
	            session.setAttribute("response", responseBody);
	            System.out.println("Response Body :" + responseBody);
	            response.close();
	        }
	}

}
