package com.salihkinali.common.mapper

interface GameMapper<INPUT,OUTPUT> {
    fun map(input:INPUT):OUTPUT
}

