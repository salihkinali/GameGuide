package com.salihkinali.gameguide.data.mapper

interface GameMapper<INPUT,OUTPUT> {
    fun map(input:INPUT):OUTPUT
}

