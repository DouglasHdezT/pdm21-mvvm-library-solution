package com.deushdezt.library.ui.library_vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deushdezt.library.repository.BookRepository
import java.lang.Exception

class LibraryViewModelFactory(private val bookRepository: BookRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LibraryViewModel::class.java)){
            return LibraryViewModel(bookRepository) as T
        }
        throw Exception("Unknown viewModel class")
    }
}