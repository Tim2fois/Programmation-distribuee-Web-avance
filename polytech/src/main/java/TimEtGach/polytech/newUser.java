package TimEtGach.polytech;

import javax.validation.constraints.NotNull;
import java.sql.Struct;

public class NewUser {

    @NotNull(message ="Id required")
    private long userId;

    @NotNull(message ="Pswd required")
    private String password;

    public NewUser(long id, String password){
        this.userId = id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }
}