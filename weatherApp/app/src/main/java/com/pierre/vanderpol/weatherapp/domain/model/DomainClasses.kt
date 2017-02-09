package com.pierre.vanderpol.weatherapp.domain.model

/**
 * Created by piva on 2017-02-08.
 */
// “Data classes are a powerful kind of classes which avoid the boilerplate we need in Java to create POJO: ”
//The first command needs to request the forecast to the API and convert it to domain classes. This is the definition of the domain classes:”
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
data class Forecast(val date: String, val description: String, val high: Int, val low: Int)