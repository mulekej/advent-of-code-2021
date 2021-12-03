package com.ericmulek.adventofcode2021

import spock.lang.Specification

class Day3Spec extends Specification {

    Day3 systemUnderTest

    void setup() {
        systemUnderTest = new Day3().tap {
            it.init('day3Input.txt')
        }
    }

    void "Part1"() {
        when:
        Integer result = systemUnderTest.process()

        then:
        result == 1082324
    }

}
