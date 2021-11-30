package com.chris.interview.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.chris.model.CoinDispenserRequest;
import com.chris.service.CoinDispenserService;

@Controller
public class CoinDispenserController {

	@GetMapping("/")
	public String getIndex(CoinDispenserRequest coinDispenserRequest) {

		return "index";
	}

	@PostMapping("/getcoins")
	public String getHome(@PathParam(value = "") int amount, @PathParam(value = "") String denominators,HttpSession session) {

		CoinDispenserService cvs = new CoinDispenserService();
		
		CoinDispenserRequest request = new CoinDispenserRequest();
		request.setAmount(amount);
		request.setDenominators(denominators);
		try {
			cvs.sendPost(request, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}

}
