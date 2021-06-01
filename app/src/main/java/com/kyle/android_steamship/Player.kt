package com.kyle.android_steamship

import android.system.Int64Ref
import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("steamid") val steamid : Long,
    @SerializedName("communityvisibilitystate") val communityvisibilitystate : Int,
    @SerializedName("profilestate") val profilestate : Int,
    @SerializedName("personaname") val personaname : String,
    @SerializedName("realname") val realname : String?,
    @SerializedName("profileurl") val profileurl : String,
    @SerializedName("avatar") val avatar : String,
    @SerializedName("avatarmedium") val avatarmedium : String,
    @SerializedName("avatarfull") val avatarfull : String,
    @SerializedName("avatarhash") val avatarhash : String,
    @SerializedName("lastlogoff") val lastlogoff : Int,
    @SerializedName("personastate") val personastate : Int,
    @SerializedName("primaryclanid") val primaryclanid : Long,
    @SerializedName("timecreated") val timecreated : Int,
    @SerializedName("personastateflags") val personastateflags : Int,
    @SerializedName("friend_since") val friend_since : Int
)
