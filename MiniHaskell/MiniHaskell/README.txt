_____________________________________________________________________________________

	MiniHaskell
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informações a cerca das mudanças na implementação do projeto
MiniHaskell desenvolvido na disciplina Programação Orienta a Objetos e tem como prin-
cipal característica a utilização do padrão de projeto visitor.

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

O modelo de linguagem Haskell desenvolvido a partir da linguagem java apresenta a capa-
cidade de realizar expressões e atribuições simples utilizando a estratégia Visitor Pa-
ttern, que em sintase é utilizada para criar novas operações sem que se mude a classe 
dos elementos que são operados, muito relacionado a árvores binárias como um mode-
lo de visita rescursiva aos nós.

_____________________________________________________________________________________

 2) INSTRUÇÕES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na opção "File" e, então, "Import"
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	   Após isso abrir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a única opção que surgir para main
	   Class em "Search...";
	   Nisto o console da IDE Eclipse funcionara como cmd.
	3. Os testes realizados podem ter seu resultado visto rodando o projeto como JUnit.

	
	Observação: o programa foi desenvolvido como Maven Project. Caso o maven não
	tenha vindo instalado juntocom sua IDE e isso faça com que ocorra um erro na
	importação, procure providenciar a instalação dele em sua máquina ou baixe a 
	versão mais recente doEclipse (Kepler 4.3 e posteriores) que já o terá integrado.

_____________________________________________________________________________________

 3) MUDANÇAS GERAIS
____________________

Segue abaixo uma lista com as mudanças efetuadas, de acordo com o que foi
especificado:

	- Convertida a interface "Expressao" para classe abstrata.
	- Criadas classes Multiplicacao, Igualdade, MaiorIgual, MenorIgual, Fatorial 
	  e seus respectivos testes.
	- Implementação do tipo Lista sem utilizar a biblioteca List.util e considerando
	  os seus termos como do tipo Object, para não restringir ao demais valores já
	  criados.
	- Elaboração de diversos métodos relativos a manipulação de Lista, a exemplo de:
	  adição e remoção (no início, ao final e em posições aleatórias), determinar se uma
	  posição está vazia, encontrar um elemento específico, verificar se um elemento
	  existe, retorno do tamanho da lista, analisar se a lista está vazia, eliminação
	  de todos os elementos da lista e transformação desta em uma String, facilitando a
	  impressão na tela.
	- Funções de manipulação de lista, como adição, remoção, tamanho e derivados.
	- Criação de novos testes tendo como principal foco testar as funções já citadas
	  anteriormente, juntamente com: AplicacaoDeFuncao, ExpressaoLet e IfThenElse.
	- Pequenos ajustes em funções já existentes para correção de erros.
	- Elaboração de visitors para todas as classes criadas e que não tinham seus
	  respectivos, além da correção dos visitors ditos como "quebrados".

_____________________________________________________________________________________

 4) DIFICULDADES E ERROS ENCONTRADOS
____________________

Segue abaixo a listagem das dificuldades e erros enfrentados durante a elaboração do trabalho:

	- Elaboração de uma inteface que interprete diretamente a linguagem do MiniHaskell e
	  se relacione com o código elaborado, por meio de parser.
	- Encontrar formas de implementar o valor do tipo Lista sem a utilização de bibliotecas
	  já existentes e com a impossibilidade de uso de ponteiro.
	- Compreender na totalidade o padrão de projeto Visitor e as melhores formas de
	  implementação.

_____________________________________________________________________________________
_____________________________________________________________________________________