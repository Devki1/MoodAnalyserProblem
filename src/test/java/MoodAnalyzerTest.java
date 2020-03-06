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
    @Test
    public void givenMessage_WhenProper_RespondsHappyMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        String result = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY",result);
    }
}
