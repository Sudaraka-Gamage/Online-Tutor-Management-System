/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roshan Withanage
 */
public class LoginController {

    private LoginController() {
    }

    private static final LoginController obj = new LoginController();

    public static LoginController getInstance() {
        return obj;
    }

    Connector con = Connector.getInstance();

    public List<String> validLogin(String username, String password) throws Exception {
        List<String> user = new ArrayList<String>();
        String uname = "";
        String pass = "";
        con.getConnection();
        ResultSet rs = con.srh("SELECT name, user_type FROM system_users WHERE username = '" + username + "' AND password = '" + password + "'");
        while (rs.next()) {
            uname = rs.getString(1);
            pass = rs.getString(2);
        }
        
        user.add(uname);
        user.add(pass);
        return user;
    }
}
