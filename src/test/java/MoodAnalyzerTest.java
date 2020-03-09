import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_WhenProper_ShouldReturnSadMood() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am a Sad Mood");
        String result = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in any mood");
        String result = null;
        try {
            result = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY", result);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNull_ShouldThrowsException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            String results = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter a valid mood", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageEmpty_ShouldThrowsException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            String results = moodAnalyzer.analyzeMood(" ");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please provide proper message", e.getMessage());
        }

    }
}
