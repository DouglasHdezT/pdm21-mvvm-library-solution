package com.deushdezt.library.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.deushdezt.library.LibraryApplication
import com.deushdezt.library.R
import com.deushdezt.library.ui.library_vm.LibraryViewModel
import com.deushdezt.library.ui.library_vm.LibraryViewModelFactory

class MainActivity: AppCompatActivity() {

    private val libraryApp by lazy {
        application as LibraryApplication
    }

    val viewModelFactory by lazy {
        LibraryViewModelFactory(libraryApp.bookRepository)
    }

    private val libraryViewModel: LibraryViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}