package com.cg.spring.cntorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.book.service.BankService;
import com.cg.book.service.BankServiceImpl;

@Controller
public class BankController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}

	@RequestMapping("/balance")
	public String balance(@RequestParam("custid") String custId, @RequestParam("ammount") String ammount, Model model) {
		BankService service = new BankServiceImpl();

		int res = (int) service.withdraw(Integer.parseInt(custId), Integer.parseInt(ammount));
		model.addAttribute("balance", res);
		return "balance";
	}
	@RequestMapping("/deposit")
	public String deposit()
	{
		return "deposit";
	}
	@RequestMapping("/depositbalance")
	public String depositbalance(@RequestParam("custid") String custId, @RequestParam("ammount") String ammount, Model model) {
		BankService service = new BankServiceImpl();

		int res = (int) service.deposit(Integer.parseInt(custId), Integer.parseInt(ammount));
		model.addAttribute("balance", res);
		return "depositbalance";
	}

}
