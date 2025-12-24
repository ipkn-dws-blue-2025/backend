package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.util.Constants;
import com.itmo.ipkn.team6.dto.rest.VmListResponse;
import com.itmo.ipkn.team6.service.impl.VMBaseMonitoringService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.Controller.BASE_API_PATH)
public class VMBaseMonitoringController {

    private final VMBaseMonitoringService vmBaseMonitoringService;

    @GetMapping("/get-list-vms")
    public VmListResponse getListOfVms(HttpSession httpSession) {
        return vmBaseMonitoringService.getListOfVms(httpSession);
    }
}
