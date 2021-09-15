package com.example.retrofit_example.presentation.ui

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofit_example.R
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.databinding.FragmentMainBinding
import com.example.retrofit_example.presentation.viewmodel.MainViewModel
import com.example.retrofit_example.domain.vo.Result
import com.example.retrofit_example.presentation.adapters.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //Init Observers
        mainViewModel.getChannel.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.progressBar.visibility = View.GONE

                    val channel = result.data
                    val items = channel?.items!!
                    binding.channel = channel
                    binding.adapter = MainAdapter(
                        requireContext(),
                        items as MutableList<ArticleModel>,
                        mainViewModel,
                        R.menu.menu_main
                    )
                }
                is Result.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    val msg = result.exception.message!!
                    Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_actions, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_action_favorites ->{
                //Go to Favorites
                val action = MainFragmentDirections.actionMainFragmentToFavoritesFragment()
                findNavController().navigate(action)

                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }
}
@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .apply(RequestOptions().error(R.drawable.ic_baseline_podcasts_24))
        .into(imageView)
}