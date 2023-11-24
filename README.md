# Desafio Android Alura Murilo
### Sobre o projeto 
Esse projeto foi baseado no desafio de [7 Days of Code de Android](https://7daysofcode.io/matricula/android) feito pela alura.</br>

É um projeto Android em Kotlin, que  roda em aparelhos android a partir da versão 7.0 (SDK 24) até a versão mais atual (até o momento), a 14 (SDK 34).</br>
Ele usa principios de arquitetura android e utiliza o modelo MVVM.</br>

No projeto original, ele se consiste em fazer a conexão de Rest API com o site do Github para carregar as informações e projetos do usuário, e mostrar dentro do Aplicativo.</br>

Neste projeto, temos a tela principal, que contém a imagem do usuário, nome, username e os projetos contidos na conta dele.</br>

### Coisas acrescidas neste projeto
Diferente do projeto original, caso o usuário não estivesse conectado à internet ou houvesse algum tipo de exceção durante o carregamentos das informações, o app iria crashar. Mas neste caso, temos um tratamento para esse tipo de exceção, e teremos uma tela onde mostra que houve erro ao carregar a página, além da possibilidade de carregar novamente com o clique de um botão.</br>

Também no projeto original, enquanto as requisições API não estão prontas, não há um indicativo de que está tendo um carregamento, a tela fica em branco. Para isso, implementei uma tela de carregamento enquanto as requisições não estão completas.</br>

Outra alteração foi a implementação do Hilt para injeção de dependencias, além de testes indivíduais, testes de Mock e Testes de UI para garantir o funcionamento do aplicativo</br>

### Plugin utilizados

 - Hilt
 - Retrofit
 - Converter Gson
 - Jetpack Compose
 - Material 3
 - Coil Compose
 - Junit 4
 - Kluent
 - Navigation Tests
 - Mockk
 - Ui Automator
 - Hilt Android Testing
 - Espresso
