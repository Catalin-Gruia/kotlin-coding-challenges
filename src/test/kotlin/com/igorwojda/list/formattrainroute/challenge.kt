package com.igorwojda.list.formattrainroute

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun formatTrainRoute(stations: List<String>): String {
    if (stations.size > 1) {
        val lastStation = stations.takeLast(1)
            .joinToString { it }

        val followingStations = stations.dropLast(1)
            .joinToString { it }

        return "Train is calling at $followingStations and $lastStation"
    }

    return "Train is calling at ${stations[0]}"
}

private class Test {
    @Test
    fun `formatTrainRoute list "Luton"`() {
        formatTrainRoute(listOf("Luton")) shouldBeEqualTo "Train is calling at Luton"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden"`() {
        formatTrainRoute(listOf("Luton", "Harpenden")) shouldBeEqualTo "Train is calling at Luton and Harpenden"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden", "London"`() {
        val list = listOf("Luton", "Harpenden", "London")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Luton, Harpenden and London"
    }

    @Test
    fun `formatTrainRoute list "Luton", "Harpenden", "St Albans", "London"`() {
        val list = listOf("Luton", "Harpenden", "St Albans", "London")
        formatTrainRoute(list) shouldBeEqualTo "Train is calling at Luton, Harpenden, St Albans and London"
    }
}
