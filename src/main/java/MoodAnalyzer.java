public class MoodAnalyzer {
    private String message;

    //NO argument parameters constructor
    MoodAnalyzer() {
    }

    //Parameters constructor
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyzeMood();
    }

    public String analyzeMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please provide proper message");
            }
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException("Please enter a valid mood", MoodAnalysisException.ExceptionType.ENTERED_NULL);
        }
    }
}

