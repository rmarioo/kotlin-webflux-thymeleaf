package demo.thymeleaf

import reactor.core.publisher.Flux

interface MovieRepository {

    fun findAll(): Flux<Movie>
}
