package com.ayush0402.newsapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ayush0402.newsapp.Fragments.HomeFragmentDirections
import com.ayush0402.newsapp.R
import com.ayush0402.newsapp.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        var category: String = "unselected"

        binding.btnBusiness.setOnClickListener {
            if (category == "business") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))
            } else {
                category = "business"
                Snackbar.make(binding.root, "Category is set to : Business", Snackbar.LENGTH_SHORT)
                    .show()
               it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

            }
        }
        binding.btnEntertainment.setOnClickListener {
            if (category == "entertainment") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))

            } else {
                category = "entertainment"
                Snackbar.make(
                    binding.root,
                    "Category is set to : Entertainment",
                    Snackbar.LENGTH_SHORT
                ).show()
                it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

            }
        }
        binding.btnGeneral.setOnClickListener {
            if (category == "general") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))


            } else {
                category = "general"
                Snackbar.make(binding.root, "Category is set to : General", Snackbar.LENGTH_SHORT)
                    .show()

                it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))
            }
        }
        binding.btnHealth.setOnClickListener {
            if (category == "health") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))

            } else {
                category = "health"
                Snackbar.make(binding.root, "Category is set to : Health", Snackbar.LENGTH_SHORT)
                    .show()
                it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))
            }
        }
        binding.btnScience.setOnClickListener {
            if (category == "science") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))

            } else {
                category = "science"
                Snackbar.make(binding.root, "Category is set to : Science", Snackbar.LENGTH_SHORT)
                    .show()
                it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

            }
        }
        binding.btnSports.setOnClickListener {
            if (category == "sports") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))

            } else {
                category = "sports"
                Snackbar.make(binding.root, "Category is set to : Sports", Snackbar.LENGTH_SHORT)
                    .show()
                it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

            }
        }
        binding.btnTechnology.setOnClickListener {
            if (category == "technology") {
                category = "unselected"
                Snackbar.make(binding.root, "No category selected", Snackbar.LENGTH_SHORT).show()
                it.setBackgroundColor(resources.getColor(R.color.green))

            } else {
                category = "technology"
                Snackbar.make(
                    binding.root,
                    "Category is set to : Technology",
                    Snackbar.LENGTH_SHORT
                ).show()
               it.setBackgroundColor(resources.getColor(R.color.design_default_color_secondary))

            }
        }

        binding.btnSearch.setOnClickListener {
            val query: String = binding.searchTil.editText!!.text.toString()
            val region: Boolean = binding.regionSwitch.isChecked
            //safeargs
            val action = HomeFragmentDirections.actionHomeFragmentToSearchedNewsFragment(
                query,
                region,
                category
            )
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }
}