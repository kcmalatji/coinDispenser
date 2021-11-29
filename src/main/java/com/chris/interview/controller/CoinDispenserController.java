package com.chris.interview.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.model.CoinDispenserRequest;
import com.chris.service.CoinDispenserService;

@Controller
public class CoinDispenserController {
	
	@GetMapping("/")
	public String getIndex(CoinDispenserRequest amountRequest) {
		
		return "index";
	}

	@PostMapping("/getcoins")
	public String getHome( @PathParam(value = "") String amount) {
		
		CoinDispenserService cvs = new CoinDispenserService();
		try {
			cvs.sendPost(amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}



}
