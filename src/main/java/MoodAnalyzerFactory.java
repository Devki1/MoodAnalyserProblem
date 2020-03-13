import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        Class<?> moodAnalyserClass;
        try {
            moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (MoodAnalyzer) moodAnalyserConstructor.newInstance();
    }
}
