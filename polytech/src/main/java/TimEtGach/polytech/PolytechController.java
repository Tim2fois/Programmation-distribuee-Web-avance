package TimEtGach.polytech;

import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PolytechController {


	public final Map<Long, User> users = new HashMap<>();
	public final AtomicLong counter = new AtomicLong();

	@GetMapping("/users")
	public Collection<User> users(){
		return users.values();
	}

	@PostMapping("/users")
	public User create_user(@RequestBody User user){
	long new_id = counter.incrementAndGet();
	user.setId(new_id);
	users.put(new_id,user);

	return user;

	}

	@GetMapping("/users/{id}")
	public User specific_user(@PathVariable(value = "id") Long id) {
		if (!users.containsKey(id))
			throw new UserNotFoundException(id);
		return users.get(id);
	}



}

