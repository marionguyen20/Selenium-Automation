package Railway;

import Utilities.Utilities;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Account {
    private String email;
    private String password;
    private String pid;

    public Account () {
        this.email = Utilities.generateEmail();
        this.password = Utilities.generatePassword();
        this.pid = Utilities.generatePid();
    }
    public Account (String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Account (String email, String password, String pid) {
        this.email = email;
        this.password = password;
        this.pid = pid;
    }

    public String getEmail () {
        return this.email;
    }
    public String getPassword () {
        return this.password;
    }
    public String getPid () {
        return this.pid;
    }
}
