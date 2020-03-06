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
}
