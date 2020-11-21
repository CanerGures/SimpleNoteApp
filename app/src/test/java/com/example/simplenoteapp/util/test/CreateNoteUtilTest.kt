package com.example.simplenoteapp.util.test

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CreateNoteUtilTest {

    @Test
    fun `both entries are entered return true`() {
        val result = CreateNoteUtil.validateNoteCreation(
            "test1Title",
            "tes1DescRiption"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `title is empty return false`() {
        val result = CreateNoteUtil.validateNoteCreation(
            "",
            "tes1DescRiption"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `description is empty return false`() {
        val result = CreateNoteUtil.validateNoteCreation(
            "test1Title",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `both entries are empty return false`() {
        val result = CreateNoteUtil.validateNoteCreation(
            "",
            ""
        )
        assertThat(result).isFalse()
    }
}