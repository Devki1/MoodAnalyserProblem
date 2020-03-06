
public class MoodAnalyzer
{
    public String analyzeMood(String message)
    {
        if(message.equals("I am a Sad Mood"))
        {
            return "SAD";
        }
        else
            return "HAPPY";
    }
}

