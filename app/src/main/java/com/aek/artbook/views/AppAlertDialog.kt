package com.aek.artbook.views

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AppAlertDialog(private val context: Context) {

    private val dialog by lazy {
        MaterialAlertDialogBuilder(context).apply {
            setCancelable(false)
        }
    }

    fun setTitle(title: String): AppAlertDialog {
        dialog.setTitle(title)
        return this
    }

    fun setTitle(@StringRes textStringId: Int): AppAlertDialog {
        dialog.setTitle(textStringId)
        return this
    }

    fun setMessage(message: String): AppAlertDialog {
        dialog.setMessage(message)
        return this
    }

    fun setMessage(@StringRes textStringId: Int): AppAlertDialog {
        dialog.setMessage(textStringId)
        return this
    }

    fun setCancelButton(
        textString: String,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setNeutralButton(textString) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun setCancelButton(
        @StringRes textStringId: Int,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setNeutralButton(textStringId) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun setPositiveButton(
        textString: String,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setPositiveButton(textString) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun setPositiveButton(
        @StringRes textStringId: Int,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setPositiveButton(textStringId) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun setNegativeButton(
        textString: String,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setNegativeButton(textString) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun setNegativeButton(
        @StringRes textStringId: Int,
        onClick: (() -> Unit)? = null
    ): AppAlertDialog {
        dialog.setNegativeButton(textStringId) { dialog, _ ->
            dialog.dismiss()
            onClick?.invoke()
        }
        return this
    }

    fun show(): AlertDialog? {
        return dialog.show()
    }
}
