declare variable $doc external;
for $x in $doc

return
(

if ( exists($doc/books/book/title) )
then
( data($doc/books/book/title) )
else ("") ,

if ( exists($doc/books/book/[local-name='author']) )
then
( data($doc/books/book/author) )
else ("") ,

if ( exists($doc/books/book/year) )
then
( data($doc/books/book/year) )
else ("") ,

if ( exists($doc/books/book/price) )
then
( data($doc/books/book/price) )
else ("")

)