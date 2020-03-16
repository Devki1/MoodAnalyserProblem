import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {
    //Creating a constructor
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
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
        return method.invoke(moodAnalyzerObject);
    }

    public static void setFieldValue(MoodAnalyzer moodAnalyzerObject, String fieldName, String fieldValue) throws MoodAnalysisException, IllegalAccessException {
        Field field = null;
        try {
            field = moodAnalyzerObject.getClass().getField(fieldName);
            field.set(moodAnalyzerObject, fieldValue);

        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.getMessage());
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.getMessage());
            //e.printStackTrace();
        }
    }
}
