grammar lg;
system : ( element   )*;
element : exist | all ;

superType :      (':' ID )  ;
champs : champ *;
champ : (multiple | simple ) ':' ID ;
multiple : '*' ID ;
simple : ID ;
attribut : ID ':' (si | code );
attributs : attribut * ;
code :(  ('(' code ')' ) |  (creerListe| creer | var ) ) (appel |acces |operation ) *   ;
var : ID ;
appel :  '.' ID '(' tmpCode * ')' ;
creer : (simple | multiple ) '{' attributs  '}';
creerListe : ID '[' (  (('{' attributs  '}' ) + )      ) ']' ;



acces :  '@' ID ;
operation : operateur tmpCode;
operateur :'+' | '-' |'*' |'/'|'>' | '<';
  
local :'let' ID '=' tmpCode 'in' tmpCode ;

tmpCode :  si |local |code | '(' tmpCode ')'  ;

predicat : '(' (   egalite  | testType | operationLogique | negation ) ')' 
egalite = code '=' code;
negation = '!' predicat ;
testType = code 'is' (multiple | simple );
operateurLogique : '&' | '|' | '->' ;
operationLogique : predicat ( operateurLogique  predicat ) *



 
exist : 'All' (multiple | simple ) ':' var ( predicat | exist | all )
all : 'All' (multiple | simple ) ':' var ( predicat | exist | all ) 





    // match keyword hello followed by an identifier
V : [0-9]+;  
ID : [a-zA-Z0-9]+  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines