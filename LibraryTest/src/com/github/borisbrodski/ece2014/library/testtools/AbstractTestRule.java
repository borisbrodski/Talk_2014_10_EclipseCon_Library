package com.github.borisbrodski.ece2014.library.testtools;

import java.util.Random;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class AbstractTestRule extends XtendTestContrib
		implements TestRule {
	private static final String[] RANDOM_SUFFIX_PATTERNS = new String[] {
			"a-z", "A-Z", "0-9", "_" };
	private static final char[] RANDOM_SUFFIX_LETTERS = initSuffixLetters();
	private static final int RANDOM_SUFFIX_LENGTH = 6;

	private static ThreadLocal<Random> randomThreadLocal = new ThreadLocal<Random>() {
		@Override
		protected Random initialValue() {
			return new Random(System.currentTimeMillis());
		}
	};

	private String suffix = getNextSuffix();

	@Override
	public abstract Statement apply(Statement statement, Description description);

	private static char[] initSuffixLetters() {
		StringBuilder letters = new StringBuilder();
		for (String pattern : RANDOM_SUFFIX_PATTERNS) {
			if (pattern.length() == 1) {
				letters.append(pattern);
			} else if (pattern.length() == 3 && pattern.charAt(1) == '-') {
				char start = pattern.charAt(0);
				char stop = pattern.charAt(2);
				for (char c = start; c <= stop; c++) {
					letters.append(c);
				}
			} else {
				throw new RuntimeException("Invalid pattern: '" + pattern + "'");
			}

		}
		return letters.toString().toCharArray();
	}

	public static String getNextSuffix() {
		StringBuilder sb = new StringBuilder();
		Random random = getRandom();
		for (int i = 0; i < RANDOM_SUFFIX_LENGTH; i++) {
			sb.append(RANDOM_SUFFIX_LETTERS[random.nextInt(RANDOM_SUFFIX_LETTERS.length)]);
		}
		
		return sb.toString();
	}

	private static Random getRandom() {
		return randomThreadLocal.get();
	}

	public String getSuffix() {
		return suffix;
	}
}
