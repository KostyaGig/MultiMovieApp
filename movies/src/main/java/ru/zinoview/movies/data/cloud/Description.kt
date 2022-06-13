package ru.zinoview.movies.data.cloud

import ru.zinoview.core.Mapper
import ru.zinoview.core.ResourceProvider

interface Description : Mapper<String,String> {

    class Short : Description {
        override fun map(srcDescripton: String): String {
            return if (srcDescripton.length <= MAX_SHORT_LENGTH) {
                srcDescripton
            } else {
                srcDescripton.substring(START_CUT_INDEX, MAX_SHORT_LENGTH) + "..."
            }
        }

        private companion object {
            private const val MAX_SHORT_LENGTH = 15
            private const val START_CUT_INDEX = 0
        }
    }

    class Empty (
        private val resourceProvider: ResourceProvider
    ) : Description {

        override fun map(src: String)
            = resourceProvider.string(ru.zinoview.R.string.empty_description_text)
    }
}