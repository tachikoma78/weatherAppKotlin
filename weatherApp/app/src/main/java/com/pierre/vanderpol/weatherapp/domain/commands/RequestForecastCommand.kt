package com.pierre.vanderpol.weatherapp.domain.commands

import com.pierre.vanderpol.weatherapp.data.ForecastRequest
import com.pierre.vanderpol.weatherapp.domain.mappers.ForecastDataMapper
import com.pierre.vanderpol.weatherapp.domain.model.ForecastList

/**
 * Created by piva on 2017-02-09.
 */
class RequestForecastCommand(val zipCode:String):Command<ForecastList> {
    override fun execute(): ForecastList {
       val forecastRequest = ForecastRequest(zipCode)
       return ForecastDataMapper().convertDataToModel(forecastRequest.execute())
    }

}