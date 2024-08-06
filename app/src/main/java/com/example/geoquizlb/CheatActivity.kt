package com.example.geoquizlb

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geoquizlb.databinding.ActivityCheatBinding
import android.content.Intent
import android.content.Context

const val EXTRA_ANSWER_SHOWN = "com.example.geoquizlb.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE =
    "com.example.geoquizlb.MainActivity.answer_is_true"


class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding

    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        binding.showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.trueButton
                else -> R.string.falseButton
            }
            binding.answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }

        binding.cheatBackButton.setOnClickListener{
            this.finish()
        }




//replace r.main with another id within activity cheat xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cheatMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}