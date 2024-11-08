package me.srinathsilla.tinder_ai_backend.conversations;

import me.srinathsilla.tinder_ai_backend.profiles.ProfileRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class ConversationController {

    @Autowired
    public ConversationRepository conversationRepository;

    @Autowired
    public ProfileRepository profileRepository;

    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository){
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/conversations")
    public Conversation createConversation(@RequestBody CreateConversationRequest request){
        profileRepository.findById(request.profileId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found with id: " + request.profileId()));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId(),
                new ArrayList<>()
        );

        conversationRepository.save(conversation);
        return conversation;
    }

    public record CreateConversationRequest(
            String profileId
    ){}
}
