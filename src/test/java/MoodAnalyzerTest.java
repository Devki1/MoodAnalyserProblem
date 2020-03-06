import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyzerTest
{
    MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
    @Test
    //Test case for Sad mood
    public void givenMessage_WhenProper_RespondsSadMood()
    {
     String  result = moodAnalyzer.analyzeMood("I am a Sad Mood");
     Assert.assertEquals("SAD",result);
    }
    @Test
    //Check test case for Happy mood  analyzer
    public void givenMessage_WhenProper_RespondsHappyMood()
    {
        String result = moodAnalyzer.analyzeMood("I am a any Mood");
        Assert.assertEquals("HAPPY",result);
    }
}
