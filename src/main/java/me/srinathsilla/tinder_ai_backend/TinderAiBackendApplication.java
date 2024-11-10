package me.srinathsilla.tinder_ai_backend;

import me.srinathsilla.tinder_ai_backend.conversations.ConversationRepository;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileCreationService;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

//	@Autowired
//	private ProfileRepository profileRepository;
//
//	@Autowired
//	private ConversationRepository conversationRepository;

	@Autowired
	private ProfileCreationService profileCreationService;

	@Autowired
	public OpenAiChatClient chatModel;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		Prompt prompt = new Prompt("Tell me a joke");
//		ChatResponse response = chatModel.call(prompt);
//		System.out.println(response.getResult().getOutput().getContent());
//
//		profileRepository.deleteAll();
//		conversationRepository.deleteAll();
//
//		Profile profile = new Profile(
//				"1",
//				"Srinath",
//				"Silla",
//				"25",
//				"Indian",
//				Gender.MALE,
//				"Software Engineer",
//				"https://www.google.com",
//				"INTJ"
//		);
//
//		profileRepository.save(profile);
//
//		profile = new Profile(
//				"2",
//				"John",
//				"Doe",
//				"25",
//				"Indian",
//				Gender.MALE,
//				"Software Engineer",
//				"https://www.google.com",
//				"INTJ"
//		);
//		profileRepository.save(profile);
//		profileRepository.findAll().forEach(System.out::println);
//
//		Conversation conversation = new Conversation(
//				"1",
//				profile.id(),
//				List.of(
//						new ChatMessage("Hello", profile.id(), LocalDateTime.now())
//				)
//		);
//
//		conversationRepository.save(conversation);
//		conversationRepository.findAll().forEach(System.out::println);

		profileCreationService.saveProfilesToDB();
	}
}
