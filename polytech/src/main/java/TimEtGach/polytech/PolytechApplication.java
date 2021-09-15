package TimEtGach.polytech;

import TimEtGach.polytech.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class PolytechApplication {


	public static void main(String[] args) {
		SpringApplication.run(PolytechApplication.class, args);
	}
}

