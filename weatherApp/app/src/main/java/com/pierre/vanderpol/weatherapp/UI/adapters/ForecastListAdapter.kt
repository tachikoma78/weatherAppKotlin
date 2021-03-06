package com.pierre.vanderpol.weatherapp.UI.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pierre.vanderpol.weatherapp.R
import com.pierre.vanderpol.weatherapp.UI.utils.ctx
import com.pierre.vanderpol.weatherapp.domain.model.Forecast
import com.pierre.vanderpol.weatherapp.domain.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by piva on 2017-02-07.
 */
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick:(Forecast) -> Unit) :
RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    // “we don’t need to specify the return type of a function if it can be computed by the compile”
    //override fun getItemCount(): Int = weekForecast.size
    override fun getItemCount() = weekForecast.size

    //“function will receive a forecast and return nothing”
    class ViewHolder(val view: View, val itemClick: (Forecast) ->Unit) : RecyclerView.ViewHolder(view){
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast){
            with(forecast){

                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high}º"
                minTemperatureView.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    /*
    interface OnItemClickListener{
        operator fun invoke(forecast:Forecast)
    }
    */
}