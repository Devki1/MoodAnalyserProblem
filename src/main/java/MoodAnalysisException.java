public class MoodAnalysisException extends Exception {
    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY
    }

    ExceptionType type;

    public MoodAnalysisException( String message,ExceptionType type) {
        super(message);
        this.type = type;
    }

    public MoodAnalysisException(ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}

