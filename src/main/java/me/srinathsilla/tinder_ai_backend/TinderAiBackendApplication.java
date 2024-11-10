package me.srinathsilla.tinder_ai_backend;

import me.srinathsilla.tinder_ai_backend.conversations.ConversationRepository;
import me.srinathsilla.tinder_ai_backend.matches.MatchRepository;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileCreationService;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

	@Autowired
	private ConversationRepository conversationRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private ProfileCreationService profileCreationService;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		clearAllData();
		profileCreationService.createProfiles(0);
		profileCreationService.saveProfilesToDB();
	}

	private void clearAllData(){
		conversationRepository.deleteAll();
		profileRepository.deleteAll();
		matchRepository.deleteAll();
	}
}
