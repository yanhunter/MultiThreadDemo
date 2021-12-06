package com.springboot.SpringBootRestfulDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

	static Map<Integer, Account> accounts = new HashMap<
	    	Integer, Account>();
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
    List<Account> getAccountList()
    {
		return new ArrayList<Account>(accounts.values());
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    String postAccount(@ModelAttribute Account account)
    {
    	accounts.put(account.getId(), account);
    	return "OK";
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    Account getAccount(@PathVariable Integer id)
    {
    	//return accounts.get(id);
    	Account account = new Account();
    	account.setId(id);
    	account.setAccountName("Peter");
    	return account;
    }

    @RequestMapping(value="/account/{id}", method=RequestMethod.PUT)
    String putAccount(@PathVariable Integer id, @ModelAttribute Account account)
    {
    	accounts.put(id, account);
    	return "OK";
    }

    @RequestMapping(value="/account/{id}", method=RequestMethod.DELETE)
    String deleteUser(@PathVariable Integer id)
    {
    	accounts.remove(id);
    	return "OK";
    }
}
