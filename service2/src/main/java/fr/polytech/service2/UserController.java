package fr.polytech.service2;

import ch.qos.logback.core.subst.Token;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
@RestController
public class UserController {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    public final Map<String, Token> tokens = new HashMap<>();
    public final Map<Long, Set<String>> user_to_token = new HashMap<>();

    @GetMapping("/users")
    public Collection<User> users() {
        return users.values();
    }

    @PostMapping("/users")
    public User create_user(@RequestBody @Valid User user) {
        long new_id = counter.incrementAndGet();
        user.setId(new_id);
        users.put(new_id, user);

        return user;
    }

    @GetMapping("/users/{id}")
    public User specific_user(@PathVariable(value = "id") Long id) {
        if(!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        return users.get(id);

    }

    @GetMapping("/users/{id}/name")
    public String specific_user_name(@PathVariable(value = "id") Long id) {
        if(!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        return users.get(id).getName();

    }

    @DeleteMapping("/users/{id}")
    public String delete_user(@PathVariable(value = "id") Long id) {
        String result = "Aucun élement supprimé";
        if (users.containsKey(id)) {
            users.remove(id);
            result = String.format("L'utilisateur %s a été supprimé!", id.toString());
        }

        return result;
    }

    @PostMapping("/users/{id}/name")
    public String edit_user_name(@PathVariable(value = "id") Long id, @RequestBody @Valid String name, String token) {
        String result = "";
        if(!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        else {
            result = "Le token ne correspond pas";
            if(users.get(id).getToken() == token) {
                User user = new User(id, name, users.get(id).getPassword(), users.get(id).getToken());
                users.remove(id);
                users.put(id, user);
                result = users.get(id).toString();
            }
        }
        return token ;
        //return users.get(id).getName();
    }

    @PostMapping("/users/{id}/password")
    public String edit_user_password(@PathVariable(value = "id") Long id, @RequestBody @Valid String password, String token) {
        if(!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        else {
            if(users.get(id).getToken() == token) {
                users.get(id).setPassword(password);
            }
        }
        return users.get(id).getPassword();
    }

}
