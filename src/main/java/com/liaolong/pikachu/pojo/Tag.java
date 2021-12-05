package com.liaolong.pikachu.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author LiaoLong
 * @date 2021-12-05 21:07
 */

@Data
@Entity
@Table(name = "t_blog")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs;
}
