package me.elrevin.core

sealed class Deferred<out T> (

) {
    class Success<T>(internal val value: T?): Deferred<T>()

    class Failure<T>(internal val message: String): Deferred<T>()

    class Exception<T>(internal val e: Throwable): Deferred<T>()

    companion object {
        fun <T>success(value: T): Deferred<T> = Deferred.Success(value)

        fun <T>failure(message: String): Deferred<T> = Deferred.Failure(message)

        fun <T>exception(e: Throwable): Deferred<T> = Deferred.Exception(e)
    }

    fun isSuccess() = this is Success
    fun isFailure() = this is Failure
    fun isException() = this is Exception

    fun getValueOrNull(): T? = if (isSuccess()) (this as Success).value else null

    fun getFailureMessageOrNull(): String? = if (isFailure()) (this as Failure).message else null

    fun getThrowableOrNull(): Throwable? = if (isException()) (this as Exception).e else null
}