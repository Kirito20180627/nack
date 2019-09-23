package com.ldy.controller.user;

import com.ldy.common.config.annotation.CheckToken;
import com.ldy.entity.form.UserForm;
import com.ldy.entity.vo.JsonResult;
import com.ldy.service.IUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/nack/user")
@Api(tags = {"用户管理模块"})
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @CheckToken
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult add(@Valid UserForm user) {
        JsonResult json = JsonResult.success();
        try {
            userService.add(user);
        }catch (Exception e) {
            json.setStatus("添加失败");
            json.setMsg("添加失败");
        }
        return json;
    }

    @CheckToken
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public JsonResult all() {
        JsonResult json = JsonResult.success();
        try {
            json.setData(userService.list());
        }catch (Exception e) {
            json.setStatus("查询失败");
            json.setMsg("查询失败");
        }
        return json;
    }
}
