package com.kyle.android_steamship

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyle.android_steamship.databinding.ActivityFriendSelectionBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FriendSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFriendSelectionBinding
    private val friendsList = mutableListOf<Player>()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.steam.watsonk.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val steamService: SteamService = retrofit.create(SteamService::class.java)
    private val steamRepository = SteamRepository(steamService)
    private val model: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory(
            this,
            steamRepository
        )
    }

    private val adapter = FriendListAdapter(friendsList)

    override fun onCreate(savedInstanceState: Bundle?) {
        val steamId = intent.getStringExtra("steamId")
        super.onCreate(savedInstanceState)
        binding = ActivityFriendSelectionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.friendListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.friendListRecyclerView.adapter = adapter

        val friendsObserver = Observer<List<Player>> { newPlayers ->
            friendsList.clear()
            friendsList.addAll(newPlayers)
            adapter.notifyDataSetChanged()
        }

        model.players.observe(this, friendsObserver)
        if (steamId != null) {
            model.initSteamId(steamId)
        }
    }
}