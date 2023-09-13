package me.elrevin.core

sealed class Either<out T> {
    // Operation was successful
    class Success<T>(internal val value: T): Either<T>()

    // Failure but not exception, for example - server returns "Login is busy"
    class Failure<T>(internal val code: Int): Either<T>()

    // All is lost
    class Exception<T>(internal val e: Throwable): Either<T>()

    // We are waiting some data from server
    class Loading<T>(): Either<T>()

    companion object {
        fun <T>success(value: T): Either<T> = Success(value)
        fun success(): Either<Unit> = Success(Unit)

        fun <T>failure(code: Int): Either<T> = Failure(code)

        fun <T>exception(e: Throwable): Either<T> = Exception(e)

        fun <T>loading(): Either<T> = Loading()

        /**
         * Only for not successful. It can be used when failure or exception happen or loading in progress,
         * but you need Either with another value type
         */
        fun <T>fromEither(another: Either<Any?>): Either<T> = when {
            another.isFailure() -> Failure(another.getFailureCodeOrNull()!!)
            another.isException() -> Exception(another.getThrowableOrNull()!!)
            another.isLoading() -> Loading()
            else -> throw kotlin.Exception("Either.fromEither can used only for not successful")
        }
    }

    fun isSuccess() = this is Success
    fun isFailure() = this is Failure
    fun isException() = this is Exception
    fun isLoading() = this is Loading

    fun getValueOrNull(): T? = if (isSuccess()) (this as Success).value else null

    fun getValue(): T = (this as Success).value

    fun getFailureCodeOrNull(): Int? = if (isFailure()) (this as Failure).code else null

    fun getThrowableOrNull(): Throwable? = if (isException()) (this as Exception).e else null
}