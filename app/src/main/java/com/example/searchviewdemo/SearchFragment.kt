package com.example.searchviewdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.searchviewdemo.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.searchView.inflateMenu(R.menu.menu_search)

        binding.searchView.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_search -> {
                    binding.result.text = binding.searchView.text
                    Toast.makeText(requireContext(), "点击", Toast.LENGTH_LONG).show()
                }
            }
            true
        }

        binding.searchView.editText.setOnEditorActionListener { v, actionId, event ->
            binding.searchBar.setText(binding.searchView.text)
            binding.searchView.hide()


            /**
             * 分支测试
             */
            binding.result.text = binding.searchView.text
            false
        }

        return binding.root
    }

}