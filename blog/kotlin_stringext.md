---
title: Useful string extensions in Kotlin
description: several extension methods for validation, sharedPreferences etc
date: 2020-05-02
tags: ['Android', 'syntactic', 'string']
---

1. Email validation

> ```
    import java.util.regex.Pattern

    fun String.isValidEmail(): Boolean {
        val regex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
        val pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(this)
        return matcher.matches()
    }
> ```

2. Phone number validation & formation

> ```
    import android.content.Context
    import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

fun String.formatPhoneNumber(context: Context, region: String): String? {
    val phoneNumberKit = PhoneNumberUtil.createInstance(context)
    val number = phoneNumberKit.parse(this, region)
    if (!phoneNumberKit.isValidNumber(number))
        return null
    return phoneNumberKit.format(number, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL)
}
> ```

3. Content checking

> ```
    val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

    val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

    val String.isAlphanumeric: Boolean
    get() = matches(Regex("[A-Za-z0-9]*"))

    val String.hasLettersAndDigits: Boolean
    get() = containsLatinLetter && containsDigit

    val String.isIntegerNumber: Boolean
    get() = toIntOrNull() != null

    val String.toDecimalNumber: Boolean
    get() = toDoubleOrNull() != null
> ```

3. Content checking

> ```
    val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

    val String.containsDigit: Boolean
    get() = matches(Regex(".*[0-9].*"))

    val String.isAlphanumeric: Boolean
    get() = matches(Regex("[A-Za-z0-9]*"))

    val String.hasLettersAndDigits: Boolean
    get() = containsLatinLetter && containsDigit

    val String.isIntegerNumber: Boolean
    get() = toIntOrNull() != null

    val String.toDecimalNumber: Boolean
    get() = toDoubleOrNull() != null
> ```

4. Data from sharedPreferences
we only save 5 primitive types with Any as non-null value. use commit if you want to save changes immediately, otherwise apply is better as it runs in the background.

> ```
import android.content.Context

fun String.save(applicationContext: Context, value: Map<String, Any>, clear: Boolean = false, now: Boolean = false) {
    val sp = applicationContext.getSharedPreferences(this, Context.MODE_PRIVATE).edit()
    if (clear)
        sp.clear()
    value.keys.forEach { key ->
        val v = value[key]
        if (v != null) {
            when (v) {
                is String -> sp.putString(key, v)
                is Float -> sp.putFloat(key, v)
                is Long -> sp.putLong(key, v)
                is Int -> sp.putInt(key, v)
                is Boolean -> sp.putBoolean(key, v)
            }
        }
    }
    if (now)
        sp.commit()
    else
        sp.apply()
}

fun String.load(applicationContext: Context): Map<String, Any> {
    val sp = applicationContext.getSharedPreferences(this, Context.MODE_PRIVATE)
    val keys = sp.all.keys
    val result = hashMapOf<String, Any>()
    keys.map { key ->
        val v = sp.all[key]
        if (v != null)
            result[key] = v
    }
    return result
}

"com.app.test".save(applicationContext,
    mapOf(
        "TEST_VALUE" to "test test",
        "ACTIVITY" to true
    )
)

val testValue = "test".load(applicationContext)["TEST_VALUE"] as? String // "test test"
> ```

5. JSON parsing

> ```
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

val String.jsonObject: JSONObject?
    get() = try {
        JSONObject(this)
    } catch (e: JSONException) {
        null
    }

val String.jsonArray: JSONArray?
    get() = try {
        JSONArray(this)
    } catch (e: JSONException) {
        null
    }

val json = "{\"key\": \"value\"}".jsonObject  // {"key": "value"}
val jsonAgain = json?.toString() // "{"key": "value"}"
val stringFromJson = json?.getString("key") // "value"

fun JSONObject.getStringOrNull(name: String): String? =
      try {
         val str = getString(name).trim()
         if (str == "null") return null
         return str
      }
      catch (e: JSONException) {
         null
      }
> ```

6. Last path component
If String contains a path or URL, it returns last component (after last ‘/’).
> ```
val String.lastPathComponent: String
get() {
    var path = this
    if (path.endsWith("/"))
        path = path.substring(0, path.length - 1)
    var index = path.lastIndexOf('/')
    if (index < 0) {
        if (path.endsWith("\\"))
            path = path.substring(0, path.length - 1)
        index = path.lastIndexOf('\\')
        if (index < 0)
            return path
    }
    return path.substring(index + 1)
}
> ```

7. Last path component
If String contains a path or URL, it returns last component (after last ‘/’).
> ```
val String.lastPathComponent: String
get() {
    var path = this
    if (path.endsWith("/"))
        path = path.substring(0, path.length - 1)
    var index = path.lastIndexOf('/')
    if (index < 0) {
        if (path.endsWith("\\"))
            path = path.substring(0, path.length - 1)
        index = path.lastIndexOf('\\')
        if (index < 0)
            return path
    }
    return path.substring(index + 1)
}

val exampleA = "https://google.com/chrome/".lastPathComponent // chrome
val exampleB = "C:\\Windows\\Fonts\\font.ttf".lastPathComponent // font.ttf
val exampleC = "/dev/null".lastPathComponent // null
> ```

8. Credit card formatting

> ```
val String.creditCardFormatted: String
get() {
    val preparedString = replace(" ", "").trim()
    val result = StringBuilder()
    for (i in preparedString.indices) {
        if (i % 4 == 0 && i != 0) {
            result.append(" ")
        }
        result.append(preparedString[i])
    }
    return result.toString()
}
> ```

9. MD5/SHA Hash Calculator

> ```
import java.security.MessageDigest

val String.md5: String
get() {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.joinToString("") {
        "%02x".format(it)
    }
}

val String.sha1: String
get() {
    val bytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
    return bytes.joinToString("") {
        "%02x".format(it)
    }
}
> ```

10. Infix

> ```
infix fun String?.`++`(s:String?):String? =
    if (this == null) s else if (s == null) this else this + s


assertThat(null `++` null).isNull()
assertThat("A" `++` null).isEqualTo("A")
assertThat(null `++` "B").isEqualTo("B")
assertThat("A" `++` "B").isEqualTo("AB")
> ```
