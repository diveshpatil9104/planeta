package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewholder>() {

    class myViewholder(View: View) : RecyclerView.ViewHolder(View) {
        var title = View.title
        var planetimg = View.planet_img
        var galaxy = View.galaxy
        var distance = View.distance
        var gravity = View.gravity


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewholder(itemView)
    }

    override fun onBindViewHolder(holder: myViewholder, position: Int) {
        var dummyImg: Int? = null
        holder.itemView.setOnClickListener {
            val intent= Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImg)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " m km"
        holder.gravity.text = planet[position].title + " m/ss"

        when (planet[position].title!!.lowercase(Locale.getDefault())) {
            "mars" -> {
                dummyImg = R.drawable.mars
            }
            "neptune" -> {
                dummyImg = R.drawable.neptune
            }
            "earth" -> {
                dummyImg = R.drawable.earth
            }
            "moon" -> {
                dummyImg = R.drawable.moon
            }
            "venus" -> {
                dummyImg = R.drawable.venus
            }
            "saturn" -> {
                dummyImg = R.drawable.saturn
            }
            "mercury" -> {
                dummyImg = R.drawable.mercury
            }
            "jupiter" -> {
                dummyImg = R.drawable.jupiter
            }
            "uranus" -> {
                dummyImg = R.drawable.uranus
            }
            "sun" -> {
                dummyImg = R.drawable.sun
            }
        }
        holder.planetimg.setImageResource(dummyImg!!)


    }


    override fun getItemCount(): Int {
        return planet.size

    }


}