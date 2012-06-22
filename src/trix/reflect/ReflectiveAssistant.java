package trix.reflect;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;

@Singleton
public class ReflectiveAssistant {

	public List<Class<?>> getClassesAnnotatedWith(Class<? extends Annotation> annotation) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> clazz : getAllClasses()) {
			if (clazz.isAnnotationPresent(annotation))
				classes.add(clazz);
		}
		return classes;
	}

	public List<Class<?>> getClasses(Class<?>... acceptedClasses) {
		if (acceptedClasses.length < 1) {
			throw new IllegalArgumentException("You must specify at least one accepted class!");
		}
		List<Class<?>> classes = getAllClasses();
		for (Class<?> clazz : classes) {
			boolean accepted = false;
			for (Class<?> acceptedClass : acceptedClasses) {
				if (!clazz.isAssignableFrom(acceptedClass)) {
					accepted = true;
					break;
				}
			}
			if (!accepted) {
				classes.remove(clazz);
			}
		}
		return classes;
	}

	public List<Class<?>> getAllClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Package child : Package.getPackages()) {
			try {
				classes.addAll(getClassesInPackage(child));
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return classes;
	}

	public List<Class<?>> getClassesInPackage(Package pkg) throws URISyntaxException {
		List<Class<?>> classes = new ArrayList<Class<?>>();

		String path = pkg.getName().replaceAll(".", "/");
		URL resource = ClassLoader.getSystemClassLoader().getResource(path);
		if (resource != null) {
			File directory = new File(resource.toURI());
			if (directory != null && directory.exists()) {
				for (String file : directory.list()) {
					if (file.endsWith(".class")) {
						String className = pkg.getName() + '.' + file.substring(0, file.length() - 6);
						try {
							classes.add(Class.forName(className));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		return classes;
	}

}