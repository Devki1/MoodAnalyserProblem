import javax.swing.*;

public class MoodAnalyzer {
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
    public String MoodAnalyzer()
    {
        this.message = message;
        return analyzeMood();
    }
    public String analyzeMood() {
        if (message.equals("I am a Sad Mood"))
        {
            return message = "SAD";
        }
        return message;
    }
}


