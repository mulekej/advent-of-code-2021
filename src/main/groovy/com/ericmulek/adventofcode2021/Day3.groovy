package com.ericmulek.adventofcode2021

import org.springframework.core.io.ClassPathResource

class Day3 {

    List<List<Integer>> bits
    int bitLength

    void init(String file) {
        bits = new ClassPathResource(file).inputStream.readLines().collect {
            it.chars as List<Integer>
        }
        bitLength = bits[0].size()
    }

    int process() {
        ['max','min'].collect {
            doesAThing(it)
        }.with {
            it.first() * it.last()
        }
    }

    private Integer doesAThing(String minOrMax) {
        (0..bitLength-1).collect {
            bits*.getAt(it).groupBy { it }
        }.collect {
            it."$minOrMax" {it.value.size()}.key
        }.join('').with {
            Integer.parseInt(it, 2)
        }
    }
}
