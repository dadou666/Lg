grammar lg;
system : ( element   )*;

element : type | function | defPredicat | constante;
constante :'const' ID tmpCode;
type  :  abstractFlag 'type' (multipleFlag | ) ID  ( superType | )  '{' champs  '}' ;
multipleFlag :'@';
abstractFlag :'abstract'  | ;
superType :      (':' (ID | id_externe ) )  ;
champs : champ *;
champ : defType ':' ID ;
multiple :  '@' ( ID| id_externe ) ;
simple : (ID |id_externe );
typeBase :  multiple | simple ;
attribut : ID '='  tmpCode ;
defTypeFunction : '[' defTypes ']' '->' defType;
defTypes :defType *;
defType :  typeBase  | defTypeFunction ; 
attributs : attribut * ;
code :(  ('(' code ')' ) |  (appel|creerListe| creer | var  |entier| ('(' (  si) ')' ) ) ) operationOuAcces *    ;
var : metaModele (ID |id_externe);
metaModele : '%' | ;
entier : ENTIER | ENTIER_EXTERNE;
appel :  (fonctionRefAppel  | functionDef ) '(' tmpCode * ')' ;
flagMultiple : '@' ;
creer : ( flagMultiple | )  ( ID| id_externe ) '{' attributs  '}';
creerListe : ID '[' (  (('{' attributs  '}' ) + )      ) ']' ;


id_externe : ID '$' ID;
acces :  '.' ID ;
fonctionRefAppel : ( ID | id_externe ) acces*;
operation : operateur tmpCode;
operationOuAcces :  (acces |operation )  ;
operateur : '->' |'=>' | '+' | '-' |'*' |'/'|'>' | '<'  | '&' |'|' |'=' ;

si :  'if' code 'is' negation (simple | multiple ) 'then' code 'else' ( si |code );
negation : '!' | ;  
function : 'function'   (ID|operateur)  champs '|' tmpCode;
functionDef : '#' '{' champs '|' tmpCode  '}';
functionLocal : ID '=' champs '|' tmpCode;

tmpCode : functionDef| appel | si  |code | '(' tmpCode ')'  ;

exist : 'Exist' champs '|'  (exist | all | estType);
all :'All' champs '|' (exist | all | estType);
estType : tmpCode 'is'  defType;


defPredicat : 'predicat' ID  champs '|'  ( exist | all  );



    // match keyword hello followed by an identifier
ENTIER : [1-9][0-9]*ID('$'ID|);
ENTIER_EXTERNE : [1-9][0-9]*ID('$'ID|);
ID : [a-zA-Z_][a-zA-Z0-9_]*  ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines