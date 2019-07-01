package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 王铭
 * @Date 2019/6/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
}
