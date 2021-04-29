package com.oshovenko.cardapp.preset

import java.util.ArrayList

class Preset {
    val presetTitle = ArrayList<String>()
    var presetText= ArrayList<String>()

    init {
        presetTitle.addAll(
            listOf(
                "8 march",
                "New Year",
                "St Patrick"
            )
        )
        presetText.addAll(
            kotlin.collections.listOf(
                "You are beautiful in everything you do! Wishing you all the best on International Women's Day.",
                "Merry Christmas and a Happy New Year!",
                "This brings a wish your way-Good health, good luck, and happiness For today and every day."
            )
        )
    }
}