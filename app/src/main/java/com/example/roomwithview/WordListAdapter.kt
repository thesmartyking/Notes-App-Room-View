package com.example.roomwithview

//import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
/*import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult*/
import androidx.recyclerview.widget.RecyclerView


class WordListAdapter constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    val mContext: Context
    init {
        mContext = context
    }
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()
   //private val clickListener: ClickListener = WordListAdapter(this)

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
        fun wordsItemClick(part: Word, position: Int) {
            wordItemView.setOnClickListener {
                Log.d("WordListAdapter","Test log adapter: "+part.word)
                val intent = Intent(mContext, UpdateWordActivity::class.java)
                intent.putExtra("word_key",part.word)
                mContext.startActivity(intent)
                /*val textword:String =part.word*/


            }
            /*val intent = Intent(this, NewWordActivity::class.java)
            startActivityForResult(intent, 1)*/
            /*itemView.setOnClickListener(
        object : View.OnClickListener {
            override fun onClick(view: View) {
                WordListAdapter.clickListener.onItemClick(view, getAdapterPosition())
            }
        })*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
        holder.wordsItemClick(current,position)

    }
    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
    override fun getItemCount() = words.size

    /*fun getWordAtPosition(position: Int): Word? {
        return words.get(position)
    }
    interface ClickListener {
        fun onItemClick(v: View?, position: Int)

    }*/
    /*fun setOnItemClickListener(clickListener: ClickListener) {
        WordListAdapter.clickListener =
    }*/
    /*class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: PartData, clickListener: (PartData) -> Unit) {
            itemView.tv_part_item_name.text = part.itemName
            itemView.tv_part_id.text = part.id.toString()
            itemView.setOnClickListener { clickListener(part)}
        }
    }*/
}