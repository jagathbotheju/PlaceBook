package com.jagath.placebook03.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.jagath.placebook03.db.BookmarkDao
import com.jagath.placebook03.db.PlaceBookDatabase
import com.jagath.placebook03.model.Bookmark

class BookmarkRepo(context:Context) {

    private var db = PlaceBookDatabase.getInstance(context)
    private var bookmarkDao: BookmarkDao = db.bookmarkDao()

    suspend fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }

    fun createBookmark(): Bookmark {
        return Bookmark()
    }

    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }

}