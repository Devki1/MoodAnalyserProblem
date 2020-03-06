import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerTest
{
    @Test
    public void givenMessage_WhenProper_ShouldReturnSadMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am a Sad Mood");

        String  result = moodAnalyzer.analyzeMood();
     Assert.assertEquals("SAD",result);
    }
}
