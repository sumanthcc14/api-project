import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class VotingApp {

    private final Map<String, Integer> candidates = new HashMap<>();

    @GetMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        candidates.put(name, 0);
        return "Candidate " + name + " entered with 0 votes.";
    }

    @GetMapping("/castvote")
    public String castVote(@RequestParam String name) {
        if (candidates.containsKey(name)) {
            int currentVotes = candidates.get(name);
            candidates.put(name, currentVotes + 1);
            return "Vote cast for " + name + ". Total votes: " + (currentVotes + 1);
        } else {
            return "Invalid candidate.";
        }
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        if (candidates.containsKey(name)) {
            return "Votes for " + name + ": " + candidates.get(name);
        } else {
            return "Invalid candidate.";
        }
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return candidates;
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return "Winner: " + (maxEntry != null ? maxEntry.getKey() : "No votes yet");
    }

    public static void main(String[] args) {
        SpringApplication.run(VotingApp.class, args);
    }
}