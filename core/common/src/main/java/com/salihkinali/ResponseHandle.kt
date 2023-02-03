package com.salihkinali

import com.salihkinali.common.NetworkResponse

fun <I:Any,O:Any> NetworkResponse<I>.mapResponse(mapper:I.()->O): NetworkResponse<O> {
    return when(this){
        is NetworkResponse.Error -> NetworkResponse.Error(this.exception)
        NetworkResponse.Loading -> NetworkResponse.Loading
        is NetworkResponse.Success -> NetworkResponse.Success(mapper.invoke(this.result))
    }
}