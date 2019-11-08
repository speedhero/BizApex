package com.apex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Controller
@RequestMapping("view")
public class DemoController {
	
	@RequestMapping
	public String index(Model model){
		model.addAttribute("accounts",new AccountService().findAll());
		return "index";
	}
	
	@RequestMapping(params="action=edit")
	public String edit(@RequestParam("id") String id, Model model){
		model.addAttribute("account",new AccountService().get(id));
		return "edit";
	}
	
	@RequestMapping(params="action=add")
	public String newAccount(){
		return "add";
	}
	
	@RequestMapping(params="action=create")
	public void create(ActionRequest request,ActionResponse response,@ModelAttribute("account")Account account,Model model){
		AccountService as=new AccountService();
		as.insert(account);
		model.addAttribute("accounts",as.findAll());
		response.setRenderParameter("action","index");
	}
	
	@RequestMapping(params="action=update")
	public void update(ActionResponse response,@ModelAttribute("account")Account account,Model model){
		AccountService as=new AccountService();
		as.get(account.getId()).setUsername(account.getUsername());
		model.addAttribute("accounts",as.findAll());
		response.setRenderParameter("action","index");
	}
	
	@RequestMapping(params="action=delete")
	public String delete(@RequestParam("id") String id, Model model){
		AccountService as=new AccountService();
		as.remove(id);
		model.addAttribute("accounts",as.findAll());
		return "index";
	}
	
}
