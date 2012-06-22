package trix.boot;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceBootstrap.class)
public interface Bootstrap {
	public void boot();
}