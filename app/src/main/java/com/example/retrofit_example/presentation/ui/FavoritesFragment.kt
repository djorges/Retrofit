package com.example.retrofit_example.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.retrofit_example.R
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.databinding.FragmentFavoritesBinding
import com.example.retrofit_example.domain.vo.Result
import com.example.retrofit_example.presentation.adapters.MainAdapter
import com.example.retrofit_example.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private val mainViewModel:MainViewModel by activityViewModels()
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getSavedArticles.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressVisibility = true
                }
                is Result.Success -> {
                    binding.progressVisibility = false

                    binding.adapter = MainAdapter(
                        requireContext(),
                        result.data as MutableList<ArticleModel>,
                        mainViewModel,
                        R.menu.menu_favorites
                    )
                }
                is Result.Failure -> {
                    binding.progressVisibility = false
                    Toast.makeText(
                        activity,
                        result.exception.message!!,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })
    }
}