import org.graalvm.compiler.lir.alloc.trace.lsra.TraceLinearScanLifetimeAnalysisPhase;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class MoodAnalyzerTest {
    MoodAnalyzer moodAnalyzer;
    String result;
    String message = "I am in a happy mood";

    @Test
    public void givenMessage_WhenProper_ShouldReturnSadMood() throws MoodAnalysisException {
        moodAnalyzer = new MoodAnalyzer("I am a Sad Mood");
        result = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNotIncludesSad_ShouldReturnHappy() {
        moodAnalyzer = new MoodAnalyzer("I am in any mood");
        result = null;
        try {
            result = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY", result);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageNull_ShouldThrowsException() {
        try {
            moodAnalyzer = new MoodAnalyzer(null);
            result = moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please provide proper message", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenMessageEmpty_ShouldThrowsException() {
        try {
            moodAnalyzer = new MoodAnalyzer();
            result = moodAnalyzer.analyzeMood(" ");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please provide proper message", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_WhenProper_ShouldReturnObject() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer");
        MoodAnalyzer moodAnalyserObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyserConstructor, "I am in a happy mood");
        boolean result = moodAnalyzer.equals(moodAnalyserObject);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldthrowMoodAnalysis() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("Analyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClassName_WhenConstructorNotProper_ShouldThrowMoodAnalysis() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalysisWithParametrizedConstructor_WhenProper_ShouldReturnObject() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException {
        moodAnalyzer = new MoodAnalyzer("I am in a happy mood");
        Constructor<?> moodAnalyzerConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", String.class);
        MoodAnalyzer moodAnalyzerObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyzerConstructor, "I am in a happy mood");
        boolean result = moodAnalyzer.equals(moodAnalyzerObject);
        Assert.assertEquals(true, result);
    }

    @Test
    public void givenMoodAnalysisWithParametrizedConstructor_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("Analyser", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalysisWithParametrizedConstructor_WhenConstructorNotProper_ShouldThrowMoodAnalysisException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", Integer.class, String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", String.class);
        MoodAnalyzer moodAnalyserObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyserConstructor, "I am in happy mood");
        Object result = MoodAnalyzerFactory.invokeMethod(moodAnalyserObject, "analyzeMood");
        Assert.assertEquals("HAPPY", result);
    }
    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer", String.class);
            MoodAnalyzer moodAnalyserObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyserConstructor, "I am in happy mood");
            MoodAnalyzerFactory.invokeMethod(moodAnalyserObject, "moodanalyzeMood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessageWithReflection_ShouldReturnHappy() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException, NoSuchFieldException {
        Constructor<?> moodAnalyserConstructor = MoodAnalyzerFactory.getConstructor("MoodAnalyzer");
        MoodAnalyzer moodAnalyserObject = MoodAnalyzerFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        MoodAnalyzerFactory.setFieldValue(moodAnalyserObject, "message","I am in happy mood");
        Object result = MoodAnalyzerFactory.invokeMethod(moodAnalyserObject, "analyzeMood");
        Assert.assertEquals("HAPPY", result);
    }


    }
