package com.ericmulek.adventofcode2021

import spock.lang.Specification

class Day2Spec extends Specification {

    Day2 systemUnderTest

    void setup() {
        systemUnderTest = new Day2().tap {
            it.init('day2Input.txt')
        }
    }

    void "Part1"() {
        expect:
        systemUnderTest.engage() == 2027977
    }

    void "Part2"() {
        expect:
        systemUnderTest.enhancedEngage() == 1903644897
    }
}
