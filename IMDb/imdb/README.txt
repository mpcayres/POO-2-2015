_____________________________________________________________________________________

 IMDb
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informa��es a cerca das mudan�as na implementa��o da plataforma
IMDb desenvolvida na disciplina Programa��o Orienta a Objetos

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

O projeto em quest�o foi desenvolvido em linguagem Java, os requisitos do projeto
IMDb tem como enfoque a cria��o de banco de dados relacionados a Produ��es
Art�sticas e conceitos derivat�rios, como Albums Musicais, Autores, Filmes e G�neros.
Para realizar a implementa��o do banco de dados e suas devidas funcionali-
dades foi usado em conjunto com a linguagem Java, a API JPA(Java Persistence API) assim 
como o framework Hibernate, que tem como principal objetivo abstrair o c�digo
SQL necess�rio para o uso do banco de dados, ou seja, a partir da inser��o de metadados
nas classes, atributos e m�todos do c�digo java, conseguimos mapear tais atributos em
nosso banco de dados.Com tais conceitos do modelo entidade relacionamento elaboramos
o modelo conceitual que segue com a imagem anexada ao folder do programa.

_____________________________________________________________________________________

 2) INSTRU��ES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na op��o "File" e, ent�o, "Import"
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	3. Com o projeto criado, deve-se adentrar a pasta lib dentro do folder impor-
	   tado, e adicionar todos os arquivos ".jar" ao classpath da IDE.Ap�s isso a
	   brir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a �nica op��o que surgir para main
	   Class em "Search...";

	   Antes de iniciar uma nova interface, conferir que n�o outra inst�ncia da mesma
	   aberta, uma vez que o banco de dados utilizado � o mesmo, ambas janelas en-
	   trariam em conflito.

	4. A interface que rege o programa se relaciona com o usu�rio realizando as
	   devidas opera��es com o banco de dados, segue a seguinte disposi��o de telas:

	4.1.Tela Inicial:
	Apresenta a escolha de que forma o usu�rio ir� se comportar com
	o programa, seja como usu�rio para realizar consultas ou avalia��es, ou como
	gerente, para adicionar/editar/remover qualquer tipo de classe dentro da especi-
	fica��o do IMDb. Ambas as escolhas de comportamento ser�o regidas por usu�rio
	e senha.
	
	4.2.Tela Usu�rio: 
	Caso a escolha da tela inicial seja de usu�rio, a interface ser�
	alterada para comportar duas escolhas consultar ou avaliar, de maneira intuitiva
	ao escolher o modo consulta ser�o dispostas as op��es(�lbum, Filme, Autor, G�nero),
	tal que as pr�ximas telas ir�o possuir todos os objetos envolvidos os quais esta-
	r�o dispostos em COMBOBOX, maneira de visualiza��o escolhida para utilizar em con
	junto com java swing. Caso a escolha seja de avalia��o, al�m de somente apresentar
	as caracter�sticas do objeto, ser� disposto caixas de texto e COMBOBOX de avalia��o.
	A avalia��o s� poder ser realizada a um �lbum Musical ou Filme.

	4.3.Tela Gerenciamento:
	Nesta tela � poss�vel realizar a escolha entre editar, adicionar/registrar, ou remo-
	ver objetos ao banco de dados.
	
		4.3.1 Tela de Adi��o: 
			Em modo gerenciamento caso seja escolhido adicionar objetos, a inter-
			face apresentar� ao usu�rio o que pode ser adicionado (�lbum, Filme,
			Autor, G�nero, Usu�rio).
			
			Adicionar �lbuns requer 4 informa��es: T�tulo, Ano de Produ��o, Autor
			e G�nero, caso seja informado um autor ou g�nero que n�o esteja pre-
			sente no banco de dados, o mesmo ser� adicionado em conjunto com o 
			�lbum. Para adicionar novas faixas ao �lbum � necess�rio ao preencher
			todos os campos apertar em "Aplicar", s� ap�s disso redirecionar ao bo-
			t�o de adicionar faixas, tal que as faixas musicais s�o entidades fra-
			cas e diretamente relacionadas aos �lbuns.
			
			Adicionar Filmes requer as mesmas 4 informa��es dos �lbuns Musicais,
			mas com adi��o de sua dura��o. Caso se informe autores e g�neros n�o
			existentes eles tamb�m ser�o criados juntamente.

			Adicionar Autores e G�neros apresentam a mesma caracter�stica, s�o regi-
			dos por um nome/t�tulo, e uma simples descri��o, Autores adicionados in-
			diretamente ao se adicionar �lbuns e Filmes ter�o descri��o "null".

			Adicionar Usu�rios requer 5 informa��es, o nickname do usu�rio,
			sua senha, seu Nome, data de nascimento, e por ultimo a op��o se este
			ser� considerado apto a gerenciamento ou n�o.			

		4.3.2 Tela de Remo��o:
			As op��es de remo��o s�o comuns a todos os tipos de classes, ser� dado
			uma lista de objetos existentes de acordo com oque se est� deletando, 
			o usu�rio ir� selecionar qual deve ser deletado do banco de dados.


		IMPORTANTE: Clicar no bot�o aplicar apenas uma vez, visto que a opera��o ser�
			    realizada com apenas a primeira a��o, ap�s isso clicar no bot�o vol-
			    tar, ou alterar as informa��es fornecidas de acordo com o procedimento.
			    Sempre tentar preencher todos os campos em caso de adi��o, edi��o
			    e avalia��o.
	
	Observa��o: o programa foi desenvolvido como Maven Project, para permitir a
	implementa��o da Java Persistence API. Caso n�o tenha vindo instalado junto 
	com sua IDE e isso fa�a com que ocorra um erro na importa��o, procure provid
	enciar a instala��o dele em sua m�quina ou baixe a vers�o mais recente do 
	Eclipse (Kepler 4.3 e posteriores) que j� o ter� integrado, foi utilizado a
	vers�o mais recente(5.0.5) do framework Hibernate. 

	� criado o usu�rio gerente para testes cujos dados s�o:
	Login: admin
	Senha: 0000

	Arquivos ".xml" se encontram na pasta resources, adentrando a pasta src vista pelo Eclipse

_____________________________________________________________________________________

 3) MUDAN�AS GERAIS
____________________

Segue abaixo uma lista com as mudan�as efetuadas, de acordo com o que foi
especificado:

	- Cria��o das classes especificas para avalia��o, autor, faixa musical, usuario
	filme e �lbum.
	- Adi��o de fun��es de utilidade como adicionar, editar e excluir para todas as
	classes sempre realizando a intera��o com o banco de dados.
	- Devida intera��o com o banco de dados fornecido pelo JPA - Hibernate para 
	as classes Autor e G�nero, assim como sua correta inser��o e remo��o.
	- Interface criada totalmente para acomodar todas as funcionalidades especifi-
	cadas.

_____________________________________________________________________________________

 4) DIFICULDADES E ERROS ENCONTRADOS
____________________

As principais dificuldades encontradas ao realizar o projeto, se encontra principalmente
na intera��o interface com o banco de dados, os principais erros encontrados e de maior re-
lev�ncia s�o:
	- Os objetos de �lbum Musical, Filme e Usu�rio n�o est�o sendo salvos fora da sess�o
	atual, ou seja, eles s�o criado e mantidos at� se fechar o programa.
	- Problemas em editar �lbuns musicais.
	- Problemas de associar os dados de Avalia��o e faixa a interface gr�fica, atrelado
	as chaves estrangeiras usadas.


_____________________________________________________________________________________
_____________________________________________________________________________________