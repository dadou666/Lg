grammar lg;
system : ( element   )*;

element : type | function | defPredicat | constante;
constante :'const' ID tmpCode;
type  :  abstractFlag 'type' (multiple | simple ) ( superType | )  '{' champs  '}' ;
abstractFlag :'abstract'  | ;
superType :      (':' ID )  ;
champs : champ *;
champ : defType ':' ID ;
multiple : '*' ID ;
simple : ID ;
typeBase :  multiple | simple ;
attribut : ID '='  tmpCode ;
defTypeFunction : '[' defTypes ']' '->' defType;
defTypes :defType *;
defType :  typeBase  | defTypeFunction ; 
attributs : attribut * ;
code :(  ('(' code ')' ) |  (appel|creerNombre|creerListe| creer | var | ('(' (  si) ')' ) ) ) operationOuAcces *    ;
var : ID ;
appel :  ID '(' tmpCode * ')' ;
creer : (simple | multiple ) '{' attributs  '}';
creerListe : ID '[' (  (('{' attributs  '}' ) + )      ) ']' ;

creerNombre :'$' ID  V;

acces :  '.' ID ;
operation : operateur tmpCode;
operationOuAcces :  (acces |operation )  ;
operateur : '->' |'=>' | '+' | '-' |'*' |'/'|'>' | '<' |'@'  | '%'|'&' |'|' |'=' ;

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
ID : [a-zA-Z0-9]+  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines