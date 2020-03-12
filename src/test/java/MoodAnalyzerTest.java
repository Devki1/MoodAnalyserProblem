import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;
    String result;

    @Test
    public void givenMessage_WhenProper_ShouldReturnSadMood() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am a Sad Mood");
        result = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        moodAnalyzer = new MoodAnalyzer("I am in any mood");
        result = null;
        try {
            result = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY", result);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNull_ShouldThrowsException() {
        try {
            moodAnalyzer = new MoodAnalyzer(null);

            result = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please provide proper message", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageEmpty_ShouldThrowsException() {
        try {
            moodAnalyzer = new MoodAnalyzer();
            result = moodAnalyzer.analyzeMood(" ");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please provide proper message", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenProper_ShouldReturnObject() {
        moodAnalyzer = new MoodAnalyzer();
        MoodAnalyzer moodAanayzerObject = MoodAnalyzerFactory.createMoodAanayzerObject();
        boolean result = moodAnalyzer.equals(moodAanayzerObject);
        Assert.assertEquals(true, result);
    }
}
