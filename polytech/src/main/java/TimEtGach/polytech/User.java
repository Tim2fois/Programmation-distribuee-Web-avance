package TimEtGach.polytech;

import org.jetbrains.annotations.NotNull;

public class    User {

    @NotNull(message = "Id required")
    private long id;

    @NotNull(message = "Password required")
    private String password;

    @NotNull
    private String name;
    private String email;


    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

    public getList(){
        return
    }
    public long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
