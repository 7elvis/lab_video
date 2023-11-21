
package com.example.Base_Conciertos.controller;

import com.example.Base_Conciertos.entity.Artista;
import com.example.Base_Conciertos.repository.ArtistaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArtistasController {
    final ArtistaRepository artistaRepository;

    public ArtistasController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @GetMapping("/artista")
    public String ListaArtista(Model model){
        List<Artista> lista = artistaRepository.findAll();
        model.addAttribute("listaArtista", lista);
        return "artista";
    }

    @GetMapping("/artista/borrar")
    public String borrar(@RequestParam("id") int id){
        Optional<Artista> optArtista = artistaRepository.findById(id);
        optArtista.ifPresent(artistaRepository::delete);
        return "redirect:/artista";
    }

    @GetMapping("/artista/editar")
    public String editar(Model model, @RequestParam("id") int id){
        Optional<Artista> optArtista = artistaRepository.findById(id);
        optArtista.ifPresent(arti -> model.addAttribute("arti", arti));
        return "artistaForm";
    }

    @PostMapping(value = "/artista/guardar")
    public String guardarArtista(@ModelAttribute("arti") Artista artista){
        artistaRepository.save(artista);
        return "redirect:/artista";
    }
}
