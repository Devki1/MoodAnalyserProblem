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
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            String results = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("please enter a valid mood:", e.getMessage());
        }
    }
}
