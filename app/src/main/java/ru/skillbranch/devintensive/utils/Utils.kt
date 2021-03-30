package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?) : Pair<String?, String?> {

        var fullNamePair: Pair<String?, String?> = null to null

        when (fullName) {
            null, "", " "  -> {
                fullNamePair = null to null
            }
            else -> {
                val parts: List<String> = fullName.split(" ")

                val firstName = parts.getOrNull(0)
                val lastName = parts.getOrNull(1)

                if ((firstName != null && firstName.isNotEmpty()) && (lastName != null && lastName.isNotEmpty())) {
                    fullNamePair = firstName to lastName
                } else if ((firstName != null && firstName.isNotEmpty()) && lastName == null) {
                    fullNamePair = firstName to null
                }
            }
        }

        return fullNamePair
    }
}