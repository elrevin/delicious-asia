package me.elrevin.core

sealed class Either<out T> (

) {
    // Operation was successful
    class Success<T>(internal val value: T): Either<T>()

    // Failure but not exception, for example - server returns "Login is busy"
    class Failure<T>(internal val message: String): Either<T>()

    // All is lost
    class Exception<T>(internal val e: Throwable): Either<T>()

    companion object {
        fun <T>success(value: T): Either<T> = Success(value)

        fun <T>failure(message: String): Either<T> = Failure(message)

        fun <T>exception(e: Throwable): Either<T> = Exception(e)

        /**
         * Only for failures and exceptions. It can be used when failure or exception happen, but
         * you need Either with another value type
         */
        fun <T>fromEither(another: Either<Any?>): Either<T> = when {
            another.isFailure() -> Failure(another.getFailureMessageOrNull()!!)
            another.isException() -> Exception(another.getThrowableOrNull()!!)
            else -> throw kotlin.Exception("Either.fromEither can used only for failures and exceptions")
        }
    }

    fun isSuccess() = this is Success
    fun isFailure() = this is Failure
    fun isException() = this is Exception

    fun getValueOrNull(): T? = if (isSuccess()) (this as Success).value else null

    fun getValue(): T = (this as Success).value

    fun getFailureMessageOrNull(): String? = if (isFailure()) (this as Failure).message else null

    fun getThrowableOrNull(): Throwable? = if (isException()) (this as Exception).e else null
}