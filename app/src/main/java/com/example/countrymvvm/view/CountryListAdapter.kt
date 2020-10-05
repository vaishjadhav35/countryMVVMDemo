package com.example.countrymvvm.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrymvvm.R
import com.example.countrymvvm.model.Country
import com.example.countrymvvm.util.getProgressDrawable
import com.example.countrymvvm.util.loadImage
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(var context: Context, var countries: ArrayList<Country>): RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun getItemCount() = countries.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])

        holder.itemView.setOnClickListener {
            var intent =Intent(context, MainActivity2::class.java)
            intent.putExtra("name", countries[position].countryName);
            context.startActivity(intent)
        }
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val countryName = view.name
        private val imageView = view.imageView
        private val countryCapital = view.capital
       private val progressDrawable = getProgressDrawable(view.context)


        fun bind(country: Country) {
            countryName.text = country.countryName
            countryCapital.text = country.capital
            imageView.loadImage(country.flag, progressDrawable)
        }
    }
}