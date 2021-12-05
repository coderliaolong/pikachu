package com.liaolong.pikachu.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author LiaoLong
 * @date 2021-12-05 21:06
 */
@Data
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs;
}
