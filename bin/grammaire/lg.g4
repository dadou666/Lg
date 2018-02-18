grammar lg;
system : ( element   )*;

element : type | function | defPredicat | constante;
constante :'const' ID tmpCode;
type  :  abstractFlag 'type' (multipleFlag | ) ID  ( superType | )  '{' champs  '}' ;
multipleFlag :'*';
abstractFlag :'abstract'  | ;
superType :      (':' (ID | id_externe ) )  ;
champs : champ *;
champ : defType ':' ID ;
multiple : '*' ( ID| id_externe ) ;
simple : (ID |id_externe );
typeBase :  multiple | simple ;
attribut : ID '='  tmpCode ;
defTypeFunction : '[' defTypes ']' '->' defType;
defTypes :defType *;
defType :  typeBase  | defTypeFunction ; 
attributs : attribut * ;
code :(  ('(' code ')' ) |  (appel|creerListe| creer | var | ('(' (  si) ')' ) ) ) operationOuAcces *    ;
var : ID ;
appel :  (ID | id_externe ) '(' tmpCode * ')' ;
creer : (simple | multiple ) '{' attributs  '}';
creerListe : ID '[' (  (('{' attributs  '}' ) + )      ) ']' ;


id_externe : ID '$' ID;
acces :  '.' ID ;
operation : operateur tmpCode;
operationOuAcces :  (acces |operation )  ;
operateur : '->' |'=>' | '+' | '-' |'*' |'/'|'>' | '<'  | '%'|'&' |'|' |'=' ;

si :  'if' code 'is' negation (simple | multiple ) 'then' code 'else' ( si |code );
negation : '!' | ;  
function : 'function'   (ID|operateur)  champs '|' tmpCode;
functionDef : '#' '{' champs '|' tmpCode  functionLocal * '}';
functionLocal : ID '=' champs '|' tmpCode;

tmpCode : functionDef| appel | si  |code | '(' tmpCode ')'  ;

exist : 'Exist' champs '|'  (exist | all | estType);
all :'All' champs '|' (exist | all | estType);
estType : tmpCode 'is'  defType;


defPredicat : 'predicat' ID  champs '|'  ( exist | all  );



    // match keyword hello followed by an identifier
V : [0-9]+;  
ID : [a-zA-Z0-9_]+  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines