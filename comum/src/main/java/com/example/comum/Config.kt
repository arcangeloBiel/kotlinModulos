package com.example.comum
//import splitties.resources.appStr
object Config {

    private var base :String =  ""

    val BASE_URL_AUTH_PROD by lazy { R.string.API_PROD_AUTHENTIAPI_URL  }

    fun retornaBase(): String{
//        if(!PICKING_IS_HOMOLOG){
//            base =  appStr(R.string.API_PROD_PRODUT_URL)
//        }
        return base
    }
}