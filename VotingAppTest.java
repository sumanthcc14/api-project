import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VotingAppTest {

    @Mock
    private Map<String, Integer> candidates;

    @InjectMocks
    private VotingApp votingApp;

    @Test
    public void testCastVote() {
        when(candidates.containsKey("validCandidate")).thenReturn(true);
        when(candidates.get("validCandidate")).thenReturn(0);

        String result = votingApp.castVote("validCandidate");

        assertEquals("Vote cast for validCandidate. Total votes: 1", result);
    }
}