package com.chelsi.buahmovie.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.chelsi.buahmovie.DetailBuahActivity
import com.chelsi.buahmovie.DetailMovie
import com.chelsi.buahmovie.RecycleCardMovie
import com.chelsi.buahmovie.model.ModelMovie
import com.chelsi.buahmovie.R

class MovieAdapter constructor(
    private val getActivity: RecycleCardMovie, //bisa diklik
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit) :

    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie : TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView : CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_card, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=movieList[position]
        holder.txtMovie.text = movieList[position].title
        holder.imgMovie.setImageResource(movieList[position].image)

        holder.cardView.setOnClickListener(){
            Toast.makeText(
                getActivity, movieList[position].title,
                Toast.LENGTH_SHORT
            ).show()

            holder.itemView.setOnClickListener {
                val intent = Intent(getActivity, DetailMovie::class.java)
                //baru put extra variabel yang ingin dilempar atau passed
                intent.putExtra("teks", movieList[position].title)
                intent.putExtra("image",movieList[position].image)
                intent.putExtra("tanggal",movieList[position].tanggal)
                intent.putExtra("sinopsis",movieList[position].sinopsis)
                //passed ke detail
                getActivity.startActivity(intent)
            }
        }
    }


}