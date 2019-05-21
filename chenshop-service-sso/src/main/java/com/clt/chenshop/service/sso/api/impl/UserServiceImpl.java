package com.clt.chenshop.service.sso.api.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.mapper.TbUserMapper;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbUser;
import com.clt.chenshop.service.redis.api.JedisSentinel;
import com.clt.chenshop.service.sso.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2019-01-02 16:52
 **/

@Service(version = DubboVersionConstant.DUBBO_SSO_SENTINEL_VERSION)
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Reference(version = DubboVersionConstant.DUBBO_JEDIS_CLIENT_SENTINEL_VERSION)
    private JedisSentinel jedisSentinel;

    @Override
    public BaseResult check(String param, Integer type) {
        Example example = new Example(TbUser.class);

        if (1 == type){
            example.createCriteria().andEqualTo("username",param);
        }

        else  if (2 == type){
            example.createCriteria().andEqualTo("phone",param);
        }

        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if (tbUsers == null || tbUsers.size() == 0 ){
            return BaseResult.ok(true);
        }

        return BaseResult.ok(false);
    }

    @Override
    public BaseResult register(TbUser tbUser) {
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        //给密码加密
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
        tbUserMapper.insert(tbUser);
        return BaseResult.ok();
    }

    @Override
    public BaseResult login(String username, String password) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username",username);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
        if (tbUsers == null || tbUsers.size() == 0){
            return BaseResult.build(400,"用户名或密码错误");
        }
        TbUser tbUser = tbUsers.get(0);
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(tbUser.getPassword())){
            return BaseResult.build(400,"用户名或密码错误");
        }

        return BaseResult.ok();
    }
}
