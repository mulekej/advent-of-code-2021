package com.ericmulek.adventofcode2021

import org.springframework.core.io.ClassPathResource
import java.util.Map.Entry

class Day3 {

    List<List<Integer>> numberList
    int bitLength

    void init(String file) {
        numberList = new ClassPathResource(file).inputStream.readLines().collect {
            it.chars.collect {
                it.toString().toInteger()
            }
        }
        bitLength = numberList[0].size()
    }

    int processPowerConsumption() {
        ['max', 'min'].collect {
            doesAThing(it)
        }.inject { previous, current ->
            previous * current
        }
    }

    private Integer doesAThing(String minOrMax) {
        (0..bitLength - 1).collect {
            numberList*.getAt(it).groupBy { it }
        }.collect {
            it."$minOrMax" { it.value.size() }.key
        }.join('').with {
            Integer.parseInt(it, 2)
        }
    }

    int processLifeSupportRating() {
        ['max', 'min'].collect {
            doesAMoreComplicatedThing(it)
        }.inject { previous, current ->
            previous * current
        }
    }

    private Integer doesAMoreComplicatedThing(String minOrMax) {
        def bitRange = 0..bitLength - 1

        def currentList = numberList
        bitRange.each { Integer position ->
            def requiredBitPerPosition = bitRange.collect {
                currentList*.getAt(it).groupBy { it }
            }.collect {
                it."$minOrMax" { a, b ->
                    def sizeCompare = a.value.size() <=> b.value.size()
                    def bob = sizeCompare ?: a.key <=> b.key
                    bob
                }.key
            }
            def matchedNumbers = currentList.findAll { numberBits ->
                numberBits[position] == requiredBitPerPosition[position]
            }

            if (matchedNumbers) {
                currentList = matchedNumbers
            }
        }

        currentList.flatten().join('').with {
            Integer.parseInt(it, 2)
        }
    }
}
