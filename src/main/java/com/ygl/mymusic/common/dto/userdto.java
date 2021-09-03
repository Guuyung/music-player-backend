package com.ygl.mymusic.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
@Data
public class userdto {

//    @NotBlank(message = "邮箱不能为空")
    private String username;

//    @NotBlank(message = "密码不能为空")
    private String password;

}