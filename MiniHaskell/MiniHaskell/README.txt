_____________________________________________________________________________________

	MiniHaskell
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informa��es a cerca das mudan�as na implementa��o do projeto
MiniHaskell desenvolvido na disciplina Programa��o Orienta a Objetos e tem como prin-
cipal caracter�stica a utiliza��o do padr�o de projeto visitor.

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

O modelo de linguagem Haskell desenvolvido a partir da linguagem java apresenta a capa-
cidade de realizar express�es e atribui��es simples utilizando a estrat�gia Visitor Pa-
ttern, que em sintase � utilizada para criar novas opera��es sem que se mude a classe 
dos elementos que s�o operados, muito relacionado a �rvores bin�rias como um mode-
lo de visita rescursiva aos n�s.

_____________________________________________________________________________________

 2) INSTRU��ES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na op��o "File" e, ent�o, "Import"
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	   Ap�s isso abrir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a �nica op��o que surgir para main
	   Class em "Search...";
	   Nisto o console da IDE Eclipse funcionara como cmd.
	3. Os testes realizados podem ter seu resultado visto rodando o projeto como JUnit.

	
	Observa��o: o programa foi desenvolvido como Maven Project. Caso o maven n�o
	tenha vindo instalado juntocom sua IDE e isso fa�a com que ocorra um erro na
	importa��o, procure providenciar a instala��o dele em sua m�quina ou baixe a 
	vers�o mais recente doEclipse (Kepler 4.3 e posteriores) que j� o ter� integrado.

_____________________________________________________________________________________

 3) MUDAN�AS GERAIS
____________________

Segue abaixo uma lista com as mudan�as efetuadas, de acordo com o que foi
especificado:

	- Convertida a interface "Expressao" para classe abstrata.
	- Criadas classes Multiplicacao, Igualdade, MaiorIgual, MenorIgual, Fatorial 
	  e seus respectivos testes.
	- Implementa��o do tipo Lista sem utilizar a biblioteca List.util e considerando
	  os seus termos como do tipo Object, para n�o restringir ao demais valores j�
	  criados.
	- Elabora��o de diversos m�todos relativos a manipula��o de Lista, a exemplo de:
	  adi��o e remo��o (no in�cio, ao final e em posi��es aleat�rias), determinar se uma
	  posi��o est� vazia, encontrar um elemento espec�fico, verificar se um elemento
	  existe, retorno do tamanho da lista, analisar se a lista est� vazia, elimina��o
	  de todos os elementos da lista e transforma��o desta em uma String, facilitando a
	  impress�o na tela.
	- Fun��es de manipula��o de lista, como adi��o, remo��o, tamanho e derivados.
	- Cria��o de novos testes tendo como principal foco testar as fun��es j� citadas
	  anteriormente, juntamente com: AplicacaoDeFuncao, ExpressaoLet e IfThenElse.
	- Pequenos ajustes em fun��es j� existentes para corre��o de erros.
	- Elabora��o de visitors para todas as classes criadas e que n�o tinham seus
	  respectivos, al�m da corre��o dos visitors ditos como "quebrados".

_____________________________________________________________________________________

 4) DIFICULDADES E ERROS ENCONTRADOS
____________________

Segue abaixo a listagem das dificuldades e erros enfrentados durante a elabora��o do trabalho:

	- Elabora��o de uma inteface que interprete diretamente a linguagem do MiniHaskell e
	  se relacione com o c�digo elaborado, por meio de parser.
	- Encontrar formas de implementar o valor do tipo Lista sem a utiliza��o de bibliotecas
	  j� existentes e com a impossibilidade de uso de ponteiro.
	- Compreender na totalidade o padr�o de projeto Visitor e as melhores formas de
	  implementa��o.

_____________________________________________________________________________________
_____________________________________________________________________________________