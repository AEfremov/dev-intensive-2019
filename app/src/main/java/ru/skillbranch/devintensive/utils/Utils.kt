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

    fun transliteration(payload: String, divider: String = " "): String {
        val sb: StringBuilder = StringBuilder()
        var payloadDivider = ""

        payload.toLowerCase().asSequence().forEachIndexed { index, c ->
            when (c) {
                'а' -> sb.append("a")
                'б' -> sb.append("b")
                'в' -> sb.append("v")
                'г' -> sb.append("g")
                'д' -> sb.append("d")
                'е' -> sb.append("e")
                'ё' -> sb.append("e")
                'ж' -> sb.append("zh")
                'з' -> sb.append("z")
                'и' -> sb.append("i")
                'й' -> sb.append("i")
                'к' -> sb.append("k")
                'л' -> sb.append("l")
                'м' -> sb.append("m")
                'н' -> sb.append("n")
                'о' -> sb.append("o")
                'п' -> sb.append("p")
                'р' -> sb.append("r")
                'с' -> sb.append("s")
                'т' -> sb.append("t")
                'у' -> sb.append("u")
                'ф' -> sb.append("f")
                'х' -> sb.append("h")
                'ц' -> sb.append("c")
                'ч' -> sb.append("ch")
                'ш' -> sb.append("sh")
                'щ' -> sb.append("sh")
                'ъ' -> sb.append("")
                'ы' -> sb.append("i")
                'ь' -> sb.append("")
                'э' -> sb.append("e")
                'ю' -> sb.append("yu")
                'я' -> sb.append("ya")
                ' ' -> {
                    sb.append(" ")
                    payloadDivider = " "
                }
                '_' -> {
                    sb.append("_")
                    payloadDivider = "_"
                }
                else -> {
                    sb.append(c)
                }
            }
        }

        return sb.toString().split(payloadDivider).map { it.capitalize() }.joinToString(divider)
    }
}

