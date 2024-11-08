package me.srinathsilla.tinder_ai_backend;

import me.srinathsilla.tinder_ai_backend.profiles.Gender;
import me.srinathsilla.tinder_ai_backend.profiles.Profile;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Profile profile = new Profile(
				"1",
				"Srinath",
				"Silla",
				"25",
				"Hindu",
				Gender.MALE,
				"Software Engineer",
				"https://www.google.com",
				"INTJ"
		);

		profileRepository.save(profile);
		profileRepository.findAll().forEach(System.out::println);
	}
}
