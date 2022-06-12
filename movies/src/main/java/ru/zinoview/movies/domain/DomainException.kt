package ru.zinoview.movies.domain

import okio.IOException

abstract class DomainException : IOException() {

    class NoInternetConnection : DomainException()

    class SomethingWentWrong : DomainException()

    class LongConnection : DomainException()
}