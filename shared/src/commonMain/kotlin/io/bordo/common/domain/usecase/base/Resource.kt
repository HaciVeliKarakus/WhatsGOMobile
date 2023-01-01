package io.bordo.common.domain.usecase.base

import io.bordo.common.domain.model.Player

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: List<Player>) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}