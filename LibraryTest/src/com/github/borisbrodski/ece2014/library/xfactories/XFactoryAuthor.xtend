package com.github.borisbrodski.ece2014.library.xfactories

import com.github.borisbrodski.ece2014.library.domain.Author
import org.github.xfactory.AbstractXFactory
import com.github.borisbrodski.ece2014.library.testtools.XtendTestContrib

class XFactoryAuthor extends AbstractXFactory<Author> {
    extension XtendTestContrib = new XtendTestContrib
    
    override minimal() {
        set [
            firstName = "John"
            lastName = "Doe"
            birthday = 14.april(1967)
        ]
    }
    def kill() {
        set [
            dayOfDeath = birthday + 40.years
        ]
    }
}