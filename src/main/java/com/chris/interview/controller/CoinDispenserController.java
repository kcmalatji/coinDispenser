package com.chris.interview.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chris.model.CoinDispenserRequest;
import com.chris.service.CoinDispenserService;

@Controller
public class CoinDispenserController {

	@GetMapping("/")
	public String getIndex(CoinDispenserRequest coinDispenserRequest) {

		return "index";
	}

	@PostMapping("/getcoins")
	public String getHome(@PathParam(value = "") String amount, Model model, HttpSession session) {

		CoinDispenserService cvs = new CoinDispenserService();

		try {
			cvs.sendPost(amount, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}

}
