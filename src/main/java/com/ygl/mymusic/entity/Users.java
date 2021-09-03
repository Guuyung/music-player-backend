package com.ygl.mymusic.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

    private int id;

    private String username;

    private String password;

    private int isadmin;

    private String email;

    private String mark1;

    private String mark2;

    public Users(String username, String password, int isadmin, String email) {
        this.username = username;
        this.password = password;
        this.isadmin = isadmin;
        this.email = email;
    }
}
