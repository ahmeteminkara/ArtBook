package com.aek.artbook.utils.extentions

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun EditText.addTextChangedListenerWithTimeout(delayMillis: Long, onChangeText: (String) -> Unit) {
    var lastInput = ""
    var debounceJob: Job? = null
    val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    this.addTextChangedListener {
        it?.let { editable ->
            val newtInput = editable.toString()
            debounceJob?.cancel()
            if (lastInput != newtInput) {
                lastInput = newtInput
                debounceJob = uiScope.launch {
                    delay(delayMillis)
                    if (lastInput == newtInput) {
                        onChangeText.invoke(newtInput)
                    }
                }
            }
        }
    }
}
