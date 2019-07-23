package com.ccsia.demo.service;

import com.alibaba.fastjson.JSON;
import com.ccsia.demo.model.ThirdParty;
import com.ccsia.demo.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AuthService {

    @Autowired RedisTemplate redisTemplate;

    public Token token(String client_id, String client_secret){
        ThirdParty thirdParty = find(client_id, client_secret);
        Token token = new Token(thirdParty.getClient_id());
        save(token);
        return token;
    }

    public boolean checkThird(String client_id, String client_secret){
        // check appkey and secret in db
        return true;
    }

    public boolean checkToken(String client_id, String access_token){
        BoundValueOperations bvo = redisTemplate.boundValueOps(client_id);
        Object o = bvo.get();
        if(o == null)
            return false;
        Token t = JSON.parseObject(o.toString(), Token.class);
        if(t.getAccess_token().equals(access_token))
            return true;
        else
            return false;
    }

    private ThirdParty find(String client_id, String client_secret){
        //selected thirdParty by client_id and client_secret
        return new ThirdParty(client_id);
    }

    /**
     * storage token
     * @param token
     */
    private void save(Token token) {
        BoundValueOperations bvo = redisTemplate.boundValueOps(token.getClient_id());
        // the setting 2 hours expired
        bvo.set(JSON.toJSONString(token), token.getExpires_in(), TimeUnit.SECONDS);
    }
}
