package br.com.company.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.company.dao.BandaDao;
import br.com.company.models.Banda;
import jakarta.validation.Valid;


@Controller
public class BandaController {

    @Autowired
    private BandaDao bandaRepository;

    @GetMapping("/inserirBandas")
    public ModelAndView bandas(Banda banda) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Banda/formBanda");
        mv.addObject("banda", new Banda());
        return mv;
    }

    @PostMapping("insertBandas")
    public ModelAndView insertColaboradores(@Valid Banda banda, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("Banda/formBanda");
            mv.addObject("banda");
        } else {
            mv.setViewName("redirect:/bandas-adicionadas");
            bandaRepository.save(banda);
        }
        return mv;
    }

    @GetMapping("bandas-adicionadas")
    public ModelAndView listagemBandas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Banda/listBandas");
        mv.addObject("listBandas", bandaRepository.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Banda/alterar");
        Optional<Banda> banda= bandaRepository.findById(id);
        mv.addObject("banda", banda);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Banda banda) {
        ModelAndView mv = new ModelAndView();
        bandaRepository.save(banda);
        mv.setViewName("redirect:/bandas-adicionadas");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirBanda(@PathVariable("id") Integer id) {
        bandaRepository.deleteById(id);
        return "redirect:/bandas-adicionadas";
    }

}
