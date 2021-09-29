package TimEtGach.polytech;

import ch.qos.logback.core.subst.Token;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PolytechController {


	public final Map<Long, User> users = new HashMap<>();
	public final Map<String, Token> tokens = new HashMap<>();
	public final Map<Long, Set<String>> user_to_token = new HashMap<>();
	public final AtomicLong counter = new AtomicLong();

	@GetMapping("/users")
	public Collection<User> users(){
		return users.values();
	}

	@PostMapping("/users")
	public long create_user(@RequestBody User user) {
		if (users.containsKey(user.getId()))
			throw new UserExistException(user.getId());
		users.put(user.getId(), user);
		return user.getId();
	}

	@GetMapping("/users/{id}")
	public long user(@PathVariable(value = "id") Long id) {
		if (!users.containsKey(id))
			throw new UserNotFoundException(id);
		return id;
	}

	@PutMapping("/users/{id}")
	public User modifify_user(@PathVariable(value = "id") Long id) {
		if (!users.containsKey(id))
			throw new UserNotFoundException(id);
		return users.get(id);
	}


	@DeleteMapping("/users/{id}")
	public User delete_user(@PathVariable(value = "id") Long id) {
		if (!users.containsKey(id))
			throw new UserNotFoundException(id);
		return users.get(id);
	}


}

