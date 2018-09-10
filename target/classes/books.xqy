declare variable $doc external;
for $x in $doc

return
(

if ( exists($doc/books/book//*[local-name()='title']) )
then
( data($doc/books/book//*[local-name()='title']) )
else ("") ,

if ( exists($doc/books/book//*[local-name()='author']) )
then
( data($doc/books/book//*[local-name()='author'] ) )
else ("") ,

if ( exists($doc/books/book//*[local-name()='year']) )
then
( data($doc/books/book//*[local-name()='year']) )
else ("") ,

if ( exists($doc/books/book//*[local-name()='price']) )
then
( data($doc/books/book//*[local-name()='price']) )
else ("")

)