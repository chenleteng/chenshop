package com.clt.chenshop.service.sso.api;

import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbUser;

public interface UserService {
    public BaseResult check(String param,Integer type);

    public BaseResult register(TbUser tbUser);

    public BaseResult login(String username,String password);
}
