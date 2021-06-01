package com.kyle.android_steamship

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FriendListAdapter(private val dataSet: List<Player>) :
    RecyclerView.Adapter<FriendListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val realNameTextView: TextView
        val avatarImageView: ImageView

        init {
            nameTextView = view.findViewById(R.id.nameTextView)
            realNameTextView = view.findViewById(R.id.realNameTextView)
            avatarImageView = view.findViewById(R.id.avatarImageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.listitem_friend, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nameTextView.text = dataSet[position].personaname
        viewHolder.realNameTextView.text = dataSet[position].realname
        Glide.with(viewHolder.itemView)
            .load(dataSet[position].avatarmedium)
            .into(viewHolder.avatarImageView)
    }

    override fun getItemCount() = dataSet.size
}
