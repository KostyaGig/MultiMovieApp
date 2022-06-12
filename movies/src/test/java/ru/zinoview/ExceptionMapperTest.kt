package ru.zinoview

import org.junit.Test

import org.junit.Assert.*
import ru.zinoview.core.Mapper
import java.lang.IllegalStateException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExceptionMapperTest {

    @Test
    fun test_exception_to_string_mapper() {
        var dataException : Exception = UnknownHostException()
        val dataToDomainMapper = MoviesMapperTest.TestDataToDomainExceptionMapper()
        var domainException = dataToDomainMapper.map(dataException)

        val domainToUiStringMapper = DomainExceptionToUiStringMapper()

        var expected = "No connection"
        var actual = domainToUiStringMapper.map(domainException)

        assertEquals(expected, actual)

        dataException = SocketTimeoutException()
        domainException = dataToDomainMapper.map(dataException)

        expected = "Long  connection to server"
        actual = domainToUiStringMapper.map(domainException)

        assertEquals(expected, actual)

        dataException = IllegalStateException()
        domainException = dataToDomainMapper.map(dataException)

        expected = "Something went wrong"
        actual = domainToUiStringMapper.map(domainException)

        assertEquals(expected, actual)
    }

    class DomainExceptionToUiStringMapper : Mapper<MoviesMapperTest.TestDomainException,String> {
        override fun map(src: MoviesMapperTest.TestDomainException): String {
            return when(src) {
                is MoviesMapperTest.TestDomainException.NoConnection -> "No connection"
                is MoviesMapperTest.TestDomainException.LongConnection -> "Long  connection to server"
                else -> "Something went wrong"
            }
        }

    }
}