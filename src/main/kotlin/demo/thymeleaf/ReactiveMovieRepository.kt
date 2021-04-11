package demo.thymeleaf

import reactor.core.publisher.Flux
import java.time.Duration

class ReactiveMovieRepository : MovieRepository {


    private val movies: List<Movie> = listOf(
            Movie("Polar (2019)", 64),
            Movie("Iron Man (2008)", 79),
            Movie("The Shawshank Redemption (1994)", 93),
            Movie("Forrest Gump (1994)", 83),
            Movie("Glass (2019)", 70)
    )


    override fun findAll(): Flux<Movie> {
        //simulate stream data with 2 seconds delay.
        return Flux.fromIterable(movies).delayElements(Duration.ofSeconds(2))
    }
}
