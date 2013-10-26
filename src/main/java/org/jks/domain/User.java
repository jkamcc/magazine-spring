package org.jks.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 19/10/13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "UserArticle", schema = "", catalog = "magazine")
@Entity
public class User implements Serializable {
    private int userid;
    private String username;
    private String email;
    private String profile;
    private Integer profileid;

    @javax.persistence.Column(name = "userid")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @javax.persistence.Column(name = "username")
    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @javax.persistence.Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @javax.persistence.Column(name = "profile")
    @Basic
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @javax.persistence.Column(name = "profileid")
    @Basic
    public Integer getProfileid() {
        return profileid;
    }

    public void setProfileid(Integer profileid) {
        this.profileid = profileid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (profile != null ? !profile.equals(user.profile) : user.profile != null) return false;
        if (profileid != null ? !profileid.equals(user.profileid) : user.profileid != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (profileid != null ? profileid.hashCode() : 0);
        return result;
    }
}
