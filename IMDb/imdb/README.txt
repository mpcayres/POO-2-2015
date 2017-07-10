_____________________________________________________________________________________

 IMDb
_____________________________________________________________________________________

  Readme.txt

  Esse ReadMe apresenta informações a cerca das mudanças na implementação da plataforma
IMDb desenvolvida na disciplina Programação Orienta a Objetos

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

O projeto em questão foi desenvolvido em linguagem Java, os requisitos do projeto
IMDb tem como enfoque a criação de banco de dados relacionados a Produções
Artísticas e conceitos derivatórios, como Albums Musicais, Autores, Filmes e Gêneros.
Para realizar a implementação do banco de dados e suas devidas funcionali-
dades foi usado em conjunto com a linguagem Java, a API JPA(Java Persistence API) assim 
como o framework Hibernate, que tem como principal objetivo abstrair o código
SQL necessário para o uso do banco de dados, ou seja, a partir da inserção de metadados
nas classes, atributos e métodos do código java, conseguimos mapear tais atributos em
nosso banco de dados.Com tais conceitos do modelo entidade relacionamento elaboramos
o modelo conceitual que segue com a imagem anexada ao folder do programa.

_____________________________________________________________________________________

 2) INSTRUÇÕES
_______________

	1. Utilizando a IDE Java Eclipse, clicar na opção "File" e, então, "Import"
	   Projects from Folder...";
	2. Selecionar a pasta que foi descompctada, clicar em "Next" e "Finish";
	3. Com o projeto criado, deve-se adentrar a pasta lib dentro do folder impor-
	   tado, e adicionar todos os arquivos ".jar" ao classpath da IDE.Após isso a
	   brir o programa e clicar em "Run" ou selecionar "Run Configurations...",
	   escolher o projeto em "Browse..." e a única opção que surgir para main
	   Class em "Search...";

	   Antes de iniciar uma nova interface, conferir que não outra instância da mesma
	   aberta, uma vez que o banco de dados utilizado é o mesmo, ambas janelas en-
	   trariam em conflito.

	4. A interface que rege o programa se relaciona com o usuário realizando as
	   devidas operações com o banco de dados, segue a seguinte disposição de telas:

	4.1.Tela Inicial:
	Apresenta a escolha de que forma o usuário irá se comportar com
	o programa, seja como usuário para realizar consultas ou avaliações, ou como
	gerente, para adicionar/editar/remover qualquer tipo de classe dentro da especi-
	ficação do IMDb. Ambas as escolhas de comportamento serão regidas por usuário
	e senha.
	
	4.2.Tela Usuário: 
	Caso a escolha da tela inicial seja de usuário, a interface será
	alterada para comportar duas escolhas consultar ou avaliar, de maneira intuitiva
	ao escolher o modo consulta serão dispostas as opções(Álbum, Filme, Autor, Gênero),
	tal que as próximas telas irão possuir todos os objetos envolvidos os quais esta-
	rão dispostos em COMBOBOX, maneira de visualização escolhida para utilizar em con
	junto com java swing. Caso a escolha seja de avaliação, além de somente apresentar
	as características do objeto, será disposto caixas de texto e COMBOBOX de avaliação.
	A avaliação só poder ser realizada a um Álbum Musical ou Filme.

	4.3.Tela Gerenciamento:
	Nesta tela é possível realizar a escolha entre editar, adicionar/registrar, ou remo-
	ver objetos ao banco de dados.
	
		4.3.1 Tela de Adição: 
			Em modo gerenciamento caso seja escolhido adicionar objetos, a inter-
			face apresentará ao usuário o que pode ser adicionado (Álbum, Filme,
			Autor, Gênero, Usuário).
			
			Adicionar Álbuns requer 4 informações: Título, Ano de Produção, Autor
			e Gênero, caso seja informado um autor ou gênero que não esteja pre-
			sente no banco de dados, o mesmo será adicionado em conjunto com o 
			álbum. Para adicionar novas faixas ao álbum é necessário ao preencher
			todos os campos apertar em "Aplicar", só após disso redirecionar ao bo-
			tão de adicionar faixas, tal que as faixas musicais são entidades fra-
			cas e diretamente relacionadas aos Álbuns.
			
			Adicionar Filmes requer as mesmas 4 informações dos Álbuns Musicais,
			mas com adição de sua duração. Caso se informe autores e gêneros não
			existentes eles também serão criados juntamente.

			Adicionar Autores e Gêneros apresentam a mesma característica, são regi-
			dos por um nome/título, e uma simples descrição, Autores adicionados in-
			diretamente ao se adicionar Álbuns e Filmes terão descrição "null".

			Adicionar Usuários requer 5 informações, o nickname do usuário,
			sua senha, seu Nome, data de nascimento, e por ultimo a opção se este
			será considerado apto a gerenciamento ou não.			

		4.3.2 Tela de Remoção:
			As opções de remoção são comuns a todos os tipos de classes, será dado
			uma lista de objetos existentes de acordo com oque se está deletando, 
			o usuário irá selecionar qual deve ser deletado do banco de dados.


		IMPORTANTE: Clicar no botão aplicar apenas uma vez, visto que a operação será
			    realizada com apenas a primeira ação, após isso clicar no botão vol-
			    tar, ou alterar as informações fornecidas de acordo com o procedimento.
			    Sempre tentar preencher todos os campos em caso de adição, edição
			    e avaliação.
	
	Observação: o programa foi desenvolvido como Maven Project, para permitir a
	implementação da Java Persistence API. Caso não tenha vindo instalado junto 
	com sua IDE e isso faça com que ocorra um erro na importação, procure provid
	enciar a instalação dele em sua máquina ou baixe a versão mais recente do 
	Eclipse (Kepler 4.3 e posteriores) que já o terá integrado, foi utilizado a
	versão mais recente(5.0.5) do framework Hibernate. 

	É criado o usuário gerente para testes cujos dados são:
	Login: admin
	Senha: 0000

	Arquivos ".xml" se encontram na pasta resources, adentrando a pasta src vista pelo Eclipse

_____________________________________________________________________________________

 3) MUDANÇAS GERAIS
____________________

Segue abaixo uma lista com as mudanças efetuadas, de acordo com o que foi
especificado:

	- Criação das classes especificas para avaliação, autor, faixa musical, usuario
	filme e álbum.
	- Adição de funções de utilidade como adicionar, editar e excluir para todas as
	classes sempre realizando a interação com o banco de dados.
	- Devida interação com o banco de dados fornecido pelo JPA - Hibernate para 
	as classes Autor e Gênero, assim como sua correta inserção e remoção.
	- Interface criada totalmente para acomodar todas as funcionalidades especifi-
	cadas.

_____________________________________________________________________________________

 4) DIFICULDADES E ERROS ENCONTRADOS
____________________

As principais dificuldades encontradas ao realizar o projeto, se encontra principalmente
na interação interface com o banco de dados, os principais erros encontrados e de maior re-
levência são:
	- Os objetos de Álbum Musical, Filme e Usuário não estão sendo salvos fora da sessão
	atual, ou seja, eles são criado e mantidos até se fechar o programa.
	- Problemas em editar Álbuns musicais.
	- Problemas de associar os dados de Avaliação e faixa a interface gráfica, atrelado
	as chaves estrangeiras usadas.


_____________________________________________________________________________________
_____________________________________________________________________________________