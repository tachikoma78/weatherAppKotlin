package com.pierre.vanderpol.weatherapp.domain.commands

/**
 * Created by piva on 2017-02-09.
 */

// execute an operation and return an object of the class specified in its generic type.

interface Command<T> {
    fun execute():T
}