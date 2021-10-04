package TimEtGach.polytech;

import org.jetbrains.annotations.NotNull;

public class    User {

    private long userId;
    private String firstname;
    private String lastname;
    private int age;

    @NotNull(message = "")


    public User(long id, String firstname, String lastname, int age){
        this.userId = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    /* initialisation ID */
    public long getId(){ return userId; }

    /* initialisation first_name */
    public String getFirstname(){ return firstname; }
    public void setFirstname(String firstname){ this.firstname = firstname; }

    /* initialisation last_name */
    public String getLastname(){ return lastname; }
    public void setLastname(String lastname){ this.lastname = lastname; }

    /* initialisation Age */
    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public void setId(long id){
        this.userId = id;
    }


}
