package com.example.roomwithview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.roomwithview.NewWordActivity.Companion.EXTRA_REPLY

class UpdateWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var wordViewModel: WordViewModel
    private var selectedWord: String?= null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_word)

        editWordView = findViewById(R.id.upt_word)
        selectedWord = intent.getStringExtra("word_key")
        Log.d("w1","$selectedWord")
        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        editWordView.setText(selectedWord)

        val button1 = findViewById<Button>(R.id.button_update)
        button1.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
                Toast.makeText(applicationContext, R.string.unable_to_update, Toast.LENGTH_LONG ).show()

            } else {
                val word = editWordView.text.toString()
                wordViewModel.insert(Word(word))

                val word1 = Word(selectedWord!!)
                wordViewModel.deleteword(word1)
                Toast.makeText(applicationContext, R.string.able_to_update, Toast.LENGTH_LONG ).show()

            }
            finish()
        }
        val button2 = findViewById<Button>(R.id.button_delete)
        button2.setOnClickListener {
            if(selectedWord!=null) {
                val word = Word(selectedWord!!)
                wordViewModel.deleteword(word)
            }
            else
            {
                Toast.makeText(applicationContext, R.string.unable_to_delete, Toast.LENGTH_LONG ).show()
            }
            finish()
            Toast.makeText(applicationContext, R.string.able_to_delete, Toast.LENGTH_LONG ).show()
        }
    }

    /*companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }*/
}

/* val replyIntent = Intent()
           *//*if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)

            } else {*//*
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            */
/*delWordActivityRequestCode = 3*/
/*val delid: Int=delWordActivityRequestCode
if (delid==3) {*/
/* val word2:String=getString()
 wordViewModel.deleteword(word)*/
/* val replyIntent = Intent()
 replyIntent.putExtra(NewWordActivity.EXTRA_REPLY, delWordActivityRequestCode)
 setResult(Activity.RESULT_OK, replyIntent)
 Log.d("T1","$replyIntent")*/
//            }

/*wordViewModel.allWords.observe(this, Observer { words ->
        words?.let { adapter.setWords(it) }*/

/* val EXTRA_REPLY_ID = "com.android.example.roomwordssample.REPLY_ID"*/
/*   private val delWordActivityRequestCode = 3*/

/*replyIntent.putExtra(NewWordActivity.EXTRA_REPLY, word)
               setResult(Activity.RESULT_OK, replyIntent)*/



/*if(selectedWord!=null) {
    wordViewModel.updateword(word1)
}*/
/*else
{
    Toast.makeText(applicationContext, R.string.unable_to_update, Toast.LENGTH_LONG ).show()
}*/
/*.toString()*/
//        editWordView.setText("$selectedWord").toString()