# Projeto da disciplina: Paradigmas de Linguagem de Programação 2023.1 (Mestrado acadêmico CIn/UFPE)
A proposta deste trabalho é implementar o tipo date e suas respectivas operações entre datas para a Linguagem Imperativa 2. 

### Equipe:
- Paulo Henrique Gomes Silva
- Pedro Henrique Caminha Lins

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
Expressao ::= Valor | ExpUnaria | ExpBinaria | Id | OperacaoData
Valor ::= ValorConcreto
ValorConcreto ::= ValorInteiro | ValorBooleano | ValorString
ExpUnaria ::= "-" Expressao | "not" Expressao | "length" Expressao
ExpBinaria ::= Expressao "+" Expressao
                  | Expressao "-" Expressao
                  | Expressao "and" Expressao
                  | Expressao "or" Expressao
                  | Expressao "==" Expressao
                  | Expressao "++" Expressao
OperacaoData ::= ConversaoData | OperacaoComData
ConversaoData ::= "toDate" "(" ValorString "," ValorString ")"
OperacaoComData ::= Expressao "+" Expressao
                      | Expressao "-" Expressao
                      | Expressao "<" Expressao
                      | Expressao ">" Expressao
                      | Expressao "<=" Expressao
                      | Expressao ">=" Expressao
                      | Expressao "==" Expressao
                      | ContagemDias
ContagemDias ::= "countDays" "(" ValorString "," ValorString ")"
ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"
Declaracao ::= DeclaracaoVariavel
                  | DeclaracaoProcedimento
                  | DeclaracaoComposta
DeclaracaoVariavel ::= "var" Id "=" Expressao 
DeclaracaoComposta ::= Declaracao "," Declaracao
DeclaracaoProcedimento ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"
ListaDeclaracaoParametro ::= Tipo Id | Tipo Id "," ListaDeclaracaoParametro
Tipo ::= "string" | "int" | "boolean" | "date"
While ::= "while" Expressao "do" Comando
IfThenElse ::= "if" Expressao "then" Comando "else" Comando
IO ::= "write" "(" Expressao ")" | "read" "(" Id ")"
ChamadaProcedimento ::= "call" Id "(" [ ListaExpressao ] ")" 
ListaExpressao ::= Expressao | Expressao, ListaExpressao
```
