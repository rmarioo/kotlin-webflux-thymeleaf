package demo.thymeleaf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ThymeleafDemoConfiguration {

    @Bean
    fun movieRepository(): MovieRepository {
        return ReactiveMovieRepository()
    }
}
