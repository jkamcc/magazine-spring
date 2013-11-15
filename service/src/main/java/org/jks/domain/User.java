package org.jks.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author juancarrillo
 */
@javax.persistence.Table(name = "UserArticle", schema = "", catalog = "magazine")
@Entity
@JsonIgnoreProperties("authority")
public class User implements GrantedAuthority, Serializable {
    private long userid;

    @javax.persistence.Column(name = "userid", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    private String username;

    @NotBlank
    @Size(max=20)
    @javax.persistence.Column(name = "username", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;

    @Size(max=50)
    @Email
    @Basic
    @javax.persistence.Column(name = "email", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    @NotBlank
    @Size(max=40)
    @javax.persistence.Column(name = "password", nullable = false, insertable = true, updatable = true, length = 40, precision = 0)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;

    @NotBlank
    @Size(max=100)
    @javax.persistence.Column(name = "name", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String profile;

    @NotBlank
    @Size(max=30)
    @Basic
    @javax.persistence.Column(name = "profile", nullable = true, insertable = true, updatable = true, length = 30, precision = 0)
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private Byte profileid;

    @NotNull
    @Min(0)
    @Basic
    @javax.persistence.Column(name = "profileid", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
    public Byte getProfileid() {
        return profileid;
    }

    public void setProfileid(Byte profileid) {
        this.profileid = profileid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (profile != null ? !profile.equals(user.profile) : user.profile != null) return false;
        if (profileid != null ? !profileid.equals(user.profileid) : user.profileid != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userid ^ (userid >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (profileid != null ? profileid.hashCode() : 0);
        return result;
    }

    @Transient
    public static String sha1(String input) throws NoSuchAlgorithmException {

        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    @Override
    @Transient
    public String getAuthority() {
        return this.profile;
    }
}
