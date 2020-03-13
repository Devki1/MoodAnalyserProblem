import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static MoodAnalyzer createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor, Object... message) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return (MoodAnalyzer) moodAnalyserConstructor.newInstance(message);
    }

    public static Object invokeMethod(MoodAnalyzer moodAnalyzerObject, String methodName) throws InvocationTargetException, IllegalAccessException, MoodAnalysisException {
        Method method = null;
        try {
            method = moodAnalyzerObject.getClass().getMethod(methodName);
            Object result = method.invoke(moodAnalyzerObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
        return method.invoke(moodAnalyzerObject);
    }
}