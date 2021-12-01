package com.ericmulek.adventofcode2021

import org.springframework.core.io.ClassPathResource
import spock.lang.Shared
import spock.lang.Specification

class Day1Spec extends Specification {

    @Shared
    List<Integer> depths = new ClassPathResource('day1Input.txt').inputStream.text.readLines()
        .collect {
            it as int
        }

    void "Part1"() {
        given:
        int increases = depths.collate(2, 1).findAll {
            it.first() < it.last()
        }.size()

        expect:
        increases == 1696
    }

    void "Part2"() {
        given:
        int increases = depths.collate(3, 1).collect {
            it.sum()
        }.collate(2, 1).findAll {
            it.first() < it.last()
        }.size()

        expect:
        increases == 1737
    }
}
