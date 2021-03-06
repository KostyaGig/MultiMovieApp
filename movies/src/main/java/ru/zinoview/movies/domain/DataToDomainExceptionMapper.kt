package ru.zinoview.movies.domain

import ru.zinoview.core.Mapper
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

interface DataToDomainExceptionMapper : Mapper<Exception,DomainException> {

    class Base @Inject constructor(): DataToDomainExceptionMapper {
        override fun map(e: Exception): DomainException {
            return when(e) {
                is UnknownHostException -> DomainException.NoInternetConnection()
                is SocketTimeoutException -> DomainException.LongConnection()
                else  -> DomainException.SomethingWentWrong()
            }
        }
    }
}