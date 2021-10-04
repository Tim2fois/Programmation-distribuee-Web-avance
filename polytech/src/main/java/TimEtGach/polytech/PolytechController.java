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
public class UserController  {


	private Map<Long, User> users = new HashMap<>();
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/users")
	@CrossOrigin
	public Collection<User> users(){
		return users.values();
	}

	@PostMapping(path= "/users")
	public User users(@RequestBody @Valid User user) {
		long new_id = counter.incrementAndGet();
		user.setId(new_id);
		users.put(new_id, user);
		NewUser authUser = new NewUser(new_id, "test_password");
		RestTemplate restTemplate = new RestTemplate();
		Long check_id = restTemplate.postForObject("http://localhost:8081" + "/users", authUser, Long.class);
		if (check_id != new_id)
			throw new RuntimeException();
		return user;
	}

	@PostMapping(path = "/users/{id}/firstname")
	public String set_user_firstname(@RequestBody String firstname,
									 @PathVariable(value = "id") Long id,
									 @RequestHeader(value = "X-Token") String token) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Token", token);
		HttpEntity entity = new HttpEntity<String>("", headers);

		ResponseEntity<Long> response = restTemplate.exchange("http://localhost:8081" + "/token",
				HttpMethod.GET, entity, Long.class);
		Long token_user = response.getBody();
		if (token_user != id)
			throw new RuntimeException();

		users.get(id).setFirstname(firstname);
		return firstname;
	}

	@PostMapping(path = "/users/{id}/lastname")
	public String set_user_lastname(@RequestBody String lastname,
									@PathVariable(value = "id") Long id,
									@RequestHeader(value = "X-Token") String token) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Token", token);
		HttpEntity entity = new HttpEntity<String>("", headers);

		ResponseEntity<Long> response = restTemplate.exchange("http://localhost:8081" + "/token",
				HttpMethod.GET, entity, Long.class);
		Long token_user = response.getBody();
		if (token_user != id)
			throw new RuntimeException();

		users.get(id).setLastname(lastname);
		return lastname;
	}

	@PostMapping(path = "/users/{id}/age")
	public int set_user_name(@RequestBody int age,
							 @PathVariable(value = "id") Long id,
							 @RequestHeader(value = "X-Token") String token) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Token", token);
		HttpEntity entity = new HttpEntity<String>("", headers);

		ResponseEntity<Long> response = restTemplate.exchange("http://localhost:8081" + "/token",
				HttpMethod.GET, entity, Long.class);
		Long token_user = response.getBody();
		if (token_user != id)
			throw new RuntimeException();

		users.get(id).setAge(age);
		return age;
	}


	@GetMapping("/users/{id}")
	@CrossOrigin
	public User specific_user(@PathVariable(value = "id") Long id) {
		if(!users.containsKey(id))
			throw new UserNotFoundException(id);
		return users.get(id);
	}

	@DeleteMapping("/users/{id}")
	@CrossOrigin
	public String delete_user(@PathVariable(value = "id") Long id) {
		users.remove(id);
		return "L'utilisateur " + id + " a été supprimé";
	}

	@PutMapping("/users/{id}")
	@CrossOrigin
	public User modifyUserById(@PathVariable(value = "id")Long id, @Valid @RequestBody User user ) {
		if(!users.containsKey(id))
			throw new UserNotFoundException(id);

		User u = users.get(id);
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		u.setAge(user.getAge());
		users.put(u.getId(), u);
		return u;
	}
}

