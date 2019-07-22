package com.ccsia.demo.controller;

import com.ccsia.demo.model.Err;
import com.ccsia.demo.model.Result;
import com.ccsia.demo.model.ResultBuilder;
import com.ccsia.demo.model.Token;
import com.ccsia.demo.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApplyController {

    @Autowired AuthService authService;

    @RequestMapping(value = "/token")
    public Result getToken(String client_id, String client_secret){
        if(StringUtils.isBlank(client_id) || StringUtils.isBlank(client_secret))
            return ResultBuilder.error(Err.NULL_APPKEY_OR_SRCRET.getErrCode(), Err.NULL_APPKEY_OR_SRCRET.getErrMsg());
        if(!authService.checkThird(client_id, client_secret))
            return ResultBuilder.error(Err.NOT_MATCH_APPKEY_SECRET.getErrCode(), Err.NOT_MATCH_APPKEY_SECRET.getErrMsg());
        // Generate a new token each time you get a token
        Token token = authService.token(client_id, client_secret);
        return ResultBuilder.success(token);
    }

    @PostMapping(value = "/applicants")
    public Result getToken(String client_id,String access_token, String title, String content){
        if(!authService.checkToken(client_id, access_token))
            return ResultBuilder.error(Err.EXPIRED_TOKEN.getErrCode(), Err.EXPIRED_TOKEN.getErrMsg());
        // Processing subsequent applications
        return ResultBuilder.success();
    }

}
