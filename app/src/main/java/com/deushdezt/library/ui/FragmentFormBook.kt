package com.deushdezt.library.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.deushdezt.library.R
import com.deushdezt.library.databinding.FragmentFormBookBinding
import com.deushdezt.library.ui.library_vm.LibraryViewModel

class FragmentFormBook: Fragment() {

    private var _binding: FragmentFormBookBinding? = null
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
        _binding = FragmentFormBookBinding.inflate(inflater, container, false)

        binding.apply {
            viewmodel = libraryViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBookAction.setOnClickListener {
            libraryViewModel.addBook()
            findNavController().navigate(R.id.show_list)
        }
    }

}