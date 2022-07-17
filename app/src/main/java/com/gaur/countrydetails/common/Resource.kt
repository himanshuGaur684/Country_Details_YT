package com.gaur.countrydetails.common

sealed class Resource<T>(message:String?=null,data:T?=null){

    class Loading<T> : Resource<T>()
    class Success<T>(data: T?): Resource<T>(data=data)
    class Error<T>(message: String?) : Resource<T>(message = message)

}
