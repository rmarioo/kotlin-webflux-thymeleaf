package demo.thymeleaf

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable

@Controller
class MovieController(private val movieRepository: MovieRepository) {


    @RequestMapping("/movies")
    fun index(model: Model): String {

        // loads 1 and display 1, stream data, data driven mode.
        val reactiveDataDrivenMode: IReactiveDataDriverContextVariable =
            ReactiveDataDriverContextVariable(
                movieRepository.findAll(), 1
            )
        model.addAttribute("movies", reactiveDataDrivenMode)

        // classic, wait repository loaded all and display it.
        //model.addAttribute("movies", movieRepository.findAll());
        return "index"
    }
}
