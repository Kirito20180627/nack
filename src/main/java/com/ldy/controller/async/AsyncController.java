package com.ldy.controller.async;

import com.ldy.common.exception.ErrorCodeEnum;
import com.ldy.entity.vo.JsonResult;
import com.ldy.service.IAsyncTaskService;
import com.ldy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/async")
@Api(tags = {"Async Controller"}, value = "异步调用任务管理")
public class AsyncController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAsyncTaskService asyncTaskService;

    @ApiOperation(value = "测试异步调用方法", notes = "测试异步调用方法")
    @GetMapping("/task")
    public String doTask() {
        long currentTimeMills0 = System.currentTimeMillis();

        System.out.println("现在开始调用异步任务啦！");
        Future<String> future = asyncTaskService.dealHaveReturnTask();
//        if (future.isDone()) {
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            System.out.println(future.get());// future的get方法会阻塞当前线程哟
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long currentTimeMills1 = System.currentTimeMillis();
        String result = null;
        result = "本异步接口执行时间"+ (currentTimeMills1 - currentTimeMills0) + "ms";
        return result;

    }

    @ApiOperation(value = "测试get方式传参1", notes = "测试@PathVaribale 获取url中的数据")
    @GetMapping("/user/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    public JsonResult getUserById1(@PathVariable("id")int id) {
        JsonResult json = JsonResult.success();
        try {
            json.setData(userService.getById(id));
        } catch (Exception e) {
            json.setStatus(ErrorCodeEnum.SYS_ERROR.getCode());
            json.setMsg(ErrorCodeEnum.SYS_ERROR.getDesc());
        }
        return json;
    }

    @ApiOperation(value = "测试get方式传参2", notes = "@RequestParam 获取请求参数的值")
    @GetMapping("/user")
    public JsonResult getUserById2(@RequestParam("id")int userId) {
        JsonResult json = JsonResult.success();
        try {
            if(userService.getById(userId) == null) {
                json.setData("数据库中查询不到此数据");
            }// 这个判断没用
            json.setData(userService.getById(userId));

        } catch (Exception e) {
            json.setStatus(ErrorCodeEnum.SYS_ERROR.getCode());
            json.setMsg(ErrorCodeEnum.SYS_ERROR.getDesc());
        }
        return json;
    }

}
