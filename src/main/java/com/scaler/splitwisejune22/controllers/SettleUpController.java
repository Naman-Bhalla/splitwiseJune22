package com.scaler.splitwisejune22.controllers;

import com.scaler.splitwisejune22.dtos.SettleUpUserRequestDto;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {

    public void settleUser(SettleUpUserRequestDto request) {
        // authorize the request -> api gateway -> Kong
        // ->SpringSecurity

        // takes the request
        // calls the service
        // takes their response
        // wraps and return

    } // UserController
    // List<Something>
    // Something: amount, user,
    // [
    //     {from: Swaroop amount: 50}
    //     {from: Laksh   amount: 100}
    //     {from: Ranjan  amount: -100}
    // ]
    // [
    //     {from: Swaroop to: Naman amount: 50} -> Transaction
    //     {from: Laksh   to: Naman amount: 100}
    //     {from: Naman   to: Ranjan amount: 100}
    // ]

    public void settleGroup() {


    } // Group Controller
}

//  /settleUp?group_id=123
