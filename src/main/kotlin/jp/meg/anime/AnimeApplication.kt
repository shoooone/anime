package jp.meg.anime

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnimeApplication

fun main(args: Array<String>) {
    runApplication<AnimeApplication>(*args)
}
