package com.github.borisbrodski.ece2014.library.testtools;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CommonTestTools {
	private static Context initialContext;

	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getService(Class<T> remoteInterfaceClass) {
		try {
			String simpleName = remoteInterfaceClass.getSimpleName();
			if (!simpleName.endsWith("Remote")) {
				throw new RuntimeException(
						"Can't determine bean name from remote interface: "
								+ remoteInterfaceClass.getCanonicalName()
								+ " (remote interface name should be: beanName+'Remote')");
			}
			String beanName = simpleName.substring(0, simpleName.length() - "Remote".length());
			StringBuilder lookup = new StringBuilder();
			lookup.append("ejb:LibraryEAR/LibraryEJB//");
			lookup.append(beanName);
			lookup.append("!");
			lookup.append(remoteInterfaceClass.getCanonicalName());
			return (T) getInitialContext().lookup(lookup.toString());
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
