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

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = null

        if (firstName == null && lastName == null) {
            initials = null
        } else if (firstName == " " && lastName == "") {
            initials = null
        } else if (firstName != null && lastName == null) {
            initials = firstName[0].toUpperCase().toString()
        } else if (firstName == null && lastName != null) {
            initials = lastName[0].toUpperCase().toString()
        } else if (firstName?.isNotEmpty()!! && lastName?.isNotEmpty()!!) {
            initials = "${firstName[0].toUpperCase()}${lastName[0].toUpperCase()}"
        }

        return initials
    }
}