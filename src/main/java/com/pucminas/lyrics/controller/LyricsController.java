package com.pucminas.lyrics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pucminas.lyrics.api.MusixMatchAPIClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Consulta letra de músicas")
@RestController
@RequestMapping("/")
public class LyricsController {
	private MusixMatchAPIClient musixClient;

	@HystrixCommand(fallbackMethod = "getDefaultLyrics")	
	@ApiOperation(value = "Recupera letra musical passando o artista e o nome da música.", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Letra musical recuperada com sucesso!"),
	    @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso."),
	    @ApiResponse(code = 403, message = "Proibido acessar esse recurso."),
	    @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado.") }
	)	    
	@GetMapping("v1/app/letra/{artista}/{musica}")
	@CrossOrigin(origins = "http://localhost:8080")
	public String getLyrics(@PathVariable String artista,
						    @PathVariable String musica){
		
		musixClient = new MusixMatchAPIClient();
		String song = musica.toLowerCase();
		String artistName = artista;
		try {
			int trackID = musixClient.searchForSongReturnTrackID(song, artistName);
			return musixClient.toString(trackID);
		} catch(Exception e){
			return "Letra Musical não disponível";
		}
	}
	
	public String getDefaultLyrics() {
	    return "Consulta indisponível, tente novamente mais tarde!!!";
	}	

}
