package ru.zinoview.movies.presentation

import ru.zinoview.core.Mapper
import ru.zinoview.core.ResourceProvider
import ru.zinoview.movies.R
import ru.zinoview.movies.domain.DomainException

interface DomainExceptionToUiStringMapper : Mapper<DomainException,String> {

    class Base(
        private val resourceProvider: ResourceProvider
    ) : DomainExceptionToUiStringMapper {

        override fun map(e: DomainException): String {
            return when(e) {
                is DomainException.NoInternetConnection -> resourceProvider.string(R.string.no_connection_error_text)
                is DomainException.LongConnection -> resourceProvider.string(R.string.long_connection_error_text)
                else  -> resourceProvider.string(R.string.something_went_wrong_error_text)
            }
        }
    }
}