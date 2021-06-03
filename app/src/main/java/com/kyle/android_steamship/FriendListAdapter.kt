package com.kyle.android_steamship

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView


class FriendListAdapter(private val dataSet: List<Player>) :
    RecyclerView.Adapter<FriendListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val realNameTextView: TextView
        val avatarImageView: ShapeableImageView
        val statusTextView: TextView
        val statusImageView: ImageView

        init {
            nameTextView = view.findViewById(R.id.nameTextView)
            realNameTextView = view.findViewById(R.id.realNameTextView)
            avatarImageView = view.findViewById(R.id.avatarImageView)
            statusTextView = view.findViewById(R.id.statusTextView)
            statusImageView = view.findViewById(R.id.statusImageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.listitem_friend, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val player = dataSet[position]
        
        viewHolder.nameTextView.text = player.personaname
        viewHolder.realNameTextView.text = player.realname
        Glide.with(viewHolder.itemView)
            .load(player.avatarmedium)
            .into(viewHolder.avatarImageView)

        viewHolder.statusTextView.alpha = 1f
        viewHolder.statusImageView.alpha = 1f
        viewHolder.avatarImageView.setStrokeColorResource(R.color.teal_200)

        when(player.personastate) {
            PersonaState.ONLINE -> {
                viewHolder.statusTextView.text = if (player.gameid == null) "Online" else "In-game"
                viewHolder.statusImageView.setImageResource(if (player.gameid == null) R.drawable.ic_online_circle else R.drawable.ic_ingame)
                viewHolder.avatarImageView.alpha = 1f
            }
            PersonaState.OFFLINE -> {
                viewHolder.statusTextView.text = lastLogOff(player.lastlogoff)
                viewHolder.statusImageView.setImageResource(R.drawable.ic_offline_circle)
                viewHolder.avatarImageView.setStrokeColorResource(R.color.grey)
                viewHolder.avatarImageView.alpha = 0.2f
            }
            PersonaState.AWAY -> {
                viewHolder.statusTextView.text = "Away"
                viewHolder.statusImageView.setImageResource(R.drawable.ic_online_circle)
                viewHolder.avatarImageView.alpha = 0.4f
                viewHolder.statusImageView.alpha = 0.4f
                viewHolder.statusTextView.alpha = 0.4f
            }
            PersonaState.SNOOZE -> {
                viewHolder.statusTextView.text = "Away"
                viewHolder.statusImageView.setImageResource(R.drawable.ic_snooze)
                viewHolder.avatarImageView.alpha = 0.4f
                viewHolder.statusTextView.alpha = 0.4f
                viewHolder.statusImageView.alpha = 0.4f
            }
            else -> {
                viewHolder.statusTextView.text = "Offline"
                viewHolder.statusImageView.setImageResource(R.drawable.ic_offline_circle)
                viewHolder.avatarImageView.setStrokeColorResource(R.color.grey)
                viewHolder.avatarImageView.alpha = 0.2f
            }
        }
        viewHolder.statusTextView.setTextColor(viewHolder.avatarImageView.strokeColor)
    }

    override fun getItemCount() = dataSet.size
}
