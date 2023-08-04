package com.example.bottomnavigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationsample.databinding.FragmentBottomNavigationBinding


class BottomNavigationFragment : Fragment() {
    private var _binding: FragmentBottomNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBottomNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.page_1 -> updateText("Favorites selected")
                R.id.page_2 -> updateText("Music selected")
                R.id.page_3 -> updateText("Places selected")
                R.id.page_4 -> updateText("News selected")
            }
            true
        }
    }

    private fun updateText(message: String) {
        binding.tvMessage.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
