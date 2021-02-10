package ohtu.services;

import static java.lang.Character.isLetter;
import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        
        //username long enough and not yet used
        if (username.length() < 3 && userDao.findByName(username) == null) {
            return true;
        }
        
        //password long enough
        if (password.length() < 8) {
            return true;
        }
        
        //password must have other characters than alphabets
        int counter = 0;
        for (char passchar : password.toCharArray()) {
            if (!isLetter(passchar)) {
                return false;
            }
            counter++;
            if (counter == password.length()) {
                return true;
            }
        }
        
        return false;
    }
}
