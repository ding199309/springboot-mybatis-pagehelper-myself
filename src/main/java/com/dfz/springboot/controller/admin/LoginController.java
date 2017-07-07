package com.dfz.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dfz
 * @version 1.0
 * @E-mail: dfz@jkinvest.cn
 * @date 创建时间： 10:32  2017/7/7
 * @return
 *
 * 后台登录模块
 */

@Controller
@RequestMapping("/admin")
public class LoginController {



    @RequestMapping("/loginInit")
    public String  loginInit(){
        return "admin/login/login";
    }


}
