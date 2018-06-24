Reading directory paths

```kotlin
Log.d(TAG, 
"""
        getDataDirectory = ${Environment.getDataDirectory()}
        getExternalStorageDirectory = ${Environment.getExternalStorageDirectory()}
        getExternalFilesDir = ${getExternalFilesDir(null)}
""".trimIndent())

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    Log.d(TAG, """
        dataDir = ${dataDir}
        filesDir = ${filesDir}
        getExternalFilesDirs ${getExternalFilesDirs(null).toList()}
    """.trimIndent())
}
```