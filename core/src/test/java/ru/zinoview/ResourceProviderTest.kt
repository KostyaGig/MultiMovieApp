package ru.zinoview

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

internal class ResourceProviderTest {

    private lateinit var resourceProvider: ResourceProvider

    @Before
    fun setUp() {
        resourceProvider = ResourceProvider.Test()
    }

    @Test
    fun success_provide_string_by_id() {

        var id = R.string.no_connection_error_text
        var expected = "No connection"
        var actual = resourceProvider.string(id)

        assertEquals(expected, actual)

        id = R.string.progress_text
        expected = "Progress"
        actual = resourceProvider.string(id)

        assertEquals(expected, actual)
    }

    @Test(expected = IllegalArgumentException::class)
    fun failure_provide_string_by_id() {
        val id = -1
        resourceProvider.string(id)
    }
}