package com.deushdezt.library.ui.library_vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deushdezt.library.data.entity.Book
import com.deushdezt.library.repository.BookRepository
import kotlinx.coroutines.launch

class LibraryViewModel(private val bookRepository: BookRepository): ViewModel() {

    val isbnInput= MutableLiveData("")
    val nameInput= MutableLiveData("")
    val authorInput= MutableLiveData("")
    val editorialInput= MutableLiveData("")
    val yearInput= MutableLiveData("")

    val books = bookRepository.findAll()

    fun addBook(){
        viewModelScope.launch {
            if(
                !isbnInput.value.isNullOrEmpty() &&
                !nameInput.value.isNullOrEmpty() &&
                !authorInput.value.isNullOrEmpty() &&
                !editorialInput.value.isNullOrEmpty() &&
                !yearInput.value.isNullOrEmpty()
            ){
                val newBook =
                    Book(isbnInput.value!!, nameInput.value!!, authorInput.value!!, editorialInput.value!!, yearInput.value!!)
                bookRepository.insertOrReplace(newBook)

                isbnInput.value = ""
                nameInput.value = ""
                authorInput.value = ""
                editorialInput.value = ""
                yearInput.value = ""
            }
        }
    }
}