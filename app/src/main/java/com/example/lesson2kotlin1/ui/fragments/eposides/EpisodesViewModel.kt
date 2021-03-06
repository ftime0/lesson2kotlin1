package com.example.lesson2kotlin1.ui.fragments.eposides

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.lesson2kotlin1.base.view_model_base.BaseViewModel
import com.example.lesson2kotlin1.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository
) : BaseViewModel() {

    fun fetchEpisodes() = episodesRepository.fetchEpisodes().cachedIn(viewModelScope)
}