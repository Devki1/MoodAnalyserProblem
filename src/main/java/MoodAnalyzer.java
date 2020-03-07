public class MoodAnalyzer
{
    private String message;
    //NO argument parameters constructor
    MoodAnalyzer()
    {

    }
    //Parameters constructor
    MoodAnalyzer(String message)
    {
        this.message = message;
    }
    public String analyzeMood()
    {
        if (message.contains("Sad"))
        {
            message = "SAD";
        }
        else if (message.contains("Happy"))
        {
             message = "HAPPY";
        }
        return message;
    }
}

