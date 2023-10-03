package br.com.company.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.company.dao.ColaboradorDao;
import br.com.company.models.Colaborador;
import jakarta.validation.Valid;


@Controller
public class ColaboradorController {

    @Autowired
    private ColaboradorDao colaboradorRepository;

    @GetMapping("/inserirColaboradores")
    public ModelAndView colaboradores(Colaborador colaborador) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Colaborador/formColaborador");
        mv.addObject("colaborador", new Colaborador());
        return mv;
    }

    @PostMapping("insertColaboradores")
    public ModelAndView insertColaboradores(@Valid Colaborador colaborador, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if (br.hasErrors()) {
            mv.setViewName("Colaborador/formColaborador");
            mv.addObject("colaborador");
        } else {
            mv.setViewName("redirect:/colaboradores-adicionados");
            colaboradorRepository.save(colaborador);
        }
        return mv;
    }

    @GetMapping("colaboradores-adicionados")
    public ModelAndView listagemColaboradores() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Colaborador/listColaboradores");
        mv.addObject("listColaboradores", colaboradorRepository.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("Colaborador/alterar");
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        mv.addObject("colaborador", colaborador);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Colaborador colaborador) {
        ModelAndView mv = new ModelAndView();
        colaboradorRepository.save(colaborador);
        mv.setViewName("redirect:/colaboradores-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirColaborador(@PathVariable("id") Integer id) {
        colaboradorRepository.deleteById(id);
        return "redirect:/colaboradores-adicionados";
    }

}
