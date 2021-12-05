package com.liaolong.pikachu.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author LiaoLong
 * @date 2021-12-05 20:58
 */
@Data
@Entity
@Table(name = "t_blog")
public class Blog {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;

    private String picture;
    private String tag;
    private Integer views;
    private boolean appreciation;
    private boolean share;
    private boolean commentEnabled;
    private boolean published;
    private boolean recommended;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    /**
     * 标签, 级联新增
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tag> tags;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;
}
