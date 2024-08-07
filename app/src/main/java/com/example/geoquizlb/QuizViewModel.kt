package com.example.geoquizlb

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private var currentIndex: Int
    get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
    set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)
    private val questionBank = listOf(
        Question(R.string.questionAustralia, true),
        Question(R.string.questionOceans, true),
        Question(R.string.questionMideast, false),
        Question(R.string.questionAfrica, false),
        Question(R.string.questionAmericas, true),
        Question(R.string.questionAsia, true))


    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun resetCheater(){
        isCheater = false
    }

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
        resetCheater()
    }


    fun moveToPrev() {
        if (currentIndex > 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        }
        else{currentIndex = (questionBank.size)-1}

        resetCheater()
    }

    fun getTag(): String {
        return TAG
    }



}

