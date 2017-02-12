package com.pierre.vanderpol.weatherapp.UI.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.pierre.vanderpol.weatherapp.R
import com.pierre.vanderpol.weatherapp.UI.adapters.ForecastListAdapter
import com.pierre.vanderpol.weatherapp.domain.commands.RequestForecastCommand
import com.pierre.vanderpol.weatherapp.domain.model.Forecast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)


        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                //if only need one parameter, use -it-”
                val adapter = ForecastListAdapter(result){ toast(it.date)  }
                forecastList.adapter = adapter
            }
        }

    }
}
