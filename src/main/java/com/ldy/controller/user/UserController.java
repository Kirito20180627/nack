package com.ldy.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ldy.common.config.annotation.CheckToken;
import com.ldy.entity.dao.UserMapper;
import com.ldy.entity.form.UserForm;
import com.ldy.entity.po.User;
import com.ldy.entity.vo.JsonResult;
import com.ldy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nack/user")
@Api(tags = {"用户管理模块"})
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/list")
    public List<User> selectWithJson() {
        return userMapper.selectWithJson();
    }

    @GetMapping("/search")
    public JSONObject searchUserById(@RequestParam("id")String id) {
        JSONObject json = new JSONObject();
        User user = userService.getById(Integer.valueOf(id));
        json.put("user", user);
        return json;
    }

    @PostMapping(value = "/testRequestBody")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "int", paramType = "body"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "body")
    })
    public JsonResult add(@RequestBody User user) {
        JsonResult json = JsonResult.success();
        System.out.println(user.toString());
        return json;
    }


    @PostMapping(value = "/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "remark", value = "备注", dataType = "JsonObject", paramType = "body")
    })
    public JsonResult insertWithJson(@Valid User user) {
//        User user = new User();
//        user.setName("lily");
//        user.setPassword("001");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("性别", "女");
//        user.setRemark(jsonObject);
        JsonResult json = JsonResult.success();
        try {
            userMapper.insertWithJson(user);
        } catch (Exception e) {
            json.setMsg("插入失败");
        }
        return json;
    }

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
