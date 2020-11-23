package com.example.simplenoteapp.util.test

import com.example.simplenoteapp.util.validateImageUrl
import com.example.simplenoteapp.util.validateNoteCreate
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import org.junit.Test

class AppUtilsTest : TestCase() {

    @Test
    fun testOneBothNotEmpty() {
        val result = validateNoteCreate(
            "Test1",
            "Test1"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun testTwoNoteEmpty() {
        val result = validateNoteCreate(
            "Test1",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun testThreeTitleEmpty() {
        val result = validateNoteCreate(
            "",
            "Test1"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun testFourBothEmpty() {
        val result = validateNoteCreate(
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    fun testOneImageLinkWithoutProtocol() {
        val expected = "https://imgur.com/gallery/sMEMmti"
        val result = validateImageUrl(
            "imgur.com/gallery/sMEMmti"
        )
        assertEquals(expected,result)
    }

    fun testTwoImageLinkWithProtocol() {
        val expected = "https://imgur.com/gallery/sMEMmti"
        val result = validateImageUrl(
            "https://imgur.com/gallery/sMEMmti"
        )
        assertEquals(expected,result)
    }

}