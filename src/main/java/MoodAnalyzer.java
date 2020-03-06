import javax.swing.*;
public class MoodAnalyzer {
    private String message;
    //NO argument parameters constructor
    MoodAnalyzer() {
    }
    //Parameters constructor
    MoodAnalyzer(String message) {
        this.message = message;
    }
    public String analyzeMood() {
        if (message.equals("I am a Sad Mood")) {
            message = "SAD";
        }
        else if (message.equals("I am in Happy Mood")) {
             message = "HAPPY";
        }
        return message;
    }
}

