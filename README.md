# app-lyrics!

API que disponibiliza letras de **músicas** utilizando a plataforma **Musixmatch**. 
- A API foi desenvolvida para ser integrada com o microserviço **app-music**.

![enter image description here](https://lh3.googleusercontent.com/Z_hSZsw0irhKEZaxSvWm5GRvPvO9CbyjBf8Uk_vdVEXpCdwBXTABhRlaGC7K6BwjjELkmyh4A9yJ "app-lyrics-modelo")

Parte do modelo arquitetural representa a comunicação com a API musicmatch. O app-music faz uma requisição ao recurso "letras" passando como parâmetro o artista e a música. Caso encontrada, a letra será retornada de forma reduzida, limitação para o uso gratuito do serviço.

O microsserviço foi documentado utilizando o Swagger. Visualização através da seguinte URL:

- http://[host]/swagger-ui.html

- Implementado o padrão "Circuit Breaker", utilizando o Hystrix, biblioteca desenvolvida pela
NetFlix para evitar problemas de latência e falhas no microsserviço.
