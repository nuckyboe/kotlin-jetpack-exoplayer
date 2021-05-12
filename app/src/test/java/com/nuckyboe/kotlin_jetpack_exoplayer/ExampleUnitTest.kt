package com.nuckyboe.kotlin_jetpack_exoplayer

import android.os.FileUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testPrint() {
        com.nuckyboe.kotlin_jetpack_exoplayer.FileUtils.print("i am coming")
    }
}