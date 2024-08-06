package com.example.geoquizlb

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

class CheatViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    companion object {
        private const val KEY_ANSWER_IS_TRUE = "answer_is_true"
        private const val KEY_ANSWER_SHOWN = "answer_shown"
    }

    var answerIsTrue: Boolean
        get() = savedStateHandle.get(KEY_ANSWER_IS_TRUE) ?: false
        set(value) {
            savedStateHandle.set(KEY_ANSWER_IS_TRUE, value)
        }

    var answerShown: Boolean
        get() = savedStateHandle.get(KEY_ANSWER_SHOWN) ?: false
        set(value) {
            savedStateHandle.set(KEY_ANSWER_SHOWN, value)
        }

}