package com.chris.service;

import java.io.IOException;

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

	public void sendGet() throws Exception {

		Request request = new Request.Builder().url("http://localhost:8080/v1/api/getcoins").build();
//				.addHeader("custom-key", "mkyong") // add request headers
//				.addHeader("User-Agent", "OkHttp Bot").build();

		try (Response response = httpClient.newCall(request).execute()) {

			if (!response.isSuccessful())
				throw new IOException("Unexpected code " + response);

			// Get response body
			System.out.println(response.body().string());
		}

	}

	public void sendPost(String number) throws Exception {

		// form parameters
		RequestBody formBody = new FormBody.Builder().add("number", number).build();
		CoinDispenserRequest newAM = new CoinDispenserRequest();
		newAM.setAmount(number);

		Gson gs = new Gson();
		gs.toJson(newAM);
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), gs.toJson(newAM));

		Request request = new Request.Builder().url("http://localhost:8080/v1/api/getcoins")
				.addHeader("User-Agent", "OkHttp Bot").post(body).build();

		System.out.println("request " + request);

		try (Response response = httpClient.newCall(request).execute()) {

			System.out.println(response.body().string());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
