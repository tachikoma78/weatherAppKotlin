package com.pierre.vanderpol.weatherapp.UI.utils

import android.content.Context
import android.view.View

/**
 * Created by piva on 2017-02-10.
 */
// extension property
// parent.ctx does not work for view in anko
val View.ctx: Context get() = context // Now any view can make use of it.


