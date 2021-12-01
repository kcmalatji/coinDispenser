package com.chris.interview.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.chris.impl.CoinDispencerImpl;
import com.chris.model.CoinDispenserRequest;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class CoinDispenserControllerTest {
	
	CoinDispencerImpl coinDispencerImpl = new CoinDispencerImpl();
	private final OkHttpClient httpClient = new OkHttpClient();
	
	@Test
	void testcoinDispencerImpl() {
		
		int amount = 36;
		int denominators[] = {1,2,3,4,5,7};
		assertEquals(6, coinDispencerImpl.getMinimum(denominators, amount));
	}
	
	@Test
	void testcoinDispencerAPI() throws IOException {
		
		int amount = 36;
		String denominators = "1,2,3,4,5,7";
		CoinDispenserRequest request =new CoinDispenserRequest();
		request.setAmount(amount);
		request.setDenominators(denominators);
		
		Gson gs = new Gson();
		gs.toJson(request);
		 String  responseBody;
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), gs.toJson(request));

		Request httpRequest = new Request.Builder().url("http://localhost:8080/v1/api/getcoins").post(body).build();

		System.out.println("request " + request);
		
	     try (Response response = httpClient.newCall(httpRequest).execute()) {

	            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	            // Get response body
	              responseBody=response.body().string();
	     
	            System.out.println("Minimum Combination is:" + responseBody);
	            response.close();
	        }
	     
		assertEquals(6,Integer.parseInt(responseBody));
	}
	
	
}
