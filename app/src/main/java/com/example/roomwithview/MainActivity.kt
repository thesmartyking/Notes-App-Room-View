package com.example.roomwithview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
//import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private lateinit var wordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordViewModel.allWords.observe(this, Observer { words ->
            words?.let { adapter.setWords(it) }
        })

        val fab_add = findViewById<FloatingActionButton>(R.id.fab_add)
        fab_add.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
        /*val fabupt = findViewById<FloatingActionButton>(R.id.fab_upt)
        fabupt.setOnClickListener {
            val intent = Intent(this@MainActivity, UpdateWordActivity::class.java)
            startActivityForResult(intent, updateWordActivityRequestCode)
        }*/

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)
        Log.d("Tag","$requestCode----$resultCode----$intentData")
        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(it)
                wordViewModel.insert(word)
                Unit
            }
        }

        else {
            Toast.makeText(applicationContext, R.string.empty_not_saved, Toast.LENGTH_LONG ).show()
        }
    }

}
/*else if(requestCode == updateWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
      intentData?.getStringExtra(UpdateWordActivity.EXTRA_REPLY)?.let {
          val word = Word(it)
          wordViewModel.updateword(word)
          Unit
          *//*val id: Int =-1
                if(id!=-1)
                {
                   wordViewModel.updateword(word)
                    Toast.makeText(this, R.string.able_to_update, Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this, R.string.unable_to_update, Toast.LENGTH_LONG).show()
                }*//*
            }
        }
        else if(requestCode == delWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
                val word = Word(it)
                wordViewModel.deleteword(word)
                Unit
            }
        }*/


/* fun launchUpdateWordActivity(word: Word) {
     val intent = Intent(this, NewWordActivity::class.java)
     intent.putExtra(MainActivity.EXTRA_DATA_UPDATE_WORD, word.getWord())
     intent.putExtra(MainActivity.EXTRA_DATA_ID, word.getId())
     startActivityForResult(intent, MainActivity.UPDATE_WORD_ACTIVITY_REQUEST_CODE)
 }*/
/*val fabupt = findViewById<FloatingActionButton>(R.id.fab_upt)
    fabupt.setOnClickListener {
        val intent = Intent(this@MainActivity, UpdateWordActivity::class.java)
        startActivityForResult(intent, updateWordActivityRequestCode)
    }
    val fabdel = findViewById<FloatingActionButton>(R.id.fab_delete)
    fabdel.setOnClickListener {
        val intent = Intent(this@MainActivity, DeleteWordActivity::class.java)
        startActivityForResult(intent, delWordActivityRequestCode)
    }*/
/*adapter.setOnItemClickListener(object : WordListAdapter.ClickListener() {
    fun onItemClick(v: View?, position: Int) {
        val word: Word = adapter.getWordAtPosition(position)
        launchUpdateWordActivity(word)
    }
})*/

//    private val delWordActivityRequestCode = 3
//    private val updateWordActivityRequestCode = 2
/*    val EXTRA_DATA_UPDATE_WORD = "extra_word_to_be_updated"
    val EXTRA_DATA_ID = "extra_data_id"*/