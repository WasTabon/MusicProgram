package com.example.musicprogram

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicprogram.databinding.FragmentMusicListBinding

class MusicListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.musicListId)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val musicList = ArrayList<Music>()
        //region ListAdd
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        musicList.add(Music(R.drawable.ruckus,"Ruckus", "Sxmpra"))
        musicList.add(Music(R.drawable.override,"Override", "KSLV-NOH"))
        musicList.add(Music(R.drawable.jekyllandhide,"Jekyll And Hide", "Five Finger Death Punch"))
        //endregion

        adapter = MusicAdapter()
        adapter.setList(musicList)

        adapter.setOnItemClickListener(object : MusicAdapter.OnItemClickListener {
            override fun onItemClick(music: Music) {
                findNavController().navigate((MusicListFragmentDirections.actionMusicListFragmentToMusicInfoFragment(music.icon, music.name, music.author)))
            }
        })

        recyclerView.adapter = adapter

        val itemDecoration = ItemDecoration(resources.getDimensionPixelSize(R.dimen.item_margin))
        recyclerView.addItemDecoration(itemDecoration)
    }
}

