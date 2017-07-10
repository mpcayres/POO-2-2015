_____________________________________________________________________________________

  G A M E   O F   L I F E
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informa��es a cerca das mudan�as na implementa��o do jogo
  Game of Life desenvolvido nas aulas de Programa��o Orientada a Objetos.

_____________________________________________________________________________________

 CONTE�DOS
___________

	1) INFORMA��ES B�SICAS DO PROJETO
	2) INSTRU��ES
	3) MUDAN�AS GERAIS
	4) NOVAS ESTRAT�GIAS

_____________________________________________________________________________________

 1) INFORMA��ES B�SICAS DO PROJETO
___________________________________

Programa��o Orientada a Objetos - 2/2015
Professor: Rodrigo Bonif�cio
Integrantes: Marcos Paulo Cayres Rosa  (14/0027131)
	     Renn� Ruan Alves Oliveira (14/0030930)

O projeto em quest�o foi desenvolvido em linguagem Java, cont�m a realiza��o do
modelo de Game of Life proposto por Conway e segue os padr�es de implementa��o do 
tipo Strategy (auxiliado pelo acr�scimo de inje��o de depend�ncia), tal que a
estrat�gia do Game possa ser alterada em seu momento de execu��o. Ademais, cont�m
uma interface gr�fica simples que disp�e ao usu�rio a liberdade de escolher o 
tamanho do tabuleiro das c�lulas, este que suporta a no��o de ambiente infinito, e 
apresenta diversos bot�es interativos que realizam fun��es de chamada da pr�xima
gera��o, simula��o autom�tica (com velocidade adapt�vel), aleatorizar as c�lulas do
tabuleiro e resetar o tabuleiro. Como tamb�m, as diferentes estrat�gias de 
implementa��o do GameOfLife podem ser alternadas facilmente pelos bot�es ao lado 
direito da interface e as estat�sticas s�o atualizadas na parte inferior, indicando
quantas gera��es, c�lulas vivas e c�lulas mortas houveram.

_____________________________________________________________________________________

 2) INSTRU��ES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na op��o "File" e, ent�o, "Import 
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	3. Abrir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a �nica op��o que surgir para Main
	   Class em "Search...";
	4. Quando o programa j� estiver rodando, ir� abrir uma janela pedindo para
	   definir as dimens�es do tabuleiro. Ap�s a escolha, de acordo com os eixos
	   evidenciados, aplicar as defini��es pelo bot�o no canto direito. Padr�o:
	   10 linhas e 10 colunas;
	5. Observando o jogo de fato, poder� escolher o que deseja fazer em seguida
	   de acordo com as op��es listados a seguir:
		i.	Clicando em qualquer um dos quadrados da tabela central ir�
			tornar uma c�lula viva e, fazendo o mesmo novamente, morta;
		ii.	Lista de estrat�gias do lado direito - escolher a que ser�
			implementada. Padr�o: Conway;
		iii.	Pr�xima gera��o - ir� apresentar a gera��o seguinte, de
			acordo com a estrat�gia escolhida;
		iv.	Resetar - define todas as c�lulas do tabuleiro como mortas;
		v.	Random - aleatoriza um conjunto de c�lulas para ficarem
			vivas, sendo acumulativo (efetuando mais randomiza��es,
			as que estiverem vivas permanecer�o e s� ser�o adicionadas
			mais a essa lista);
		vi.	Simula��o autom�tica - chama automaticamente as pr�ximas
			gera��es, de acordo com a velocidade definida no scroll
			abaixo desta. Padr�o: 2 (segundos);
		vii.	Finalizar simula��o - para o processo da simula��o
			autom�tica. Isso acontece automaticamente caso o n�mero de
			c�lulas vivas seja nulo;
		viii.	Sair - para de rodar o jogo, o mesmo que ao fechar a janela.
	
	Observa��o: o programa foi desenvolvido como Maven Project, para permitir a
	implementa��o do Google Guice (assim como ser� explicado no t�pico 3). Caso
	n�o tenha vindo instalado junto com sua IDE e isso fa�a com que ocorra um
	erro na importa��o, procure providenciar a instala��o dele em sua m�quina ou
	baixe a vers�o mais recente do Eclipse (Kepler 4.3 e posteriores) que j� o
	ter� integrado.

_____________________________________________________________________________________

 3) MUDAN�AS GERAIS
____________________

Segue abaixo uma lista com as mudan�as efetuadas, de acordo com o que foi
especificado como obrigat�rio pelo professor:

	- Suporte a ambiente infinito, considerando as bordas laterais e as
	  verticais como complementares e fazendo, assim, com que todas as c�lulas
	  tenham oito outras vizinhas;
	- Op��o de simula��o autom�tica ao apertar o bot�o correspondente, inclusive
	  com a possibilidade de definir a velocidade para a chamada da pr�xima
	  gera��o;
	- Utilizando Java Swing, implementou-se uma inteface gr�fica;
	- Aumento da flexibilidade pela aplica��o do padr�o de inje��o de depend�ncia
	  atrav�s do Google Guice. Para isso, o projeto deixou de ser do tipo Java
	  Project e virou Maven Project, criou-se a classe AdicionarEstrategia,
	  na qual implementa-se o framework em quest�o e permite que as regras de 
	  deriva��o n�o sejam instaciadas diretamente, mas injetadas.

Al�m disso, acrescentamos algumas funcionalidades al�m das exigidas, para tornar o
programa mais completo e confi�vel:

	- Defini��o das dimens�es do tabuleiro, para n�o ser apenas o fixado 10x10;
	- Tornar uma c�lula morta, selecionando novamente a �rea representada por
	  esta no tabuleiro;
	- Op��o de resetar, caso o usu�rio queira recome�ar o procedimento e n�o
	  tenha que matar cada c�lula separadamente;
	- Apresenta��o mut�vel das estat�sticas enquanto executa-se o jogo e n�o
	  apenas ao par�-lo;
	- Inclus�o de mais seis estr�gias, descritas no t�pico 4;
	- Execu��o de testes manuais que cobriram 97% do c�digo, assim como visto
	  pelos resultados do framework Emma dispostos na pasta "coverage". Para
	  visualiza��o disso, abrir os arquivos html presentes dentro dessa pasta
	  no navegador de prefer�ncia.

_____________________________________________________________________________________

 4) NOVAS ESTRAT�GIAS
______________________

Abaixo est�o descritas as diversas estrat�gias de deriva��o aplicadas no jogo, sendo
que as indicadas por um asterisco foram adicionadas pelo grupo.

	Conway: 

		A estrat�gia padr�o do jogo, tal que apresenta um comportamento
		ca�tico, sendo a mais estudada e analisada. A c�lula se mant�m viva 
		se tiver 2 a 3 vizinhos e ir� reviver apenas se tiver 3 vizinhos.

	HighLife:

		Uma estrat�gia bastante similar a Conway que tamb�m apresenta
		comportamento ca�tico, por�m mostra caracter�sticas de um 
		replicador de formas. Sua diferen�a para a estrat�gia Conway � que a 
		c�lula tamb�m ir� ressucitar se possuir 6 vizinhos.

	*LifeWithoutDeath:

		Tal estrat�gia � bastante intuitiva pelo seu nome e apresenta um 
		car�ter expansivo, as c�lulas nunca ir�o morrer e c�lulas novas 
		ir�o nascer apenas se possuirem 3 vizinhos vivos. Assim, cria 
		diversas formas com comportamento de frascos, tal que ap�s gera��es,
		as c�lulas iniciais se tornar�o uma "maci�a" estrutura com v�rios 
		"buracos".

	LiveFreeOrDie:

		Estrat�gia que possui car�ter explosivo, onde as c�lulas ir�o
		sobreviver apenas se n�o tiverem vizinhos e c�lulas ir�o nascer
		somente se possu�rem 2 vizinhos vivos.

	*Maze:

		Esta regra � caracterizada pela sua expans�o que, ap�s algumas
		gera��es, o tabuleiro ir� tomar a forma de um labirinto. No caso,
		c�lulas ir�o se manter vivas se tiverem de 1 a 5 vizinhos vivos, e 
		c�lulas mortas nascer�o apenas se possuirem 3 vizinhos.

	*Mazectric:
		
		Regra que estende de Maze, de forma que, ao inv�s das c�lulas
		sobreviverem at� com 5 vizinhos, a sobreviv�ncia se dar� at� 4 
		vizinhos, a diferen�a entre regras se da pelo fato que a Mazectric 
		apresenta "corredores" de labirinto mais esguios.

	*Move:

		Nesta regra as c�lulas sobreviver�o se possuirem 2, 4 ou 5 vizinhos,
		c�lulas mortas ir�o nascer se possuirem 3, 6 ou 8. A caracter�stica
		de tal regra � que geralmente a estabiliza��o do tabuleiro �
		alcan�ada de maneira mais r�pida que a regra padr�o.

	*Replicator:

		Modelo base de replicador, tal que uma c�lula se mant�m viva ou
		renasce se possuir n�meros �mpares de vizinhos.

	*Seeds:

		Comportamento explosivo de c�lulas, onde todas as c�lulas da atual
		gera��o ir�o continuar, por�m novas c�lulas nascer�o se tiverem
		exatamente 2 vizinhos.

_____________________________________________________________________________________
_____________________________________________________________________________________