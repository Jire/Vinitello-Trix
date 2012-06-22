package trix.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks some <tt>type</tt> to be automatically registered.
 * @author Thomas G. P. Nappo
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterAutomatically {

	/**
	 * Whether or not to be automatically registered.
	 * @return <code>true</code> to be automatically registered.
	 */
	public boolean value() default true;

}