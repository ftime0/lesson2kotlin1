package com.example.lesson2kotlin1.ui.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.lesson2kotlin1.models.episode.RickAndMortyEpisode

class EpisodesDiffUtil : DiffUtil.ItemCallback<RickAndMortyEpisode>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ) = oldItem == newItem
}