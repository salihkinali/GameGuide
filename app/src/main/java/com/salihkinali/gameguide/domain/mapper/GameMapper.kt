package com.salihkinali.gameguide.domain.mapper

interface GameMapper<INPUT,OUTPUT> {
    fun map(input:INPUT):OUTPUT
}