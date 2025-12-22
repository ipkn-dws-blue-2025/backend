package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.controller.util.ControllerConstants;
import com.itmo.ipkn.team6.service.impl.ThresholdSettingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ControllerConstants.BASE_API_PATH)
public class ThresholdSettingUserController {

    private final ThresholdSettingUserService thresholdSettingUserService;


}
