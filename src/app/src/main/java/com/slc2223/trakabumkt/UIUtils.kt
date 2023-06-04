package com.slc2223.trakabumkt

import android.app.Activity
import android.content.Context
import android.widget.Toast

/**
 * Function to show a toast from anywhere in the app.
 * @param context The context from which the toast is being called.
 * @param message The message to be displayed in the toast.
 * @param duration The duration of the toast. (Default: Toast.LENGTH_SHORT)
 */
fun toast(context: Context?, message: String?, duration: Int = Toast.LENGTH_SHORT) {
    safeLet(context, message, duration) { safeContext, safeMessage, safeDuration ->
        (safeContext as? Activity)?.runOnUiThread {
            Toast.makeText(safeContext, safeMessage, safeDuration).show()
        }
    }
}