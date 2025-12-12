package com.itmo.ipkn.team6.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itmo/ipkn/team6/api")
public class VMBaseMonitoringController {

    @GetMapping("/get-list-vms")
    public List<VmDto> getListOfVms(HttpSession httpSession){


    }


}
