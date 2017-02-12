package com.pierre.vanderpol.weatherapp.domain.mappers

import com.pierre.vanderpol.weatherapp.data.Forecast
import com.pierre.vanderpol.weatherapp.data.ForecastResult
import com.pierre.vanderpol.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.pierre.vanderpol.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by piva on 2017-02-09.
 */
class ForecastDataMapper {


    fun convertDataToModel(forecast:ForecastResult):ForecastList{
        return ForecastList(forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list:List<Forecast>):List<ModelForecast>{
        // “ loop over the collection ”
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong()) // generate a new date because the one provided is hard to use
            convertForecastItemToDomain(forecast.copy(dt))
        }
    }

    private fun convertForecastItemToDomain(forecast:Forecast):ModelForecast{
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),
                generateIconUrl(forecast.weather[0].icon))
        //val date: String, val description: String, val high: Int, val low: Int
    }

    private fun convertDate(date:Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.getDefault())
        return df.format(date)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}