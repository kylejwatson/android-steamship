package com.kyle.android_steamship

import com.google.gson.annotations.SerializedName
import java.util.*

enum class PersonaState{
    @SerializedName("0")
    OFFLINE,
    @SerializedName("1")
    ONLINE,
    @SerializedName("2")
    BUSY,
    @SerializedName("3")
    AWAY,
    @SerializedName("4")
    SNOOZE,
    @SerializedName("5")
    LOOKING_TO_TRADE,
    @SerializedName("6")
    LOOKING_TO_PLAY
}

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
    @SerializedName("lastlogoff") val lastlogoff : Long,
    @SerializedName("personastate") val personastate : PersonaState,
    @SerializedName("primaryclanid") val primaryclanid : Long,
    @SerializedName("gameid") val gameid : Long?,
    @SerializedName("timecreated") val timecreated : Long,
    @SerializedName("personastateflags") val personastateflags : Int,
    @SerializedName("friend_since") val friend_since : Long
)

fun lastLogOff (lastlogoff: Long): String {
    val date = Date().time - lastlogoff * 1000
    val seconds = date / 1000.0
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    val weeks = days / 7
    val months = weeks / 4
    val years = months / 12

    if (years >= 1) {
        val plural = if (years.toInt() > 1) "years" else "year"
        return "${years.toInt()} $plural ago"
    }
    if (months >= 1) {
        val plural = if (months.toInt() > 1) "months" else "month"
        return "${months.toInt()} $plural ago"
    }
    if (weeks >= 1) {
        val plural = if (weeks.toInt() > 1) "weeks" else "week"
        return "${weeks.toInt()} $plural ago"
    }
    if (days >= 1) {
        val plural = if (days.toInt() > 1) "days" else "day"
        return "${days.toInt()} $plural ago"
    }
    if (hours >= 1) {
        val plural = if (hours.toInt() > 1) "hours" else "hour"
        return "${hours.toInt()} $plural ago"
    }
    if (minutes >= 1) {
        val plural = if (minutes.toInt() > 1) "minutes" else "minute"
        return "${minutes.toInt()} $plural ago"
    }
    if (seconds >= 1) {
        val plural = if (seconds.toInt() > 1) "seconds" else "second"
        return "${seconds.toInt()} $plural ago"
    }
    return "moments ago"
}