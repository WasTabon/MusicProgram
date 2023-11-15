package com.example.musicprogram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    private val list = ArrayList<Music>()
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(music: Music)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setList(newList: List<Music>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    // Создание нового ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(itemView)
    }

    // Установка данных в элемент списка
    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(element)
        }
    }

    // Возвращает количество элементов в списке
    override fun getItemCount(): Int {
        return list.size
    }

    // Вложенный класс ViewHolder
    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val musicIcon: ImageView = itemView.findViewById(R.id.musicIcon)
        private val musicName: TextView = itemView.findViewById(R.id.musicName)
        private val musicAuthor: TextView = itemView.findViewById(R.id.musicAuthor)

        // Метод для установки данных в ViewHolder
        fun bind(item: Music) {
            musicName.text = item.name
            musicAuthor.text = item.author

            Glide.with(itemView.context)
                .load(item.icon)
                .into(musicIcon)
        }
    }
}

