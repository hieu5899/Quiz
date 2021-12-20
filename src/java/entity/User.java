/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Hieu Mau
 */
public class User {
    /**
     * Store username
     */
    private String username;
    /**
     * Store password
     */
    private String password;
    /**
     * Store role of user
     */
    private int role;
    /**
     * Store email
     */
    private String email;
    /**
     * Constructor
     */
    public User() {
    }
    /**
     * Constructor
     * @param username
     * @param password
     * @param role
     * @param email 
     */
    public User(String username, String password, int role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
