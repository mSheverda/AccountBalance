package com.transactions.controller;


import com.transactions.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
   AccountService accountService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("account", this.accountService.getAccount());
        modelAndView.addObject("transactions", this.accountService.getAccount().getTransactionList());
        modelAndView.setViewName("client/main");
        return modelAndView;
    }


    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public ModelAndView getDepositPage(ModelAndView modelAndView) {
        modelAndView.setViewName("client/formDeposit");
        return modelAndView;
    }

    @RequestMapping(value = "/save_deposit", method = RequestMethod.POST)
    public ModelAndView saveDeposit(@RequestParam String amount,
                                     ModelAndView modelAndView)
    {
        this.accountService.deposit(Double.parseDouble(amount));
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public ModelAndView getWithdrawPage(ModelAndView modelAndView) {
        modelAndView.setViewName("client/formWithdraw");
        return modelAndView;
    }

    @RequestMapping(value = "/save_withdraw", method = RequestMethod.POST)
    public ModelAndView saveWithdraw(@RequestParam String amount,
                                     ModelAndView modelAndView)
    {
        try {
            this.accountService.withdraw(Double.parseDouble(amount));
            modelAndView.setViewName("redirect:/");
        }
        catch (Exception e)
        {
                        modelAndView.setViewName("client/error");
            return modelAndView;
        }
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam String amount,
                                     ModelAndView modelAndView)
    {

            this.accountService.addAccount();
            modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}