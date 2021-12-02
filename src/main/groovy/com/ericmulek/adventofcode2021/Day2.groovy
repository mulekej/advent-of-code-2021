package com.ericmulek.adventofcode2021

import org.springframework.core.io.ClassPathResource

class Day2 {

    List<MapEntry> commands

    void init(String fileName) {
        commands = new ClassPathResource(fileName).inputStream.text.readLines().collect {
            it.split(' ').with {
                new MapEntry(it[0], it[1] as Integer)
            }
        }
    }

    int engage() {
        int x = 0
        int y = 0

        commands.each {
            if (it.key == 'forward') {
                x += it.value
            } else if (it.key == 'down') {
                y += it.value
            } else if (it.key == 'up') {
                y -= it.value
            }
        }
        x * y
    }

    int enhancedEngage() {
        int x = 0
        int y = 0
        int aim = 0

        commands.each {
            if (it.key == 'forward') {
                x += it.value
                y += aim * (it.value as int)
            } else if (it.key == 'down') {
                aim += it.value
            } else if (it.key == 'up') {
                aim -= it.value
            }
        }
        x * y
    }
}
