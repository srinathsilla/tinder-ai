package me.srinathsilla.tinder_ai_backend.matches;

import me.srinathsilla.tinder_ai_backend.conversations.Conversation;
import me.srinathsilla.tinder_ai_backend.conversations.ConversationRepository;
import me.srinathsilla.tinder_ai_backend.profiles.Profile;
import me.srinathsilla.tinder_ai_backend.profiles.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MatchController {

    private final ProfileRepository profileRepository;
    private final ConversationRepository conversationRepository;
    private final MatchRepository matchRepository;


    public MatchController(ProfileRepository profileRepository, ConversationRepository conversationRepository, MatchRepository matchRepository) {
        this.profileRepository = profileRepository;
        this.conversationRepository = conversationRepository;
        this.matchRepository = matchRepository;
    }

    public record createMatchRequest(String profileId){}

    @CrossOrigin(origins = "*")
    @PostMapping("/matches")
    public Match createNewMatch(@RequestBody createMatchRequest request){
        Profile profile = profileRepository.findById(request.profileId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found with id: " + request.profileId()));

        // TODO: Make sure there's no existing conversation with this profile already
        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                profile.id(),
                new ArrayList<>()
        );

        conversationRepository.save(conversation);

        Match match = new Match(
                UUID.randomUUID().toString(),
                profile,
                conversation.id()
        );

        matchRepository.save(match);
        return match;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/matches")
    public List<Match> getAllMatches(){
        return matchRepository.findAll();
    }

}
