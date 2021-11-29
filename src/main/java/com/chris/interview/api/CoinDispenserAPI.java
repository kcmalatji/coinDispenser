package com.chris.interview.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.impl.CoinDispencerImpl;
import com.chris.model.CoinDispenserRequest;

import org.springframework.ui.Model;

@RestController
@RequestMapping("v1/api")
public class CoinDispenserAPI {
	CoinDispencerImpl coinDispencerImpl = new CoinDispencerImpl();

	@PostMapping("getcoins")
	public int postCoins(@RequestBody CoinDispenserRequest amountRequest) {
		int denominators[] = { 1, 2, 3, 15};

		return coinDispencerImpl.getMinimum(denominators, Integer.parseInt(amountRequest.getAmount()));
	} 

}
