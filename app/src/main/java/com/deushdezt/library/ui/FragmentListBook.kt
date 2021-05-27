package com.deushdezt.library.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.deushdezt.library.R
import com.deushdezt.library.databinding.FragmentListBookBinding
import com.deushdezt.library.ui.library_vm.LibraryViewModel

class FragmentListBook: Fragment() {

    private var _binding: FragmentListBookBinding? = null
    private val binding get() = _binding!!

    private val libraryViewModel: LibraryViewModel by activityViewModels {
        val activity = requireActivity() as MainActivity
        activity.viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        libraryViewModel.books.observe(viewLifecycleOwner) {
            val text = it.map { book ->
                "Name: ${book.name}\nISBN: ${book.ISBN}\n"
            }.reduce { acc, s ->
                "$acc********************\n$s"
            }

            binding.bookListText.text = text
        }

        binding.addBookAction.setOnClickListener {
            findNavController().navigate(R.id.show_form)
        }
    }
}