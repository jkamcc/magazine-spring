package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 19/10/13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="UserArticle")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name="userId")
    private long userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="profileId")
    private long profileId;

    @Column(name="profile")
    private int profile;

    @OneToMany (mappedBy="commentId" )
    private Set<Comment> comentarios;
}
