package com.gaur.countrydetails.common

sealed class Resource<T>(message:String?=null,data:T?=null){

    class Loading<T> : Resource<T>()
    class Success<T>(val data: T?): Resource<T>(data=data)
    class Error<T>(val message: String?) : Resource<T>(message = message)

}
