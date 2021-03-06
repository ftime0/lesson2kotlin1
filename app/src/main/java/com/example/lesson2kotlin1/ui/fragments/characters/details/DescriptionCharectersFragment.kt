package com.example.lesson2kotlin1.ui.fragments.characters.details

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson2kotlin1.R
import com.example.lesson2kotlin1.base.BaseFragment
import com.example.lesson2kotlin1.common.extension.setImage
import com.example.lesson2kotlin1.common.resourse.Resource
import com.example.lesson2kotlin1.databinding.FragmentDescriptionCharactersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DescriptionCharectersFragment : BaseFragment<FragmentDescriptionCharactersBinding, CharacterDetailsViewModel>(
R.layout.fragment_description_characters
) {
    override val binding: FragmentDescriptionCharactersBinding by viewBinding(FragmentDescriptionCharactersBinding::bind)
    override val viewModel: CharacterDetailsViewModel by viewModels()
    private val args: DescriptionCharectersFragmentArgs by navArgs()


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchSingleCharacter(args.characterId).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("ololo", "Loading ")
                    }
                    is Resource.Error -> {
                        Log.e("ololo", it.message.toString())
                    }
                    is Resource.Success -> {
                        binding.tvCharacter.text = it.data?.name
                        it.data?.image?.let { it1 -> binding.imCharacter.setImage(it1) }
                    }
                }
            }
        }
    }
}