package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.UserInfoForm;
import cn.yesmylord.dms.form.UserInfoInsertForm;
import cn.yesmylord.dms.service.UserService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 董文浩
 * @Date 2021/2/4 17:37
 */
@RestController
@Api(tags = "用户控制接口")
@Slf4j
public class UserController {
    @Resource
    public UserService userService;

    @GetMapping("/user/list")
    @ApiOperation("用户信息列表接口")
    public ResponseVo userList(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "10") Integer pageSize){
        return userService.showUserList(pageNum, pageSize);
    }

    @GetMapping("/user/search")
    @ApiOperation("用户信息按名称查找")
    public ResponseVo userSearchById(@RequestParam String name,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "10") Integer pageSize){
        return userService.searchUserByName(name,pageNum,pageSize);
    }

    @PutMapping("/user/update")
    @ApiOperation("用户信息修改接口")
    public ResponseVo userInfoUpdate(@Valid @RequestBody UserInfoForm userInfoForm){
        return userService.updateUserInfo(userInfoForm);
    }

    @DeleteMapping("/user/delete")
    @ApiOperation("用户信息删除接口")
    public ResponseVo userInfoDelete(@Valid @RequestParam Integer userId){
        return userService.deleteUser(userId);
    }

    @PostMapping("/user/insert")
    @ApiOperation("用户信息增添接口")
    public ResponseVo userInfoInsert(@RequestBody UserInfoInsertForm userInfoInsertForm){
        return userService.insertUser(userInfoInsertForm);
    }


}
