package com.amandeep.jetpackcompose

object Routes {
    const val FIRST_SCREEN = "FirstScreen"
    const val SECOND_SCREEN = "SecondScreen/{${Values.SECOND_SCREEN_VALUE}}"

    fun getSecondScreenPath(customValue: String?): String =
        // to avoid null and empty strings
        if (customValue != null && customValue.isNotBlank()) "SecondScreen/$customValue" else "SecondScreen/Empty"

    object Values {
        const val SECOND_SCREEN_VALUE = "customValue"
    }
}