/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbcontext.DBContext;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hieu Mau
 */
public class UserDAO extends DBContext {

    /**
     * Check existed user name
     *
     * @param username
     * @return false if name is existed, true if not existed
     */
    public boolean checkUsername(String username) {
        int count = 0;
        ResultSet rs = null;
        String sql = "SELECT username FROM [Users] where username = ?";

        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return count == 0;
    }

    /**
     * Check existed account
     *
     * @param username
     * @param password
     * @return User if existed
     */
    public User checkAccount(String username, String password) {
        ResultSet rs = null;
        String sql = "  SELECT * FROM [Users] where username = ? and [password] = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Add new Account
     *
     * @param username
     * @param password
     * @param role
     * @param email
     * @return true if add successful, false if fail
     */
    public boolean addAccount(String username, String password, int role, String email) {
        String sql = "insert into [Users]([username],[password],[role],[email])\n"
                + "  values (?,?,?,?)";
        int check = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if (checkUsername(username) != true || checkAccount(username, password) == null) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setInt(3, role);
                ps.setString(4, email);
                check = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
