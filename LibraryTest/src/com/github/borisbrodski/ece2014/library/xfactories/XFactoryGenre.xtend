package com.github.borisbrodski.ece2014.library.xfactories

import com.github.borisbrodski.ece2014.library.domain.Genre
import org.github.xfactory.AbstractXFactory
import static extension com.github.borisbrodski.ece2014.library.testtools.AbstractTestRule.*

class XFactoryGenre extends AbstractXFactory<Genre> {
	
	override minimal() {
		set [
			name = "Drama-" + nextSuffix
		]
	}
	
}