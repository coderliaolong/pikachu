package com.liaolong.pikachu.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author LiaoLong
 * @date 2021-12-05 21:14
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String email;

    private String avatar;

    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany()
    private List<Blog> blogs;
}
