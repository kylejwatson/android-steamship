package com.kyle.android_steamship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyle.android_steamship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.friendsButton.setOnClickListener {
            val intent = Intent(this, FriendSelectionActivity::class.java)
            intent.putExtra("steamId", binding.steamIdEditText.text.toString())
            startActivity(intent)
        }
    }
}