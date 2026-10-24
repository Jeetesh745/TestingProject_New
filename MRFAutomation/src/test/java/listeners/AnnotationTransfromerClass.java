package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransfromerClass implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotaions, Class TestClass, Constructor constructor, Method testMethod) {
		annotaions.setRetryAnalyzer(RetryAnalyzer_.class);
	}

}
