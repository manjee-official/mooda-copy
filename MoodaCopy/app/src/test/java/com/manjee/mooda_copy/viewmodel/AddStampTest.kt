package com.manjee.mooda_copy.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.maxst.mint.app.view.login.getOrAwaitValue
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AddStampTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var sut: AddStampViewModel

    @Before
    fun setUp() {
        sut = AddStampViewModel("emotion")
    }

    @Test
    fun test_check_content_empty() {
        // Assign

        // Act
        val result = sut.checkEmptyContent("")

        // Assert
       assertThat(result, `is`(false))
    }

    @Test
    fun test_check_content_not_empty() {
        // Assign

        // Act
        val result = sut.checkEmptyContent("Not empty string")

        // Assert
        assertThat(result, `is`(true))
    }

    @Test
    fun stamp_success_matchData() {
        // Assign
        // Constructor parameter

        // Act
        val result = sut.isMatched.getOrAwaitValue()

        assertThat(result, `is`(true))
    }

    // 1. 실패하는 테스트 코드가 없는 프로덕션 코드는 만들지 않는다.
    // 2. 하나의 테스트가 통과되기 전까지 다른 테스트 코드는 만들지 않는다.
    // 3. 하나의 테스트를 성공하기전에는 다른 프로덕션 코드를 만들지 않는다.
}