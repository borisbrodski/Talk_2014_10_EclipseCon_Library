package com.github.borisbrodski.ece2014.library.xfactories

import com.github.borisbrodski.ece2014.library.domain.Author
import com.github.borisbrodski.ece2014.library.domain.Book
import org.github.xfactory.AbstractXFactory

class XFactoryBook extends AbstractXFactory<Book> {
    override minimal() {
    	minimal(xpersistBefore(new XFactoryAuthor))
    }
    def minimal(Author author) {
        set [
            title = "Eclipse Plug-ins"
            isbn = "0321774159"
            genre = xpersistBefore(new XFactoryGenre)
            it.author = author
            rating = 10
            missing = false
        ]
    }
}