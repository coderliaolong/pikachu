package com.liaolong.pikachu.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author LiaoLong
 * @date 2021-12-05 21:10
 */

@Entity
@Data
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments;

    @ManyToOne
    private Comment parentComment;

    @ManyToOne
    private Blog blog;
}
