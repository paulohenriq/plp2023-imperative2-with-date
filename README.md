# Projeto da disciplina: Paradigmas de Linguagem de Programação 2023.1 (Mestrado acadêmico CIn/UFPE)
A proposta deste trabalho é implementar o tipo date e suas respectivas operações entre datas para a Linguagem Imperativa 2. 

### Equipe:
- Paulo Henrique Gomes Silva
- Pedro Henrique Caminha Lins

### Escopo:
- [x] Implementar o tipo de dados *data*
- [x] Implementar a regra de entrada de uma data de acordo com os formatos: 
BR-dd/mm/yyyy, US-mm/dd/yyyy, JP-yyyy/mm/dd
- [x] Implementar operações entre datas:
	- [x] Comparação (===)
	- [x] Diferença em dias entre duas datas (---)

## BNF
```
Programa ::= Comando
Comando ::= Atribuicao
              | ComandoDeclaracao
              | While
              | IfThenElse
              | IO
              | Comando ";" Comando
              | Skip
              | ChamadaProcedimento
Skip ::=
Atribuicao ::= Id ":=" Expressao
Expressao ::= Valor | ExpUnaria | ExpBinaria | Id
Valor ::= ValorConcreto
ValorConcreto ::= ValorInteiro | ValorBooleano | ValorString | <a href="#">ValorData</a>
ExpUnaria ::= "-" Expressao | "not" Expressao | "length" Expressao
ExpBinaria ::= Expressao "+" Expressao
                  | Expressao "-" Expressao
                  | Expressao "and" Expressao
                  | Expressao "or" Expressao
                  | Expressao "==" Expressao
                  | Expressao "++" Expressao
		              | <a href="#">Expressao "---" Expressao</a>
                  | <a href="#">Expressao "===" Expressao</a>
ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"
Declaracao ::= DeclaracaoVariavel
                  | DeclaracaoProcedimento
                  | DeclaracaoComposta
DeclaracaoVariavel ::= "var" Id "=" Expressao 
DeclaracaoComposta ::= Declaracao "," Declaracao
DeclaracaoProcedimento ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"
ListaDeclaracaoParametro ::= Tipo Id | Tipo Id "," ListaDeclaracaoParametro
Tipo ::= "string" | "int" | "boolean" | <a href="#">"data"</a>
While ::= "while" Expressao "do" Comando
IfThenElse ::= "if" Expressao "then" Comando "else" Comando
IO ::= "write" "(" Expressao ")" | "read" "(" Id ")"
ChamadaProcedimento ::= "call" Id "(" [ ListaExpressao ] ")" 
ListaExpressao ::= Expressao | Expressao, ListaExpressao
```
## Execução

* Local

```bash
cd <Linguagem>
mvn clean generate-sources compile exec:java
```

* Applet

```bash
mvn package
# Jar será gerado em ./Applet/target/
```
