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

        val sharedPref = getSharedPreferences("com.kyle.android_steamship.remember_data", MODE_PRIVATE)
        val savedId = sharedPref.getString("steamId", null)

        if (savedId != null) {
            binding.steamIdEditText.setText(savedId)
            goToFriendSelection(savedId)
        }

        binding.friendsButton.setOnClickListener {
            val newId = binding.steamIdEditText.text.toString()
            with (sharedPref.edit()) {
                putString("steamId", newId)
                apply()
            }
            goToFriendSelection(newId)
        }
    }

    fun goToFriendSelection(steamId: String){

        val intent = Intent(this, FriendSelectionActivity::class.java)
        intent.putExtra("steamId", steamId)
        startActivity(intent)
    }
}