package com.chris.interview.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.impl.CoinDispencerImpl;
import com.chris.model.CoinDispenserRequest;

@RestController
@RequestMapping("v1/api")
public class CoinDispenserAPI {
	CoinDispencerImpl coinDispencerImpl = new CoinDispencerImpl();

	@PostMapping("getcoins")
	public int postCoins(@RequestBody CoinDispenserRequest coinDispenserRequest) {
		System.out.println(coinDispenserRequest);

		//Creating an array of strings from the field input
		String[] arrSplit = coinDispenserRequest.getDenominators().split(",");
		ArrayList<Integer> denominators = new ArrayList<Integer>();

		for (int i = 0; i < arrSplit.length; i++) {

			if (!arrSplit[i].isEmpty() && Integer.parseInt(arrSplit[i]) > 0) {
				denominators.add(Integer.parseInt(arrSplit[i]));
			}
		}
		//Initializing array with the List size
		int[] denominatorsArray = new int[denominators.size()];
	
		//Pushing List values to an array
		for (int i = 0; i < denominators.size(); i++) {
			denominatorsArray[i]=denominators.get(i);
		}
		
		return coinDispencerImpl.getMinimum(denominatorsArray, coinDispenserRequest.getAmount());
	}
	


}
