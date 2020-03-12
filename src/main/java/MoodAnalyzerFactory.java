import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAanayzerObject() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName("MoodAnalyzerMood");
            Constructor<?> moodAnalysisConstructor = moodAnalyzer.getConstructor();
            Object moodObject = moodAnalysisConstructor.newInstance();
            return (MoodAnalyzer) moodObject;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Class not found ");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
