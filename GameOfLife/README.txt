_____________________________________________________________________________________

  G A M E   O F   L I F E
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informações a cerca das mudanças na implementação do jogo
  Game of Life desenvolvido nas aulas de Programação Orientada a Objetos.

_____________________________________________________________________________________

 CONTEÚDOS
___________

	1) INFORMAÇÕES BÁSICAS DO PROJETO
	2) INSTRUÇÕES
	3) MUDANÇAS GERAIS
	4) NOVAS ESTRATÉGIAS

_____________________________________________________________________________________

 1) INFORMAÇÕES BÁSICAS DO PROJETO
___________________________________

Programação Orientada a Objetos - 2/2015
Professor: Rodrigo Bonifácio
Integrantes: Marcos Paulo Cayres Rosa  (14/0027131)
	     Rennê Ruan Alves Oliveira (14/0030930)

O projeto em questão foi desenvolvido em linguagem Java, contém a realização do
modelo de Game of Life proposto por Conway e segue os padrões de implementação do 
tipo Strategy (auxiliado pelo acréscimo de injeção de dependência), tal que a
estratégia do Game possa ser alterada em seu momento de execução. Ademais, contém
uma interface gráfica simples que dispõe ao usuário a liberdade de escolher o 
tamanho do tabuleiro das células, este que suporta a noção de ambiente infinito, e 
apresenta diversos botões interativos que realizam funções de chamada da próxima
geração, simulação automática (com velocidade adaptável), aleatorizar as células do
tabuleiro e resetar o tabuleiro. Como também, as diferentes estratégias de 
implementação do GameOfLife podem ser alternadas facilmente pelos botões ao lado 
direito da interface e as estatísticas são atualizadas na parte inferior, indicando
quantas gerações, células vivas e células mortas houveram.

_____________________________________________________________________________________

 2) INSTRUÇÕES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na opção "File" e, então, "Import 
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	3. Abrir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a única opção que surgir para Main
	   Class em "Search...";
	4. Quando o programa já estiver rodando, irá abrir uma janela pedindo para
	   definir as dimensões do tabuleiro. Após a escolha, de acordo com os eixos
	   evidenciados, aplicar as definições pelo botão no canto direito. Padrão:
	   10 linhas e 10 colunas;
	5. Observando o jogo de fato, poderá escolher o que deseja fazer em seguida
	   de acordo com as opções listados a seguir:
		i.	Clicando em qualquer um dos quadrados da tabela central irá
			tornar uma célula viva e, fazendo o mesmo novamente, morta;
		ii.	Lista de estratégias do lado direito - escolher a que será
			implementada. Padrão: Conway;
		iii.	Próxima geração - irá apresentar a geração seguinte, de
			acordo com a estratégia escolhida;
		iv.	Resetar - define todas as células do tabuleiro como mortas;
		v.	Random - aleatoriza um conjunto de células para ficarem
			vivas, sendo acumulativo (efetuando mais randomizações,
			as que estiverem vivas permanecerão e só serão adicionadas
			mais a essa lista);
		vi.	Simulação automática - chama automaticamente as próximas
			gerações, de acordo com a velocidade definida no scroll
			abaixo desta. Padrão: 2 (segundos);
		vii.	Finalizar simulação - para o processo da simulação
			automática. Isso acontece automaticamente caso o número de
			células vivas seja nulo;
		viii.	Sair - para de rodar o jogo, o mesmo que ao fechar a janela.
	
	Observação: o programa foi desenvolvido como Maven Project, para permitir a
	implementação do Google Guice (assim como será explicado no tópico 3). Caso
	não tenha vindo instalado junto com sua IDE e isso faça com que ocorra um
	erro na importação, procure providenciar a instalação dele em sua máquina ou
	baixe a versão mais recente do Eclipse (Kepler 4.3 e posteriores) que já o
	terá integrado.

_____________________________________________________________________________________

 3) MUDANÇAS GERAIS
____________________

Segue abaixo uma lista com as mudanças efetuadas, de acordo com o que foi
especificado como obrigatório pelo professor:

	- Suporte a ambiente infinito, considerando as bordas laterais e as
	  verticais como complementares e fazendo, assim, com que todas as células
	  tenham oito outras vizinhas;
	- Opção de simulação automática ao apertar o botão correspondente, inclusive
	  com a possibilidade de definir a velocidade para a chamada da próxima
	  geração;
	- Utilizando Java Swing, implementou-se uma inteface gráfica;
	- Aumento da flexibilidade pela aplicação do padrão de injeção de dependência
	  através do Google Guice. Para isso, o projeto deixou de ser do tipo Java
	  Project e virou Maven Project, criou-se a classe AdicionarEstrategia,
	  na qual implementa-se o framework em questão e permite que as regras de 
	  derivação não sejam instaciadas diretamente, mas injetadas.

Além disso, acrescentamos algumas funcionalidades além das exigidas, para tornar o
programa mais completo e confiável:

	- Definição das dimensões do tabuleiro, para não ser apenas o fixado 10x10;
	- Tornar uma célula morta, selecionando novamente a área representada por
	  esta no tabuleiro;
	- Opção de resetar, caso o usuário queira recomeçar o procedimento e não
	  tenha que matar cada célula separadamente;
	- Apresentação mutável das estatísticas enquanto executa-se o jogo e não
	  apenas ao pará-lo;
	- Inclusão de mais seis estrégias, descritas no tópico 4;
	- Execução de testes manuais que cobriram 97% do código, assim como visto
	  pelos resultados do framework Emma dispostos na pasta "coverage". Para
	  visualização disso, abrir os arquivos html presentes dentro dessa pasta
	  no navegador de preferência.

_____________________________________________________________________________________

 4) NOVAS ESTRATÉGIAS
______________________

Abaixo estão descritas as diversas estratégias de derivação aplicadas no jogo, sendo
que as indicadas por um asterisco foram adicionadas pelo grupo.

	Conway: 

		A estratégia padrão do jogo, tal que apresenta um comportamento
		caótico, sendo a mais estudada e analisada. A célula se mantém viva 
		se tiver 2 a 3 vizinhos e irá reviver apenas se tiver 3 vizinhos.

	HighLife:

		Uma estratégia bastante similar a Conway que também apresenta
		comportamento caótico, porém mostra características de um 
		replicador de formas. Sua diferença para a estratégia Conway é que a 
		célula também irá ressucitar se possuir 6 vizinhos.

	*LifeWithoutDeath:

		Tal estratégia é bastante intuitiva pelo seu nome e apresenta um 
		caráter expansivo, as células nunca irão morrer e células novas 
		irão nascer apenas se possuirem 3 vizinhos vivos. Assim, cria 
		diversas formas com comportamento de frascos, tal que após gerações,
		as células iniciais se tornarão uma "maciça" estrutura com vários 
		"buracos".

	LiveFreeOrDie:

		Estratégia que possui caráter explosivo, onde as células irão
		sobreviver apenas se não tiverem vizinhos e células irão nascer
		somente se possuírem 2 vizinhos vivos.

	*Maze:

		Esta regra é caracterizada pela sua expansão que, após algumas
		gerações, o tabuleiro irá tomar a forma de um labirinto. No caso,
		células irão se manter vivas se tiverem de 1 a 5 vizinhos vivos, e 
		células mortas nascerão apenas se possuirem 3 vizinhos.

	*Mazectric:
		
		Regra que estende de Maze, de forma que, ao invés das células
		sobreviverem até com 5 vizinhos, a sobrevivência se dará até 4 
		vizinhos, a diferença entre regras se da pelo fato que a Mazectric 
		apresenta "corredores" de labirinto mais esguios.

	*Move:

		Nesta regra as células sobreviverão se possuirem 2, 4 ou 5 vizinhos,
		células mortas irão nascer se possuirem 3, 6 ou 8. A característica
		de tal regra é que geralmente a estabilização do tabuleiro é
		alcançada de maneira mais rápida que a regra padrão.

	*Replicator:

		Modelo base de replicador, tal que uma célula se mantém viva ou
		renasce se possuir números ímpares de vizinhos.

	*Seeds:

		Comportamento explosivo de células, onde todas as células da atual
		geração irão continuar, porém novas células nascerão se tiverem
		exatamente 2 vizinhos.

_____________________________________________________________________________________
_____________________________________________________________________________________