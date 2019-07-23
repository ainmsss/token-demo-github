package com.ccsia.demo.controller;

import com.alibaba.fastjson.JSON;
import com.ccsia.demo.model.Err;
import com.ccsia.demo.model.Result;
import com.ccsia.demo.model.ResultBuilder;
import com.ccsia.demo.model.Token;
import com.ccsia.demo.model.business.ApplyInfo;
import com.ccsia.demo.model.params.ApplicantParams;
import com.ccsia.demo.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApplyController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired AuthService authService;

    @RequestMapping(value = "/token")
    public Token getToken(String client_id, String client_secret){
        Token token = new Token();
        if(StringUtils.isBlank(client_id) || StringUtils.isBlank(client_secret)) {
            token.setError(Err.NULL_APPKEY_OR_SRCRET.getErrMsg());
            return token;
        }
        if(!authService.checkThird(client_id, client_secret)) {
            token.setError(Err.NOT_MATCH_APPKEY_SECRET.getErrMsg());
            return token;
        }
        // Generate a new token each time you get a token
        token = authService.token(client_id, client_secret);
        return token;
    }

    @PostMapping(value = "/applicants")
    public Result applicants(String client_id, String access_token, @RequestBody ApplyInfo applyInfo){
        if(!authService.checkToken(client_id, access_token))
            return ResultBuilder.error();
        // Processing subsequent applications
        logger.info("content : {}", JSON.toJSONString(applyInfo));
        return ResultBuilder.success();
    }

}
