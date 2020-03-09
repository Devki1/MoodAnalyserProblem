public class MoodAnalyzer {
    private String message;

    //NO argument parameters constructor
    MoodAnalyzer() {
    }

    //Parameters constructor
    MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) {
        this.message = message;
        return analyzeMood();
    }

    public String analyzeMood() {
        try {
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}

